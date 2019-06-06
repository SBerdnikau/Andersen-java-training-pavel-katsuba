package com.andersen.training.multithreading;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor implements Runnable {
    private static final Logger logger = Logger.getLogger(Executor.class.getName());
    private Set<Double> res;
    private int num;

    public Executor(Set<Double> res, int num) {
        this.res = res;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            res.addAll(TestCalc.calculate(num));
        } catch (TestException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }
}
