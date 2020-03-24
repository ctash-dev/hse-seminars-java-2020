package ru.hse.s8;

public class VisibilityOfRead {

    public static void main(String[] args) throws InterruptedException {
        IntHolder intHolder = new IntHolder();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("See counter as " + intHolder.counter);
                intHolder.counter++;
            }, "hseThread" + i);
            thread.start();
            thread.join();
        }
    }

    static class IntHolder {
        int counter = 0;
    }

}
