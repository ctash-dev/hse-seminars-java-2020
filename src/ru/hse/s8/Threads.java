package ru.hse.s8;

public class Threads {

    public static void main(String[] args) {
        printCurrentThread();
        Thread thread1 = new Thread(Threads::printCurrentThread);
        Thread thread2 = new Thread(Threads::printCurrentThread);
        thread2.start();
        thread1.start();
    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread());
    }

}
