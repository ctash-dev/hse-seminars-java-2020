package ru.hse.s5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HSE_5_5_ListToMap {

    public static void main(String[] args) {
        List<Point> points = List.of(
                new Point(1, 2, 3),
                new Point(1, 2, 3),
                new Point(1, 2, 4),
                new Point(1, 2, 5),
                new Point(1, 2, 5),
                new Point(2, 3, 4),
                new Point(5, 2, 1),
                new Point(2, 3, 1)
                );
        Map<Point, Integer> pointMap = listToMap(points);
        System.out.println(pointMap);
    }


    public static Map<Point, Integer> listToMap(List<Point> points) {
        return Map.of();
    }


    public static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


}
