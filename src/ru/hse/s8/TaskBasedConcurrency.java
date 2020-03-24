package ru.hse.s8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskBasedConcurrency {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        // Runable
        Future<?> future = executorService.submit(TaskBasedConcurrency::printCurrentThread);
        // wait for execution.
        future.get();
        executorService.submit(TaskBasedConcurrency::printCurrentThread);
        executorService.submit(TaskBasedConcurrency::printCurrentThread);
        executorService.submit(TaskBasedConcurrency::printCurrentThread);
    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread());
    }

}
