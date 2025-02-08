package ru.levelup.lesson15;

import lombok.SneakyThrows;
import ru.levelup.lesson15.contentmakers.ContentMakerThread;
import ru.levelup.lesson15.loggerutils.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadsRunner {
    @SneakyThrows
    public static void main(String[] args) {
        AtomicBoolean runFlag = new AtomicBoolean(true);
        Random random = new Random();
        File file = new File("C:\\Users\\user\\Desktop\\threadsLogs.txt ");
        Logger logger = new Logger(random, runFlag, file);

        new ContentMakerThread(runFlag, random, logger).start();
        new ContentMakerThread(runFlag, random, logger).start();
        new ContentMakerThread(runFlag, random, logger).start();

        Thread.sleep(60000);
        runFlag.set(false);
        logger.close();

        file2Console(file);

    }

    @SneakyThrows
    public static void file2Console(File file) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
        ) {
            reader.lines().forEach(System.out::println);
        }
    }
}
