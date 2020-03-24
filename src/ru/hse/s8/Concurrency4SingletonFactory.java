package ru.hse.s8;

import java.util.ArrayList;
import java.util.List;

public class Concurrency4SingletonFactory {

    public static void main(String[] args) {
        SingletonFactory factory = new SingletonFactory();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> System.out.println(factory.get())));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class SingletonFactory {
        private Singleton instance;

        public Singleton get() {
            if (instance == null) { //read1
                synchronized (this) {
                    instance = new Singleton(); //read2
                }
            }
            return instance; //read3
        }
    }

    static class Singleton {
    }

}
