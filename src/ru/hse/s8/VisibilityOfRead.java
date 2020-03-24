package ru.hse.s8;

public class VisibilityOfRead {

    public static void main(String[] args) {
        IntHolder intHolder = new IntHolder();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("See counter as " + intHolder.counter);
                intHolder.counter++;
            }, "hseThread" + i);

        }
    }

    static class IntHolder {
        int counter = 0;
    }

}
