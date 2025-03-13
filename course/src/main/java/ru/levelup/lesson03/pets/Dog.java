package ru.levelup.lesson03.pets;

public class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Пес " + this.getName() + " гавкает");
    }

    @Override
    public void eat() {
        System.out.println("Пес " + this.getName() + " кушает");
        this.setHungry(false);
    }

    @Override
    public void sleep() {
        System.out.println("Пес " + this.getName() + " спит");
        this.setHungry(true);
    }

    public void chases(Pet pet) {
        System.out.println(this.name + " гоняет " + pet.name);
        this.setHungry(true);
        pet.setHungry(true);
    }

}
