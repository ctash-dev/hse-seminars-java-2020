package ru.hse.s2;

public class HSE_2_2_AverageIntegers {
    public static void main(String[] args) {
        int[] numbers = {
                Integer.MAX_VALUE,
                Integer.MAX_VALUE - 1,
                Integer.MAX_VALUE - 2,
        };
        System.out.println(Integer.MAX_VALUE - 1);
        System.out.println((numbers[0]*1.0/3 + numbers[1]*1.0/3 + numbers[2]*1.0/3));
    }
}
