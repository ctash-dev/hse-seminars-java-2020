package ru.hse.s8;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Concurrency3TaskBasedConcurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "hseDaemon-" + UUID.randomUUID());
                thread.setDaemon(true);
                return thread;
            }
        });
        // Runable
        Future<?> future = executorService.submit(Concurrency3TaskBasedConcurrency::printCurrentThread);
        // wait for execution.
        future.get();
        for (int i = 0; i < 100; i++) {
            executorService.submit(Concurrency3TaskBasedConcurrency::printCurrentThread);
        }
    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }

}
