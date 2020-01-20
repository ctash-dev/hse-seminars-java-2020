package ru.hse.s2;

public class HSE_2_2_AverageIntegers {
    public static void main(String[] args) {
        int[] numbers = {
                Integer.MAX_VALUE,
                Integer.MAX_VALUE - 1,
                Integer.MAX_VALUE - 2,
        };
        System.out.println(Integer.MAX_VALUE - 1);
        System.out.println((numbers[0] + numbers[1] + numbers[2]) / 3);
    }
}
