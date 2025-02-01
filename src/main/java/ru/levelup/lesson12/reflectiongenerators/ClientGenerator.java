package ru.levelup.lesson12.reflectiongenerators;


import ru.levelup.lesson12.clients.CorparateClient;
import ru.levelup.lesson12.clients.PersonClient;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Stream;

public class ClientGenerator {
    public static CorparateClient generateCorp(String fullName, String inn, String ogrn) throws IllegalAccessException, InstantiationException {
        CorparateClient corp = CorparateClient.class.newInstance();

        Stream.concat(Arrays.stream(corp.getClass().getDeclaredFields())
                        , Arrays.stream(corp.getClass().getSuperclass().getDeclaredFields()))
                .forEach(f -> {
                            f.setAccessible(true);
                            String value = null;
                            switch (f.getName()) {
                                case "fullName" -> value = fullName;
                                case "inn" -> value = inn;
                                case "ogrn" -> value = ogrn;
                                default -> {
                                    value = null;
                                }
                            }
                            try {
                                f.set(corp, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

        return corp;

    }

    public static PersonClient generatePerson1(String fullName, String inn, String surName, String name, String fatherName) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        PersonClient person = (PersonClient) PersonClient.class.getConstructor().newInstance();

        Stream.concat(Arrays.stream(person.getClass().getDeclaredFields())
                        , Arrays.stream(person.getClass().getSuperclass().getDeclaredFields()))
                .forEach(f -> {
                            f.setAccessible(true);
                            String value =
                                    switch (f.getName()) {
                                        case "fullName" -> fullName;
                                        case "inn" -> inn;
                                        case "surName" -> surName;
                                        case "name" -> name;
                                        case "fatherName" -> fatherName;
                                        default -> null;
                                    };
                            try {
                                f.set(person, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

        return person;

    }

    public static PersonClient generatePerson2(String inn, String surName, String name, String fatherName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?>[] constArgs = {String.class, String.class, String.class, String.class};
        String[] args = {surName, name, fatherName, inn};
        return PersonClient.class.getDeclaredConstructor(constArgs).newInstance(args);
    }
}