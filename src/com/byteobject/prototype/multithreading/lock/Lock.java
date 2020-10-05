package com.byteobject.prototype.multithreading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Lock {

    void lock() throws InterruptedException;

    void unLock();

    void tryLock(long timeOutInMillis) throws InterruptedException, TimeoutException;

}
