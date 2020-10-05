package com.byteobject.prototype.datastructures.printzeroevenodd;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        new Thread(()-> {
            try {
                zeroEvenOdd.even((int i)-> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Even").start();

        new Thread(()-> {
            try {
                zeroEvenOdd.odd((int i)-> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Odd").start();

        new Thread(()-> {
            try {
                zeroEvenOdd.zero((int i)-> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Zero").start();

        Thread.sleep(1000);
    }

}
