package ru.hse.s8;

public class Threads {

    public static void main(String[] args) {
        printCurrentThread();
        Thread thread1 = new Thread(Threads::printCurrentThread, "hseThread1");
        Thread thread2 = new Thread(Threads::printCurrentThread, "hseThread2");
        Thread thread3 = new Thread(Threads::printCurrentThread, "hseThread3");
        Thread thread4 = new Thread(Threads::printCurrentThread, "hseThread4");
        Thread thread5 = new Thread(Threads::printCurrentThread, "hseThread5");
        Thread thread6 = new Thread(Threads::printCurrentThread, "hseThread6");
        Thread thread7 = new Thread(Threads::printCurrentThread, "hseThread7");
        Thread thread8 = new Thread(Threads::printCurrentThread, "hseThread8");
        Thread thread9 = new Thread(Threads::printCurrentThread, "hseThread9");
        Thread thread10 = new Thread(Threads::printCurrentThread, "hseThread10");
        Thread thread11 = new Thread(Threads::printCurrentThread, "hseThread11");
        Thread thread12 = new Thread(Threads::printCurrentThread, "hseThread12");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread());
    }

}
