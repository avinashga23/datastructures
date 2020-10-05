package com.byteobject.prototype.multithreading.lock;

import java.util.concurrent.TimeoutException;

public class ReentrantLockMain {

    public static void main(String[] args) throws TimeoutException, InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()-> {
            System.out.println("acquiring lock from " + Thread.currentThread().getId());
            try {
                reentrantLock.lock();
                System.out.println("acquired lock 1st time from " + Thread.currentThread().getId());
                reentrantLock.lock();
                System.out.println("acquired lock 2nd time from " + Thread.currentThread().getId());
                Thread.sleep(2000);
                reentrantLock.unLock();
                System.out.println("released lock 1st time from " + Thread.currentThread().getId());
                Thread.sleep(1000);
                reentrantLock.unLock();
                System.out.println("released lock 2nd time from " + Thread.currentThread().getId());
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(()-> {
            System.out.println("acquiring lock from " + Thread.currentThread().getId());
            try {
                reentrantLock.lock();
                System.out.println("acquired lock 1st time from " + Thread.currentThread().getId());
                Thread.sleep(1000);
                reentrantLock.unLock();
                System.out.println("released lock 1st time from " + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("main trying to acquire lock");
        reentrantLock.tryLock(10000);
        reentrantLock.unLock();
    }

}
