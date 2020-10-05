package com.byteobject.prototype.datastructures.stack;

public interface Stack<T> {

    void push(T elem);

    T peek();

    T pop();

    int size();

}
