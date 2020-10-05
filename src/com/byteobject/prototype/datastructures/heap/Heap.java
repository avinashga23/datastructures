package com.byteobject.prototype.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable> {

    private List<T> list;

    public Heap() {
        list = new ArrayList<>();
        list.add(null);
    }

    public synchronized void add(T node) {
        list.add(node);
        swim(list.size() - 1);
    }

    public synchronized T get() {
        T retVal = list.get(1);
        swap(1, list.size() - 1);
        list.remove(list.size() - 1);
        sink(1);
        return retVal;
    }

    private void sink(int i) {
        T node = list.get(i);
        T leftChild = (2 * i) < list.size() ? list.get(2 * i) : null;
        T rightChild = (2 * i) + 1 < list.size() ? list.get((2 * i) + 1) : null;
        if (leftChild != null) {
            if (less(node, leftChild)) {
                swap(i, 2 * i);
                sink(2 * i);
                return;
            }
        }
        if (rightChild != null) {
            if (less(node, rightChild)) {
                swap(i, (2 * i) + 1);
                sink((2 * i) + 1);
                return;
            }
        }
    }

    private void swim(int i) {
        T node = list.get(i);
        T parent = list.get(i / 2);
        if (parent != null) {
            if (!less(node, parent)) {
                swap(i, i / 2);
                swim(i / 2);
                return;
            }
        }
    }

    private boolean less(T n1, T n2) {
        return n1.compareTo(n2) < 0;
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);

        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());

        heap.add(15);
        heap.add(10);
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
        System.out.println(heap.get());
        heap.add(21);
        heap.add(21);
        System.out.println(heap.get());
        System.out.println(heap.get());
    }

}
