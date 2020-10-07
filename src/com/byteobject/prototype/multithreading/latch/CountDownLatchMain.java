package com.byteobject.prototype.multithreading.latch;

public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new SimpleCountDownLatch(5);

        new Thread(() -> {
            System.out.println("awaiting from thread " + Thread.currentThread().getName());
            countDownLatch.await();
            System.out.println("finishing from thread " + Thread.currentThread().getName());
        }, "One").start();

        new Thread(() -> {
            System.out.println("awaiting from thread " + Thread.currentThread().getName());
            countDownLatch.await();
            System.out.println("finishing from thread " + Thread.currentThread().getName());
        }, "Two").start();

        new Thread(() -> {
            System.out.println("awaiting from thread " + Thread.currentThread().getName());
            countDownLatch.await();
            System.out.println("finishing from thread " + Thread.currentThread().getName());
        }, "Three").start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("counting down " + (i + 1) + " from " + Thread.currentThread().getName());
            countDownLatch.countDown();
        }

        System.out.println("finished main thread");
    }

}
