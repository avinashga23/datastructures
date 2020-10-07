package com.byteobject.prototype.multithreading.latch;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCountDownLatch implements CountDownLatch {

    private AtomicInteger tokens;

    public SimpleCountDownLatch(int tokens) {
        this.tokens = new AtomicInteger(tokens);
    }

    @Override
    public synchronized void countDown() {
        int tokensAvailable = this.tokens.decrementAndGet();
        if (tokensAvailable == 0) {
            this.notifyAll();
        }
    }

    @Override
    public synchronized void await() {
        try {
            if (tokens.get() != 0)
                this.wait();
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}
