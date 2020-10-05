package com.byteobject.prototype.datastructures.printzeroevenodd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private int counter;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = n;
    }

    Semaphore zeroSemaphore = new Semaphore(1);
    Semaphore oddSemaphore = new Semaphore(0);
    Semaphore evenSemaphore = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(counter > 0) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            oddSemaphore.release();
            zeroSemaphore.acquire();
            if (counter == 0)
                break;
            printNumber.accept(0);
            evenSemaphore.release();
            zeroSemaphore.acquire();
            zeroSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n;) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            counter--;
            i += 2;
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n;) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            counter--;
            i += 2;
            zeroSemaphore.release();
        }
    }

}
