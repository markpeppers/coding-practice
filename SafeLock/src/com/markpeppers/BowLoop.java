package com.markpeppers;

import java.util.concurrent.ThreadLocalRandom;

public class BowLoop implements Runnable {
    private Friend bower;
    private Friend bowee;

    public BowLoop(Friend bower, Friend bowee) {
        this.bower = bower;
        this.bowee = bowee;
    }

    public void run() {
        for (;;) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(0,10));
            } catch (InterruptedException e) {}
            bowee.bow(bower);
        }
    }
}
