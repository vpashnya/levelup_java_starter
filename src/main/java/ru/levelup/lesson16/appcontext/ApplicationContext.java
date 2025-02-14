package ru.levelup.lesson16.appcontext;

import lombok.SneakyThrows;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ApplicationContext implements Closeable {

    private ExecutorService executorRepeatTasks;
    private ExecutorService executorSimpleTasks;
    private boolean active;

    public ApplicationContext(int taskThreads) {
        executorRepeatTasks = Executors.newFixedThreadPool(taskThreads);
        executorSimpleTasks = Executors.newFixedThreadPool(taskThreads);
        active = true;
    }

    public void runRepeatTask(Runnable task) {
        executorRepeatTasks.execute(new RepeatTask(task));
    }

    class RepeatTask implements Runnable {
        Runnable task;

        RepeatTask(Runnable task) {
            this.task = task;
        }

        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(1);
            executorSimpleTasks.submit(task).get();
            if (active) {
                executorRepeatTasks.execute(this);
            }
        }
    }

    @SneakyThrows
    @Override
    public void close() throws IOException {
        active = false;
        executorRepeatTasks.shutdown();
        executorRepeatTasks.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        executorSimpleTasks.close();
        executorSimpleTasks.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    }
}
