package com.byteobject.prototype.datastructures.dynamicarray;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T>{

    public static void main(String[] args) {
        DynamicArray<Integer> intArray = new DynamicArray<>(2);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        intArray.forEach(System.out::println);

        intArray.set(2, 4);
        intArray.forEach(System.out::println);

        intArray.remove(1);
        intArray.forEach(System.out::println);
    }

    private int length;

    private int capacity;

    private T[] array;

    public DynamicArray(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
        this.capacity = initialCapacity;
    }

    public T get(int index) {
        if (index > length -1)
            throw new IllegalArgumentException();
        return array[index];
    }

    public void set(int index, T value) {
        if (index > length -1)
            throw new IllegalArgumentException();
        array[index] = value;
    }

    public void add(T value) {
        if (length + 1 <= capacity) {
            array[length++] = value;
        } else {
            if (capacity == 0)
                capacity = 1;
            else
                capacity = 2 * capacity;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++)
                newArray[i] = array[i];
            newArray[length++] = value;
            array = newArray;
        }
    }

    public void remove(int index) {
        if (index > length -1)
            throw new IllegalArgumentException();
        for (int i = index; i < length; i++)
            array[i] = array[i+1];
        length--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private  int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < length; i++)
            action.accept(array[i]);
    }

    @Override
    public Spliterator<T> spliterator() {
        return new Spliterator<T>() {
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                return false;
            }

            @Override
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }
        };
    }
}
