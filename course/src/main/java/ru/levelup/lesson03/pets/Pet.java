package ru.levelup.lesson03.pets;

public abstract class Pet {
    String name;
    int age;

    boolean hungry;

    private Pet() {
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
        this.hungry = true;
    }

    public abstract void makeNoise();

    public abstract void eat();

    public abstract void sleep();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        System.out.println(getName() + " стал " + (hungry ? "голодным" : "сытым"));
        this.hungry = hungry;
    }

}
