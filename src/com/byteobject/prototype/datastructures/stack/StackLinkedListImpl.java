package com.byteobject.prototype.datastructures.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackLinkedListImpl<T> implements Stack<T> {

    private LinkedList<T> linkedList = new LinkedList<T>();

    @Override
    public void push(T elem) {
        linkedList.push(elem);
    }

    @Override
    public T peek() {
        if (linkedList.size() == 0)
            throw new EmptyStackException();
        return linkedList.peek();
    }

    @Override
    public T pop() {
        if (linkedList.size() == 0)
            throw new EmptyStackException();
        return linkedList.pop();
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
