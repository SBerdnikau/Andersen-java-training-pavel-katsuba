package com.andersen.training.patterns.command;

public class Timer implements Runnable {

    @Override
    public void run() {
        int startTime = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Time: " + startTime + "sec");
                startTime++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
