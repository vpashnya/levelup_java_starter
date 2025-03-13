package ru.levelup.lesson13;

import ru.levelup.lesson12.accounts.Account;
import ru.levelup.lesson12.reflectiongenerators.AccountGenerator;
import ru.levelup.lesson12.reflectiongenerators.ClientGenerator;
import ru.levelup.lesson13.proxyclasses.AccountProxyHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;


public class AnnotationRunner {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Random random = new Random();

        Stream.concat(
                Stream.of(
                        ClientGenerator.generatePerson2("123456789012", "Горбатый", "Иван", "Михайлович")
                        , ClientGenerator.generatePerson2("123456782012", "Прямой", "Петр", "Ефимович")
                        , ClientGenerator.generatePerson2("773456782012", "Ровный", "Семен", "Рудольфович")

                ).map(client -> AccountGenerator.generatePersonAccount(client))

                , Stream.of(
                        ClientGenerator.generateCorp("ПАО Рога и Копыта", "7708080970", "112233445566")
                        , ClientGenerator.generateCorp("ООО РосНано", "7708080922", "112233445599")
                        , ClientGenerator.generateCorp("ООО РосМега", "7708085970", "772233445566")

                ).map(client -> AccountGenerator.generateCorparateAccount(client))
        ).forEach(a -> {
            Account proxy = (Account) Proxy.newProxyInstance(
                    AnnotationRunner.class.getClassLoader()
                    , new Class[]{Account.class}
                    , new AccountProxyHandler(a)
            );

            System.out.println("В обработке счет " + proxy);
            proxy.credit(new BigDecimal(random.nextInt(1000)));
            proxy.debet(new BigDecimal(random.nextInt(1000)));
            System.out.println(" обработан счет " + proxy);
        });

    }
}
