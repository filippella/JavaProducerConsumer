/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.Queue;

/**
 *
 * @author Filippo
 */
public class Consumer extends Thread {

    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            //Uitility.delay(500);
            consume();
        }
    }

    private void consume() {
        synchronized (this.queue) {
            if (this.queue.isEmpty()) {
                try {
                    System.out.println("Consumer Waiting...");
                    this.queue.wait();
                } catch (InterruptedException e) {
                    System.err.println("Exception occurred .. " + e.getMessage());
                }
            }
            Integer value = this.queue.poll();
            System.out.println("Consuming >> " + value);
            this.queue.notify();
        }
    }
}
