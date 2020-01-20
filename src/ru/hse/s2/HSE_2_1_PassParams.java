package ru.hse.s2;

public class HSE_2_1_PassParams {
    public static void main(String[] args) {
        Counter counter = new Counter();
        incCounter(counter);
        System.out.println(counter);
    }

    private static void incCounter(Counter counter) {
        counter.value++;
    }

    static class Counter {
        final int value;
    }
}
