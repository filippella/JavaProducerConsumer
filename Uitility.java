/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.Random;

/**
 *
 * @author Filippo
 */
public class Uitility {

    private static final Random RANDOM = new Random();

    public static void delay(long delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException ex) {
            System.err.printf("Failed to wait for %d\n%s", delayTime, ex.getMessage());
        }
    }

    public static void randomDelay() {
        int delayTime = RANDOM.nextInt(500);
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException ex) {
            System.err.printf("Failed to wait for %d\n%s", delayTime, ex.getMessage());
        }
    }
}
