package com.byteobject.prototype.leetcode.printinorder;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore secondSemaphore = new Semaphore(0);
        Semaphore thirdSemaphore = new Semaphore(0);

        Foo foo = new Foo();

        new Thread(()-> {
            foo.first();
            secondSemaphore.release();
        }).start();

        new Thread(()-> {
            try {
                secondSemaphore.acquire();
                foo.second();
                thirdSemaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(()-> {
            try {
                thirdSemaphore.acquire();
                foo.third();
            } catch (InterruptedException e) {
            }
        }).start();
    }

}
