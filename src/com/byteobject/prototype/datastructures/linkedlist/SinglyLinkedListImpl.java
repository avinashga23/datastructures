package com.byteobject.prototype.datastructures.linkedlist;

import java.util.Iterator;

public class SinglyLinkedListImpl<T> implements LinkedList<T> {

    private int size;

    private Node head;

    private Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        Node node = new Node();
        node.value = value;
        if (tail != null)
            tail.next = node;
        else {
            tail = node;
            head = node;
        }
        tail = node;
        size++;
    }

    @Override
    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head != null)
            node.next = head;
        node = head;
        size++;
    }

    @Override
    public void addAtIndex(int index, T value) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node previous = null;
        Node traversal = head;
        for (int i = 0; i < index; i++) {
            previous = traversal;
            traversal = traversal.next;
        }
        Node node = new Node();
        node.next = traversal;
        node.value = value;
        if (previous != null)
            previous.next = node;

        if (index == 0)
            head = node;
        size++;
    }

    @Override
    public T remove(T value) {
        Node previous = null;
        Node traversal = head;
        for (int i = 0; i < size; i++) {
            if (traversal == null)
                return value;
            if (traversal.value == value) {
                if (previous == null) {
                    head = traversal.next;
                } else {
                    previous.next = traversal.next;
                }
                size--;
                return value;
            }
            previous = traversal;
            traversal = traversal.next;
        }
        return value;
    }

    @Override
    public T removeFirst() {
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        Node previous = null;
        Node traversal = head;
        while (traversal.next != null) {
            previous = traversal;
            traversal = traversal.next;
        }
        previous.next = null;
        size--;
        return traversal.value;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node previous = null;
        Node traversal = head;
        T retVal = null;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                if (previous == null)
                    head = traversal.next;
                else
                    previous.next = traversal.next;
                retVal = traversal.value;
            } else {
                previous = traversal;
                traversal = traversal.next;
            }
        }
        size--;
        return retVal;
    }

    @Override
    public boolean contains(T value) {
        Node previous = null;
        Node traversal = head;

        for (int i = 0; i < size; i++) {
            if (traversal.value == value)
                return true;
            previous = traversal;
            traversal = traversal.next;
        }

        return false;
    }

    @Override
    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node traversal = head;
        for (int i = 0; i <= index; i++) {
            if (i == index)
                return traversal.value;
            traversal = traversal.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node traversal = head;

            @Override
            public boolean hasNext() {
                return traversal != null;
            }

            @Override
            public T next() {
                T retVal = traversal.value;
                traversal = traversal.next;
                return retVal;
            }
        };
    }

    private class Node {
        Node next;
        T value;
    }
}
