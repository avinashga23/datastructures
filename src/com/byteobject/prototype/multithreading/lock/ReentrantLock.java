package com.byteobject.prototype.multithreading.lock;

import java.util.concurrent.TimeoutException;

public class ReentrantLock implements Lock {

    private int lockCount = 0;

    private long lockedBy = 0L;

    @Override
    public synchronized void lock() throws InterruptedException {
        if ((lockedBy == Thread.currentThread().getId()) || lockedBy == 0L) {
            lockCount++;
            lockedBy = Thread.currentThread().getId();
        } else {
            this.wait();
            lock();
        }
    }

    @Override
    public synchronized void unLock() {
        if (lockedBy == Thread.currentThread().getId()) {
            lockCount--;
            if (lockCount == 0) {
                lockedBy = 0L;
                this.notify();
            }
        }
    }

    @Override
    public synchronized void tryLock(long timeOutInMillis) throws InterruptedException, TimeoutException {
        if ((lockedBy == Thread.currentThread().getId()) || lockedBy == 0L) {
            lock();
            return;
        } else {
            this.wait(timeOutInMillis);
            if (lockCount == 0)
                lock();
            else
                throw new TimeoutException();
        }
    }
}
