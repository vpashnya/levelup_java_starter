package ru.levelup.lesson15.contentmakers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import ru.levelup.lesson15.loggerutils.LogType;
import ru.levelup.lesson15.loggerutils.Logger;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class ContentMakerThread extends Thread {
    AtomicBoolean runFlag = null;
    Random random = null;
    Logger logger = null;

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            sb.append((char) (random.nextInt(66) + 1040));
        }
        return sb.toString();
    }

    @SneakyThrows
    @Override
    public void run() {
        while (runFlag.get()) {
            logger.putMessage(LogType.values()[random.nextInt(LogType.values().length)], generateRandomString());
            Thread.sleep(50);
        }
    }

}
