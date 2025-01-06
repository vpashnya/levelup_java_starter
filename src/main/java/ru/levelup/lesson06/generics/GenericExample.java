package ru.levelup.lesson06.generics;

import ru.levelup.lesson06.taskclasses.Animal;

import java.io.Serializable;

public class GenericExample<T extends Comparable, V extends Animal & Serializable, K extends Number> {
    T name;
    V animalObj;
    K weight;

    public GenericExample(T name, V animalObj, K weight) {
        this.name = name;
        this.animalObj = animalObj;
        this.weight = weight;
    }

    public T getName() {
        return name;
    }

    public V getAnimalObj() {
        return animalObj;
    }

    public K getWeight() {
        return weight;
    }

    public String getFieldsNames() {
        return " name : " + this.getName() + " : " + this.getName().getClass() + " \n"
                + " animalObj : " + this.getAnimalObj() + " : " + this.getAnimalObj() .getClass() + " \n"
                + " weight : " + this.getWeight() + " : " + this.getWeight().getClass() + "\n";

    }
}
