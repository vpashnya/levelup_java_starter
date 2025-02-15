package ru.levelup.lesson16;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


            CompletableFuture<String> maxTask = fillCollection.thenApplyAsync((list) -> {
                log("Ищем максимальное значение...");
                Integer maxValue = 0;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    maxValue = Math.max(maxValue, iterator.next());
                }
                return "Максимальное значение " + maxValue;
            });

            CompletableFuture<String> minTask = fillCollection.thenApplyAsync((list) -> {
                log("Ищем минимальное значение...");
                Integer minValue = 0;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    minValue = Math.min(minValue, iterator.next());
                }
                return "Минимальное значение " + minValue;
            });

            CompletableFuture<String> avgTask = fillCollection.thenApplyAsync((list) -> {
                log("Ищем среднее значение...");
                BigInteger avgValue = BigInteger.ZERO;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    avgValue = avgValue.add(BigInteger.valueOf(iterator.next()));
                }
                avgValue = avgValue.divide(BigInteger.valueOf(list.size()));
                return "Cреднее значение " + avgValue;
            });

            log(maxTask.get());
            log(minTask.get());
            log(avgTask.get());

        }
    }
}
