package ru.levelup.lesson07.automobilefactories;

import ru.levelup.lesson07.automobiles.Automobile;
import ru.levelup.lesson07.automobiles.Car;

import java.util.Random;

public class CarFactory extends AutomobileFactory {
    @Override
    public Automobile generateAutomobile() {
        Random random = new Random();
        return new Car(generateRegNumber()
                , 1.5d + random.nextDouble(1d)
                , 1d + random.nextDouble(1d)
                , 3d + random.nextDouble(4d)
                , 500 + random.nextDouble(1500)
                , random.nextDouble(150d));
    }
}
