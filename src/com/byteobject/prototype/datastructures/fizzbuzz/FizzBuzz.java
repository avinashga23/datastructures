package com.byteobject.prototype.datastructures.fizzbuzz;

public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            boolean by3 = isDivisibleBy3(i);
            boolean by5 = isDivisibleBy5(i);
            StringBuilder stringBuilder = new StringBuilder();
            if (by3)
                stringBuilder.append("Fizz");
            if (by5)
                stringBuilder.append("Buzz");
            if (! (by3 || by5))
                stringBuilder.append(String.valueOf(i));

            System.out.println(stringBuilder.toString());
        }

    }

    public static boolean isDivisibleBy3(int n) {
        return n % 3 == 0;
    }

    public static boolean isDivisibleBy5(int n) {
        return n % 5 == 0;
    }

}
