package com.markpeppers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>();
        (new Thread(new Producer(queue))).start();
        (new Thread(new Consumer(queue))).start();
    }
}
