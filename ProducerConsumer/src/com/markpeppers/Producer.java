package com.markpeppers;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<String> drop;

    public Producer(BlockingQueue drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            try {
                drop.put(importantInfo[i]);
            } catch (InterruptedException e) {}
        }
        try {
            drop.put("DONE");
        } catch (InterruptedException e) {}
    }
}
