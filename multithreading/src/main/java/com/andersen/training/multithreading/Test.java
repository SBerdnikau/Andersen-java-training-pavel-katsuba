package com.andersen.training.multithreading;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Необходимо уменьшить время выполнения вычислений.
 * <p>
 * Можно изменять этот класс или добавить новый. Решение должно быть максимально простым, без использования экзекуторов.
 * (Runnable, Threads). Аккуратно обработайте потенциальные ошибки (разумеется вычисления если появились ошибки нужно
 * остановить)
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());
    private static volatile int threadCount;
    private static List<Thread> threads = new ArrayList<>();
    private static Thread currentThread;

    public static void main(String[] args) throws TestException, InterruptedException {
        Set<Double> res = new HashSet<>();
        currentThread = Thread.currentThread();

        long start = System.currentTimeMillis();
        for (int i = 0; i < TestConsts.N; i++) {
            if(threadCount == TestConsts.MAX_THREADS) {
                try {
                    res.wait();
                } catch (InterruptedException e) {
                    logger.log(Level.WARNING, e.getMessage(), e);
                    throw new InterruptedException(e.getMessage());
                }
            }
            Executor task = new Executor(i);
            Thread thread = new Thread(() -> {
                try {
                    synchronized (res) {
                        res.addAll(task.call());
                        threadCount++;
                        res.notify();
                    }
                } catch (Exception e) {
                    logger.log(Level.WARNING, e.getMessage(), e);
                    Test.interrupt();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long takeTime = System.currentTimeMillis() - start;
        System.out.println("take time: " + takeTime);

        System.out.println(res);
    }

    public static void interrupt() {
        currentThread.interrupt();
    }

}
