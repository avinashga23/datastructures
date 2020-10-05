package com.byteobject.prototype.datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        LinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        testLinkedList(integerDoublyLinkedList);
    }

    static void testLinkedList(LinkedList<Integer> integerLinkedList) {
        System.out.println("Size is " + integerLinkedList.size());
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        System.out.println("Size is " + integerLinkedList.size());
        System.out.println(integerLinkedList.contains(4));
        System.out.println(integerLinkedList.contains(2));
        integerLinkedList.removeAtIndex(1);
        System.out.println(integerLinkedList.contains(2));
        System.out.println("Size is " + integerLinkedList.size());

        Iterator<Integer> iterator = integerLinkedList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
