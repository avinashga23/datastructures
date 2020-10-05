package com.byteobject.prototype.datastructures.evenodd;

import java.util.concurrent.Semaphore;

public class EvenOddMain {

    public static void main(String[] args) throws Exception {
        Semaphore evenSemaphore = new Semaphore(0);
        Semaphore oddSemaphore = new Semaphore(1);

        new Thread(()-> {
            int i = 2;
            while (true) {
                try {
                    evenSemaphore.acquire();
                    System.out.println(i + " from " + Thread.currentThread().getName());
                    i += 2;
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                }
            }
        }, "Even").start();

        new Thread(()-> {
            int i = 1;
            while (true) {
                try {
                    oddSemaphore.acquire();
                    System.out.println(i + " from " + Thread.currentThread().getName());
                    i += 2;
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                }
            }
        }, "Odd").start();

        System.out.println("finished main");
    }

}
