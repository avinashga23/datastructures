package com.byteobject.prototype.printfizzbuzz;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int counter;

    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (counter > 0) {
            fizzSemaphore.acquire();
            if (counter == 0)
                break;
            counter--;
            printFizz.run();
            numberSemaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (counter > 0) {
            buzzSemaphore.acquire();
            if (counter == 0)
                break;
            counter--;
            printBuzz.run();
            numberSemaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (counter > 0) {
            fizzBuzzSemaphore.acquire();
            if (counter == 0)
                break;
            counter--;
            printFizzBuzz.run();
            numberSemaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            boolean divisibleByThree = ((i % 3) == 0);
            boolean divisibleByFive = ((i % 5) == 0);
            boolean divisibleByBoth = divisibleByThree && divisibleByFive;

            if (!divisibleByThree && !divisibleByFive) {
                numberSemaphore.acquire();
                counter--;
                printNumber.accept(i);
                numberSemaphore.release();
                continue;
            } else {
                if (divisibleByBoth) {
                    numberSemaphore.acquire();
                    fizzBuzzSemaphore.release();
                    continue;
                }
                if (divisibleByThree) {
                    numberSemaphore.acquire();
                    fizzSemaphore.release();
                    continue;
                }
                if (divisibleByFive) {
                    numberSemaphore.acquire();
                    buzzSemaphore.release();
                    continue;
                }
            }
        }
        fizzSemaphore.release();
        buzzSemaphore.release();
        fizzBuzzSemaphore.release();
    }

}
