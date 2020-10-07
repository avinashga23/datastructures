package com.byteobject.prototype.multithreading.latch;

import java.util.concurrent.atomic.AtomicInteger;

public interface CountDownLatch {

    void countDown();

    void await();

}
