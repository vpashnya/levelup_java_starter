package ru.levelup.lesson16;

import lombok.SneakyThrows;
import ru.levelup.lesson16.loggerutils.LogType;
import ru.levelup.lesson16.loggerutils.Logger;
import ru.levelup.lesson16.appcontext.ApplicationContext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class ExecutorRunner {
    static final String LOG_FILE = "C:\\Users\\user\\Desktop\\logThread.txt";
    static final int TASK_THREADS_COUNT = 10;

    public static void main(String[] args) {
        log2file();
        file2Console();
    }

    @SneakyThrows
    public static void log2file() {
        System.out.println("Начало");
        try (
                ApplicationContext context = new ApplicationContext(TASK_THREADS_COUNT);
                BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE));
        ) {
            Random random = new Random();
            Logger logger = new Logger(random, writer);
            logger.getSaverTasks().stream().forEach(context::runRepeatTask);

            context.runRepeatTask(() -> logger.putMessage(LogType.values()[random.nextInt(LogType.values().length)], "Task 1"));
            context.runRepeatTask(() -> logger.putMessage(LogType.values()[random.nextInt(LogType.values().length)], "Task 2"));
            context.runRepeatTask(() -> logger.putMessage(LogType.values()[random.nextInt(LogType.values().length)], "Task 3"));
            context.runRepeatTask(() -> logger.putMessage(LogType.values()[random.nextInt(LogType.values().length)], "Task 4"));

            Thread.sleep(60000);
        }
        System.out.println("Конец");
    }

    @SneakyThrows
    public static void file2Console() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE));
        ) {
            reader.lines().forEach(System.out::println);
        }
    }
}
