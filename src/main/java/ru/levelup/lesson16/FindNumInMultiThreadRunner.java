package ru.levelup.lesson16;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.*;

public class FindNumInMultiThreadRunner {
    static final int COLLECTION_SIZE = 1000000;

    public static void log(String str) {
        System.out.println("Поток " + Thread.currentThread().threadId() + " : " + str);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log("Запуск приложения ");

        try (
                ExecutorService executor = Executors.newCachedThreadPool();
        ) {

            CompletableFuture<LinkedList<Integer>> fillCollection = CompletableFuture.supplyAsync(() -> {
                log("Наполняем коллекци...");
                Random random = new Random();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = 0; i < COLLECTION_SIZE; i++) {
                    list.add(random.nextInt(COLLECTION_SIZE));
                }
                log("Наполнили...");
                return list;
            }, executor);


            CompletableFuture<Void> maxTask = fillCollection.thenAcceptAsync((list) -> {
                log("Ищем максимальное значение...");
                Integer maxValue = 0;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    maxValue = Math.max(maxValue, iterator.next());
                }
                log("Максимальное значение " + maxValue);
            });

            CompletableFuture<Void> minTask = fillCollection.thenAcceptAsync((list) -> {
                log("Ищем минимальное значение...");
                Integer minValue = 0;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    minValue = Math.min(minValue, iterator.next());
                }
                log("Минимальное значение " + minValue);
            });

            CompletableFuture<Void> avgTask = fillCollection.thenAcceptAsync((list) -> {
                log("Ищем среднее значение...");
                BigInteger avgValue = BigInteger.ZERO;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    avgValue = avgValue.add(BigInteger.valueOf(iterator.next()));
                }
                avgValue = avgValue.divide(BigInteger.valueOf(list.size()));
                log("среднее значение " + avgValue);
            });

            maxTask.get();
            minTask.get();
            avgTask.get();

        }
    }
}
