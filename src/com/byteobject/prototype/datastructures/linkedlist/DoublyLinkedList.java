package com.byteobject.prototype.datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements LinkedList<T> {

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
        if (tail == null) {
            node.previous = null;
            node.next = null;
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addAtIndex(int index, T value) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node node = new Node();
        node.value = value;

        Node traversal = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                node.previous = traversal.previous;
                traversal.previous = node;
                node.next = traversal;
            }
        }
        size++;
    }

    @Override
    public T remove(T value) {
        Node traversal = head;
        for (int i = 0; i < size; i++) {
            if (traversal.value == value)
                break;
            traversal = traversal.next;
        }

        if (traversal.value == value) {
            traversal.previous.next = traversal.next;
            size--;
        }

        return value;
    }

    @Override
    public T removeFirst() {
        T retVal = null;
        if (head != null) {
            retVal = head.value;
            head = head.next;
            head.previous = null;
        }
        return retVal;
    }

    @Override
    public T removeLast() {
        T retVal = null;
        if (tail != null) {
            retVal = tail.value;
            tail = tail.previous;
            tail.next = null;
        }
        return retVal;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node traversal = head;
        for (int i = 0; i < index; i++) {
            traversal = traversal.next;
        }
        T retVal = traversal.value;
        if (traversal.previous != null)
            traversal.previous.next = traversal.next;
        else
            head = traversal.next;

        size--;
        return retVal;
    }

    @Override
    public boolean contains(T value) {
        Node traversal = head;
        for (int i = 0; i < size; i++) {
            if (traversal.value == value)
                return true;
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
            traversal = traversal.next;
        }
        return traversal.value;
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
        Node previous;
        T value;
        Node next;
    }
}
