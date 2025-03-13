package ru.levelup.lesson03;

import ru.levelup.lesson03.owners.Owner;
import ru.levelup.lesson03.pets.Cat;
import ru.levelup.lesson03.pets.Dog;
import ru.levelup.lesson03.pets.Parrot;
import ru.levelup.lesson03.pets.Pet;

public class PetsLauncher {
    public static void main(String[] args) {
        System.out.println(">>> Про попугая ");
        Parrot parrot = new Parrot("Попка", 10, "Слава КПСС!!!");
        parrot.fly();

        System.out.println(">>> Про кошку ");
        Cat cat = new Cat("Мурка", 3);
        cat.huntingMouse();

        System.out.println(">>> Про собаку ");
        Dog dog = new Dog("Барбос", 5);
        dog.chases(cat);
        dog.chases(parrot);

        System.out.println(">>> Питомцы наводят шум ");
        Pet[] pets = {parrot, cat, dog};
        for (Pet pet : pets) {
            pet.makeNoise();
        }

        System.out.println(">>> Хозяин кормит питомцев ");
        Owner owner = new Owner();
        for (Pet pet : pets) {
            owner.feedPet(pet);
        }

        System.out.println(">>> Питомцы спят ");
        for (Pet pet : pets) {
            parrot.sleep();
        }

    }
}
