package ru.hse.s5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class HSE_5_2_Iteration {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Iterable<Integer> iterable = list;
        list.addAll(List.of(1, 2, 3, 4, 5));

        System.out.println("For each");
        foreachLoop(iterable);

        System.out.println("Iterator");
        iterator(iterable);

        System.out.println(list); // should be empty

        Map<Integer, Integer> map = new HashMap<>();
        Iterable<Integer> iterableFromMapKeys = map.keySet();
        Iterable<Integer> iterableFromMapValues = map.values();
        Iterable<Map.Entry<Integer, Integer>> iterableFromMapEntries = map.entrySet();

    }

    private static void foreachLoop(Iterable<Integer> iterable) {
        // Pre Java 8
        iterable.forEach(
                new Consumer<Integer>() {
                    @Override
                    public void accept(Integer element) {
                        System.out.println(element);
                    }
                }
        );

        // Java 8+
        iterable.forEach(
                element -> System.out.println(element)
        );

        iterable.forEach(
                System.out::println
        );
    }

    private static void iterator(Iterable<Integer> iterable) {
        // 99% shouldn't be used
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            iterator.remove();
            System.out.println(next);
        }
    }


}
