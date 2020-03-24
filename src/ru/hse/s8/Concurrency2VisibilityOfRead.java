package ru.hse.s8;

import java.util.concurrent.atomic.AtomicInteger;

public class Concurrency2VisibilityOfRead {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("See counter as " + counter.get());
                counter.incrementAndGet();
            }, "hseThread" + i);
            thread.start();
        }
    }

}
