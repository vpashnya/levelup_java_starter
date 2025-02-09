package ru.levelup.lesson15;

import lombok.SneakyThrows;
import ru.levelup.lesson15.contentmakers.ContentMakerThread;
import ru.levelup.lesson15.loggerutils.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadsRunner {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Desktop\\threadsLogs.txt ");
        logs2File(file);
        file2Console(file);

    }

    @SneakyThrows
    public static void logs2File(File file) {
        AtomicBoolean runFlag = new AtomicBoolean(true);
        Random random = new Random();
        try (Writer logFileWriter = new BufferedWriter(new FileWriter(file));
             Logger logger = new Logger(random, runFlag, logFileWriter);
        ) {

            new ContentMakerThread(logger).start();
            new ContentMakerThread(logger).start();
            new ContentMakerThread(logger).start();

            Thread.sleep(60000);
            runFlag.set(false);
        }

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
