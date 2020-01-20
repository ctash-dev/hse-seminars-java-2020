package ru.hse.s2;

public class HSE_2_1_PassParams {
    public static void main(String[] args) {
        int counter = 0;
        incCounter(counter);
        System.out.println(counter);
    }

    private static void incCounter(int counter) {
        counter++;
    }
}
