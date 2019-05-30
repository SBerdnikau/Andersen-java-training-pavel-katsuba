package com.andersen.training.patterns.command;

/**
 * Interface Runnable has method run() which works as command.
 * Runnable implementation is sent to Thread.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new Timer());
            thread.start();
            Thread.sleep(5500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
