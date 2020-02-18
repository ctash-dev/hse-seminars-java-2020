package ru.hse.s5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HSE_5_4_Maps {

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        List.of(1, 2, 3, 4, 5).forEach(
                i -> {
                    hashMap.put(i, i);
                    treeMap.put(i, i);
                }
        );

        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue(1));

        hashMap.putIfAbsent(1, 3);
        treeMap.put(1, 3);

        System.out.println(hashMap);
        System.out.println(treeMap);

    }


}
