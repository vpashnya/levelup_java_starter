package ru.levelup.lesson15.loggerutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class Logger {

    private AtomicBoolean runFlag;
    private Appendable logFileWriter;
    private ConcurrentHashMap<LogType, ConcurrentLinkedQueue<LogMessage>> messages;
    private LinkedList<LogSaverThread> logSavers;
    private Random random;

    @SneakyThrows
    public Logger(Random random, AtomicBoolean runFlag, Appendable logFileWriter) {
        this.random = random;
        this.runFlag = runFlag;

        this.logFileWriter = logFileWriter;

        messages = new ConcurrentHashMap<>();
        logSavers = new LinkedList<>();

        Arrays.stream(LogType.values()).forEach((l) -> {
            messages.put(l, new ConcurrentLinkedQueue<LogMessage>());
            createLogThread(l);
        });
    }

    private void createLogThread(LogType logType){
        LogSaverThread logSaver = new LogSaverThread(logType);
        logSaver.start();
        logSavers.add(logSaver);
    }

    public void putMessage(LogType logType, String message) {
        messages.get(logType).add(new LogMessage(System.currentTimeMillis(), logType, Thread.currentThread().threadId(), message));
    }

    @SneakyThrows
    private void saveMessage2File(String logMessage) {
        logFileWriter.append(logMessage + "\n");
    }

    @SneakyThrows
    public void close() {
        logSavers.stream().forEach((l) -> {
            try {
                l.join();
            } catch (InterruptedException e) {

            }
        });
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
    class LogSaverThread extends Thread {
        LogType logType;

        @SneakyThrows
        @Override
        public void run() {
            ConcurrentLinkedQueue<LogMessage> messageQueue = messages.get(logType);
            while (runFlag.get() || !messageQueue.isEmpty()) {
                while (!messageQueue.isEmpty()) {
                    saveMessage2File(messages.get(logType).poll().toString());
                }
                Thread.sleep(random.nextInt(5000));
            }
        }
    }

}
