package ru.levelup.lesson03.pets;

public class Parrot extends Pet {

    private String rememberPharse;

    public Parrot(String name, int age, String rememberPharse) {
        super(name, age);
        this.rememberPharse = rememberPharse;
    }

    @Override
    public void makeNoise() {
        System.out.println("Попугай " + this.getName() + " говорит выученную фразу \"" + this.getRememberPharse() + "\"");
        this.setHungry(true);
    }

    @Override
    public void eat() {
        System.out.println("Попугай " + this.getName() + " кушает");
        this.setHungry(false);
    }

    @Override
    public void sleep() {
        System.out.println("Попугай " + this.getName() + " спит");
        this.setHungry(true);
    }

    public void fly() {
        System.out.println("Попугай " + this.getName() + " летит");
        this.setHungry(true);
    }

    public String getRememberPharse() {
        return rememberPharse;
    }


}
