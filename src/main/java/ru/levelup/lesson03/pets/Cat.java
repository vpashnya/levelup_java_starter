package ru.levelup.lesson03.pets;

import java.util.Random;

public class Cat extends Pet {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Кошка " + this.getName() + " мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка " + this.getName() + " кушает");
        this.setHungry(false);
    }

    @Override
    public void sleep() {
        System.out.println("Кошка " + this.getName() + " спит");
        this.setHungry(true);
    }

    public void huntingMouse() {
        System.out.println("Кошка " + this.getName() + " охотится на мышь...");

        if (new Random().nextBoolean()) {
            System.out.println("Не поймала мышь");
            this.setHungry(true);
        } else {
            System.out.println("Поймала мышь");
            this.eat();
        }
    }
}
