package ru.levelup.lesson16.loggerutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
public class Logger {

    private Appendable logFileWriter;
    private ConcurrentHashMap<LogType, ConcurrentLinkedQueue<LogMessage>> messages;
    private Random random;
    private List<LogSaverTask> saverTasks;

    @SneakyThrows
    public Logger(Random random, Appendable logFileWriter) {
        this.random = random;
        this.logFileWriter = logFileWriter;
        this.messages = new ConcurrentHashMap<>();
        this.saverTasks = new LinkedList<>();
        Arrays.stream(LogType.values()).forEach(it -> {
            saverTasks.add(new LogSaverTask(it));
            this.messages.put(it, new ConcurrentLinkedQueue<>());
        });

    }

    public void putMessage(LogType logType, String message) {
        messages.get(logType).add(new LogMessage(System.currentTimeMillis(), logType, Thread.currentThread().threadId(), message));
    }

    @SneakyThrows
    private void saveMessage2File(String logMessage) {
        logFileWriter.append(logMessage + "\n");
    }

    @AllArgsConstructor
    class LogMessage {
        private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long messageTime;
        LogType logType;
        long threadNum;
        String message;

        @Override
        public String toString() {
            return "<%s><%s><%s><%s>".formatted(TIME_FORMAT.format(new Date(messageTime)), logType, threadNum, message);
        }
    }

    @AllArgsConstructor
    public class LogSaverTask implements Runnable {
        LogType logType;

        @SneakyThrows
        @Override
        public void run() {
            ConcurrentLinkedQueue<LogMessage> messageQueue = messages.get(logType);
            while (!messageQueue.isEmpty()) {
                saveMessage2File(messages.get(logType).poll().toString());
            }
            Thread.sleep(random.nextInt(5000));

        }
    }

}
