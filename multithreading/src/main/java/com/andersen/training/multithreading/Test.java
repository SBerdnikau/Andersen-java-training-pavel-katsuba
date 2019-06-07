package com.andersen.training.multithreading;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Необходимо уменьшить время выполнения вычислений.
 * <p>
 * Можно изменять этот класс или добавить новый. Решение должно быть максимально простым, без использования экзекуторов.
 * (Runnable, Threads). Аккуратно обработайте потенциальные ошибки (разумеется вычисления если появились ошибки нужно
 * остановить)
 */
public class Test {
    private static volatile int count;
    private static volatile boolean isInterrupt = false;

    public static void main(String[] args) throws TestException {
        Set<Double> res = new HashSet<>();
        Queue<Callable<Set<Double>>> tasks = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < TestConsts.N; i++) {
            Executor task = new Executor(i);
            tasks.add(task);
        }
        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            Thread thread = new Thread(() -> {
                while (!isInterrupt) {
                    synchronized (tasks) {
                        Callable<Set<Double>> nextTask = tasks.poll();
                        if (nextTask == null) {
                            Thread.currentThread().interrupt();
                        } else {
                            try {
                                res.addAll(nextTask.call());
                                count++;
                            } catch (Exception e) {
                                isInterrupt = true;
                            }
                        }
                    }
                }
            });
            thread.start();
        }
        while (count < TestConsts.N) ;
        isInterrupt = true;
        long takeTime = System.currentTimeMillis() - start;
        System.out.println("take time: " + takeTime);

        System.out.println(res);
    }

}
