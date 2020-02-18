package ru.hse.s4;

public class NumberList<NUMBER extends Number> {
    private Node<NUMBER> head;
    private Node<NUMBER> tail;

    public Node<NUMBER> getHead() {
        return head;
    }

    public void add(NUMBER value) {
        if (tail == null) {
            head = new Node<>();
            head.value = value;
            tail = head;
        } else {
            tail.next = new Node<>();
            tail.next.value = value;
            tail = tail.next;
        }
    }

    public static class Node<T> {
        T value;
        Node<T> next;
    }
}
