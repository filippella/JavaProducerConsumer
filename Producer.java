/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.Queue;
import java.util.Random;
/**
 *
 * @author Filippo
 */
public class Producer extends Thread {

    private final int MAX_QUEUE_CAPACITY = 5;
    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            //Uitility.randomDelay();
            produce();
        }
    }

    private void produce() {
        synchronized (this.queue) {
            if (this.queue.size() > MAX_QUEUE_CAPACITY) {
                try {
                    System.out.println("Producer Waiting...");
                    this.queue.wait();
                } catch (InterruptedException e) {
                    System.err.println("Exception occurred .. " + e.getMessage());
                }
            }
            int value = new Random().nextInt(50);
            System.out.println("Producing >> " + value);
            this.queue.add(value);
            this.queue.notify();
        }
    }
}
