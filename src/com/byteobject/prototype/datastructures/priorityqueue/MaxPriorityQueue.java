package com.byteobject.prototype.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPriorityQueue<T extends  Comparable> {

    private List<T> array = new ArrayList<>();

    public MaxPriorityQueue() {
        array.add(null);
    }

    public void insert(T toInsert) {
        array.add(toInsert);
        swim(array.size() - 1);
    }

    public T deleteMax() {
        T retVal = array.get(1);
        T lastVal = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        array.set(0, lastVal);
        sink(0);
        return retVal;
    }

    private void swim(int index) {
        T indexed = array.get(index);
        T parent = array.get(index / 2);
        if (parent != null) {
            if (less(parent, indexed)) {
                exchange(index, index / 2);
                swim(index / 2);
            }
        }
    }

    private void sink(int index) {
        T indexed = array.get(index);

        if ((2 * index) < (array.size() - 1)) {
            T firstChild = array.get(2 * index);
            if (less(indexed, firstChild)) {
                exchange(index, (2 * index));
                sink(2 * index);
            }
        }

        if (((2 * index) + 1) < (array.size() - 1)) {
            T secondChild = array.get((2 * index) + 1);
            if (less(indexed, secondChild)) {
                exchange(index, ((2 * index) + 1));
                sink(((2 * index) + 1));
            }
        }
    }

    private void exchange(int i, int j) {
        T temp = null;
        temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    private boolean less(T i, T j) {
        return i.compareTo(j) < 0;
    }

}
