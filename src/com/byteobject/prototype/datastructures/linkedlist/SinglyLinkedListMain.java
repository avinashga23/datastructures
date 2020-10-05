package com.byteobject.prototype.datastructures.linkedlist;

import java.util.Iterator;

public class SinglyLinkedListMain {

    public static void main(String[] args) {
        LinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedListImpl<>();
        DoublyLinkedListMain.testLinkedList(integerSinglyLinkedList);
    }

}
