package ru.levelup.lesson15.contentmakers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import ru.levelup.lesson15.loggerutils.LogType;
import ru.levelup.lesson15.loggerutils.Logger;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
public class ContentMakerThread extends Thread {
    private Logger logger;

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            sb.append((char) (logger.getRandom().nextInt(66) + 1040));
        }
        return sb.toString();
    }

    @SneakyThrows
    @Override
    public void run() {
        while (logger.getRunFlag().get()) {
            logger.putMessage(LogType.values()[logger.getRandom().nextInt(LogType.values().length)], generateRandomString());
            Thread.sleep(50);
        }
    }

}
