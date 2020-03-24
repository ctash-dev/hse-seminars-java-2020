package ru.hse.s8;

public class VisibilityOfRead {

    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("See counter as " + counter);
                counter++;
            }, "hseThread" + i);

        }
    }

}
