package com.byteobject.prototype.multithreading.lock;

import java.util.concurrent.TimeoutException;

public class SimpleLock implements Lock {

    private boolean isLocked = false;

    private long lockedBy = 0l;

    @Override
    public synchronized void lock() throws InterruptedException {
        if (!isLocked) {
            isLocked = true;
            lockedBy = Thread.currentThread().getId();
        } else {
            this.wait();
            lock();
        }
    }

    @Override
    public synchronized void unLock() {
        System.out.println("unlock called by " + Thread.currentThread().getId());
        if (isLocked) {
            if (lockedBy == Thread.currentThread().getId()) {
                isLocked = false;
                lockedBy = 0l;
                this.notify();
            }
        }
    }

    @Override
    public synchronized void tryLock(long timeOutInMillis) throws InterruptedException, TimeoutException {
        if (!isLocked) {
            isLocked = true;
            lockedBy = Thread.currentThread().getId();
        } else {
            this.wait(timeOutInMillis);
            if (!isLocked) {
                lock();
            } else {
                System.out.println("Unable to acquire lock hence bailing out");
                throw new TimeoutException();
            }
        }
    }
}
