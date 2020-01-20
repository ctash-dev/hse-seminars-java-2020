package ru.hse.s2;

public class HSE_2_5_AverageOfLargeSum {
    public static void main(String[] args) {
        long[] last10000longs = new long[9999];
        for (int i = 0; i < 9999; i++) {
            last10000longs[i] = Long.MAX_VALUE - i;
        }

        long avg = getAvg(last10000longs);
        long expected = Long.MAX_VALUE - 4999;

        System.out.println(expected);
        System.out.println(avg);
    }

    private static long getAvg(long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum / array.length;
    }
}
