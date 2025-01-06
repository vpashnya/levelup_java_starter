package ru.levelup.lesson06;

import ru.levelup.lesson06.generics.GenericExample;
import ru.levelup.lesson06.taskclasses.*;

public class GenericLauncher {
    public static void main(String[] args) {
        GenericExample<String, Animal, Integer> dogInfo = new GenericExample<>("Пес", new Dog(), 12);
        System.out.println(dogInfo.getFieldsNames());

        GenericExample<String, Animal, Long> hourseInfo = new GenericExample<>("Конь", new Horse(), 34L);
        System.out.println(hourseInfo.getFieldsNames());

        GenericExample<StringBuffer, Animal, Float> catInfo = new GenericExample<>(new StringBuffer("Кошка"), new Cat(), 56.78F);
        System.out.println(catInfo.getFieldsNames());

        GenericExample<StringBuilder, Animal, Double> hamsterInfo = new GenericExample<>(new StringBuilder("Хомяк"), new Hamster(), 90.12D);
        System.out.println(hamsterInfo.getFieldsNames());

    }
}
