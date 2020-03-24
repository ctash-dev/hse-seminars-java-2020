package ru.hse.s8;

import java.util.function.Supplier;

public class Concurrency5SafePublication {

    static Point point;

    public static void main(String[] args) {
        Supplier<Thread> writerF = () -> new Thread(() -> point = new Point());
        Supplier<Thread> readerF = () -> new Thread(() -> System.out.println(point));
        for (int i = 0; i < 100; i++) {
            writerF.get().start();
            readerF.get().start();
        }
    }

    static class Point {
        int x = -1;
        int y = -1;
        int z = -1;

        public Point() {
            this.x = 1;
            this.y = 2;
            this.z = 3;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

}
