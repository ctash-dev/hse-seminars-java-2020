package ru.hse.s5;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HSE_5_6_Append_Iterators {

    public static void main(String[] args) {
        List<Integer> first = List.of(1, 2, 3, 4, 5);
        List<Integer> second = List.of(6, 7, 8);
        List<Integer> third = List.of(9);
        List<Integer> fourth = List.of();
        var iterator = new AppendableIterator<>(
                List.of(first, second, third, fourth)
                        .stream()
                        .map(Iterable::iterator)
                        .collect(Collectors.toList()));
        while (iterator.hasNext()) {
            System.out.println(iterator);
        }
    }


    public static class AppendableIterator<T> implements Iterator<T> {

        private final List<Iterator<T>> iterators;

        public AppendableIterator(List<Iterator<T>> iterators) {
            this.iterators = iterators;
        }

        @Override
        public boolean hasNext() {
            //todo
            return false;
        }

        @Override
        public T next() {
            //todo
            return null;
        }
    }


}
