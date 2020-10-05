package com.byteobject.prototype.datastructures.linkedlist;

import java.util.Iterator;

public interface LinkedList<T> {

    int size();

    void add(T value);

    void addFirst(T value);

    void addAtIndex(int index, T value);

    T remove(T value);

    T removeFirst();

    T removeLast();

    T removeAtIndex(int index);

    boolean contains(T value);

    T get(int index);

    Iterator<T> iterator();

}
