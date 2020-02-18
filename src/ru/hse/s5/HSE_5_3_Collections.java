package ru.hse.s5;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class HSE_5_3_Collections {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Collection<Integer> collection = list;
        list.addAll(List.of(1, 2, 3, 4, 5));
        Collections.sort(list); // how it works?
        System.out.println(collection.size());
        collection.add(6);
        System.out.println(collection);
        System.out.println(collection.contains(3));
        System.out.println(collection.contains(7));
        collection.remove(5);
        System.out.println(collection);
    }


}
