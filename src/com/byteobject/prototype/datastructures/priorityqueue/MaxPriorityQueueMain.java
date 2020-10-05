package com.byteobject.prototype.datastructures.priorityqueue;

public class MaxPriorityQueueMain {

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> priorityQueue = new MaxPriorityQueue<>();

        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(10);
        priorityQueue.insert(5);
        System.out.println(priorityQueue.deleteMax());
        System.out.println(priorityQueue.deleteMax());
        priorityQueue.insert(4);
        System.out.println(priorityQueue.deleteMax());
    }

}
