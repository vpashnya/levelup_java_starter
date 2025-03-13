package ru.levelup.lesson04.cartask;

import ru.levelup.lesson04.cartask.automobiles.Automobile;
import ru.levelup.lesson04.cartask.automobiles.Car;
import ru.levelup.lesson04.cartask.automobiles.Truck;

import java.util.Random;

public class AutomobilesLauncher {
    public static void main(String[] args) {
        Automobile[] automobiles = new Automobile[10];
        Random random = new Random();
        for (int i = 0; i < automobiles.length; i++) {
            automobiles[i] = random.nextBoolean() ? new Car() : new Truck();
        }

        for (Automobile auto : automobiles) {
            int distance = random.nextInt(1000);
            System.out.println(auto + " дистанцию " + distance + (auto.move(distance) ? " проехал" : " не проехал"));
        }
    }
}
