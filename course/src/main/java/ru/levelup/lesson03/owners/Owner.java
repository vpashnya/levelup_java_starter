package ru.levelup.lesson03.owners;

import ru.levelup.lesson03.pets.Pet;

public class Owner {
    public void feedPet(Pet pet) {
        System.out.println("Хозяин кормит " + pet.getName());
        pet.eat();
    }
}
