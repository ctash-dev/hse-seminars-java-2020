package ru.hse.s5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // array
        int[] array = new int[1000];

        // stack
        Stack<Integer> stack = new Stack<>(); // DON'T USE
        Deque<Integer> arrayDequeStack = new ArrayDeque<>();
        Deque<Integer> listDequeStack = new LinkedList<>();

        // queue
        Queue<Integer> queue; // ?? queue is an interface
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        Queue<Integer> listDeque = new LinkedList<>();

        // list
        List<Integer> list; // random access or linked?
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> vector = new Vector<>(); // DON'T USE IT

        // set
        Set<Integer> set; // ?? set is an interface
        Set<Integer> hashSet = new HashSet<>(); // a simplified HashMap
        Set<Integer> treeSet = new TreeSet<>(); // a simplified TreeMap

        // heap
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        // tree
        // no default structure
        Set<Integer> redBlackTreeSet = new TreeSet<>();

        // hashtable
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(); // DON'T USE IT
        Map<Integer, Integer> hashMap = new HashMap<>();

        // treeMap
        Map<Integer, Integer> treeMap = new TreeMap<>();

    }
}
