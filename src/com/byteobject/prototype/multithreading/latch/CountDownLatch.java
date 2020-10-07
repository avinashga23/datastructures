package com.byteobject.prototype.multithreading.latch;

public interface CountDownLatch {

    void countDown();

    void await();

}
