package ru.hse.s5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        var map = new HashMap<Point, Integer>();
        for (Point point : points) {
            map.merge(point, 1, Integer::sum);
        }
        return map;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y &&
                    z == point.z;
        }

        @Override
        public int hashCode() {
            Object[] a = new Object[]{x, y, z};
            if (a == null)
                return 0;

            int result = 1;

            for (Object element : a)
                result = 31 * result + (element == null ? 0 : element.hashCode());

            return result;
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
