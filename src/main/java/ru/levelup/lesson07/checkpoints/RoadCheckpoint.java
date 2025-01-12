package ru.levelup.lesson07.checkpoints;

import ru.levelup.lesson07.automobiles.Automobile;
import ru.levelup.lesson07.exceptions.*;

public class RoadCheckpoint {
    private String checkpointName;

    private RoadCheckpoint() {
    }

    public RoadCheckpoint(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    private void callToPolice(Automobile automobile) {
        System.out.println("В полицию передана информация по " + automobile.getRegNumber());
    }

    public void crossingCheckpoint(Automobile automobile) {
        if (automobile.getHeight() > 4d) {
            throw new Over4mHeightException();
        } else if (automobile.getWidth() > 2.5d) {
            throw new Over2$5WidthException();
        } else if (automobile.getWeight() > 8000d) {
            throw new Over8000kgWeightException();
        } else if (automobile.getCurrentSpeed() > 100d) {
            callToPolice(automobile);
            throw new Over100SpeedException();
        } else if (automobile.getCurrentSpeed() > 80d) {
            throw new Over80SpeedException();
        }

        System.out.println(" С " + automobile.getRegNumber() + " все нормально");
    }

    public String getCheckpointName() {
        return checkpointName;
    }
}
