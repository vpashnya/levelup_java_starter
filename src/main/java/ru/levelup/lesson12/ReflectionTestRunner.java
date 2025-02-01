package ru.levelup.lesson12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.levelup.lesson12.accounts.AbstractAccount;
import ru.levelup.lesson12.accounts.CorparateAccount;
import ru.levelup.lesson12.accounts.PersonAccount;
import ru.levelup.lesson12.clients.AbstractClient;
import ru.levelup.lesson12.clients.CorparateClient;
import ru.levelup.lesson12.clients.PersonClient;
import ru.levelup.lesson12.reflectiongenerators.AccountGenerator;
import ru.levelup.lesson12.reflectiongenerators.ClientGenerator;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ReflectionTestRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, JsonProcessingException {

        Random random = new Random();
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<AbstractAccount> accounts = Stream.of(
                    //Генерация клиентов через рефлексию
                        ClientGenerator.generateCorp("OOO Рога и Копыта", "100011112", "123456789123")
                        , ClientGenerator.generatePerson1("Петров Афанасий Рэмович", "100011113", "НеПетров", "НеАфанасий", "НеРэмович")
                        , ClientGenerator.generatePerson2("100011114", "Болтов", "Томас", "Грызлович")
                ).map((client -> {
                    //генерация счетов через рефлексию
                    if (client.getClass() == PersonClient.class) {
                        return AccountGenerator.generatePersonAccount((PersonClient) client);
                    } else if (client.getClass() == CorparateClient.class) {
                        return AccountGenerator.generateCorparateAccount((CorparateClient) client);
                    }
                    return null;
                })).map((account -> {
                    //Пополнение снятие через рефлексию
                    Class<?> accClass = account.getClass();
                    try {
                        accClass.getMethod("debet", BigDecimal.class).invoke(account, new BigDecimal(random.nextInt(1000)));
                        accClass.getMethod("credit", BigDecimal.class).invoke(account, new BigDecimal(random.nextInt(1000)));
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    return account;
                })).map(account -> {
                    //вывод private полей через рефлексию
                    Class<?> accClass = account.getClass();
                    StringBuffer sb = new StringBuffer();
                    Arrays.stream(accClass.getSuperclass().getDeclaredFields()).forEach(field -> {
                                field.setAccessible(true);
                                if (List.of("accNum", "balance", "client").contains(field.getName())) {
                                    try {
                                        sb.append(field.get(account));
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                    sb.append(" - ");
                                }
                            }

                    );
                    System.out.println(sb);
                    return account;
                }).map(account -> {
                    // xml и json представление объектов
                    try {
                        System.out.println(xmlMapper.writeValueAsString(account));
                        System.out.println(jsonMapper.writeValueAsString(account));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return account;
                })
                .toList();

    }
}
