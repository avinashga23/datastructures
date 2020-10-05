package com.byteobject.prototype.multithreading.lock;

public class WaitNotify {

    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("interrupted exception from " + Thread.currentThread().getName());
            }
            synchronized (lock) {
                lock.notify();
            }
        }).start();

        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted exception from " + Thread.currentThread().getName());
        }
    }

}
