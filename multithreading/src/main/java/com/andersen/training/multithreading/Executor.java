package com.andersen.training.multithreading;

import java.util.Set;
import java.util.concurrent.Callable;

public class Executor implements Callable<Set<Double>> {
    private int num;

    public Executor(int num) {
        this.num = num;
    }

    @Override
    public Set<Double> call() throws Exception {
        return TestCalc.calculate(num);
    }
}
