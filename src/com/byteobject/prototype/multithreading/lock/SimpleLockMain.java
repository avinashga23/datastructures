package com.byteobject.prototype.multithreading.lock;

public class SimpleLockMain {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new SimpleLock();

        new Thread(() -> {
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("locked by " + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("unlocked by " + Thread.currentThread().getId());
            lock.unLock();
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("locked by " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("unlocked by " + Thread.currentThread().getId());
            lock.unLock();
        }).start();

        new Thread(() -> {
            try {
                System.out.println("trying to lock from " + Thread.currentThread().getId());
                lock.tryLock(5000);
                System.out.println("acquired lock");
                lock.unLock();
            } catch (Exception e) {
                System.out.println("unable to acquire lock");
            }
        }).start();

        Thread.sleep(10000);
    }

}
