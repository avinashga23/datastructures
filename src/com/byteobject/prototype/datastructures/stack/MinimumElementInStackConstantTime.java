package com.byteobject.prototype.datastructures.stack;

public class MinimumElementInStackConstantTime {

    private static Stack<Integer> stack = new StackLinkedListImpl<>();
    private static Stack<Integer> minStack = new StackLinkedListImpl<>();

    public static void main(String[] args) {
        push(4);
        push(5);
        push(6);
        push(3);
        push(9);

        System.out.println(getMin());

        pop();
        pop();
        System.out.println(getMin());
    }

    private static void push(Integer integer) {
        if (stack.size() == 0) {
            stack.push(integer);
            minStack.push(integer);
        } else {
            Integer minimumElement = minStack.peek();
            if (minimumElement < integer) {
                minStack.push(minimumElement);
            } else
                minStack.push(integer);
            stack.push(integer);
        }
    }

    private static Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    private static Integer getMin() {
        return minStack.peek();
    }

}
