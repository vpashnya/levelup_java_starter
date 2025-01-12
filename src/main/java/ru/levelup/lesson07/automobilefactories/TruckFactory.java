package ru.levelup.lesson07.automobilefactories;

import ru.levelup.lesson07.automobiles.Automobile;
import ru.levelup.lesson07.automobiles.Truck;

import java.util.Random;

public class TruckFactory extends AutomobileFactory {
    @Override
    public Automobile generateAutomobile() {
        Random random = new Random();
        return new Truck(generateRegNumber()
                , 2d + random.nextDouble(1d)
                , 2d + random.nextDouble(4d)
                , 10d + random.nextDouble(10d)
                , 7000 + random.nextDouble(10000)
                , random.nextDouble(110d));
    }
}
