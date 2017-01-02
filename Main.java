/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Filippo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        
        producer.start();
        consumer.start();
    }
}
