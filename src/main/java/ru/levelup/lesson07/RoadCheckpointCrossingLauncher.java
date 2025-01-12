package ru.levelup.lesson07;

import ru.levelup.lesson07.automobilefactories.AutomobileFactory;
import ru.levelup.lesson07.automobilefactories.CarFactory;
import ru.levelup.lesson07.automobilefactories.TruckFactory;
import ru.levelup.lesson07.automobiles.Automobile;
import ru.levelup.lesson07.checkpoints.RoadCheckpoint;
import ru.levelup.lesson07.exceptions.*;

import java.util.Random;

public class RoadCheckpointCrossingLauncher {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        TruckFactory truckFactory = new TruckFactory();
        Random random = new Random();
        Automobile[] automobiles = new Automobile[50];

        for (int i = 0; i < automobiles.length; i++) {
            automobiles[i] = random.nextBoolean() ? carFactory.generateAutomobile() : truckFactory.generateAutomobile();
            System.out.println(automobiles[i]);
        }

        RoadCheckpoint checkpointKAD = new RoadCheckpoint("Въезд на КАД");
        System.out.println(">>> Ситуация на КПП \"" + checkpointKAD.getCheckpointName() + "\"");
        for (Automobile automobile : automobiles) {
            try {
                checkpointKAD.crossingCheckpoint(automobile);
            } catch (Over100SpeedException | Over80SpeedException e) {
                System.out.println(automobile.getRegNumber() + " быстро едит " + e.getMessage());
            } catch (Over2$5WidthException | Over8000kgWeightException | Over4mHeightException e) {
                System.out.println(automobile.getRegNumber() + " проезд запрещен " + e.getMessage());
            }
        }

    }
}
