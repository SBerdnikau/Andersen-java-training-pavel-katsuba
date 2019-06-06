package com.andersen.training.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;

/**
 * Необходимо уменьшить время выполнения вычислений.
 * <p>
 * Можно изменять этот класс или добавить новый. Решение должно быть максимально простым, без использования экзекуторов.
 * (Runnable, Threads). Аккуратно обработайте потенциальные ошибки (разумеется вычисления если появились ошибки нужно
 * остановить)
 */
public class Test {

    public static void main(String[] args) throws TestException {
        Set<Double> res = new HashSet<>();
        Queue<FutureTask> tasks = new ConcurrentLinkedQueue<>();
        List<Thread> threads = new ArrayList<>();
        List<FutureTask> futureTasks = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < TestConsts.N; i++) {
            FutureTask<Object> futureTask = new FutureTask<>(new Executor(res, i), null);
            tasks.add(futureTask);
            futureTasks.add(futureTask);
        }
        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    FutureTask nextTask = tasks.poll();
                    if (nextTask != null) {
                        nextTask.run();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (FutureTask futureTask : futureTasks) {
            while (!futureTask.isDone()) ;
        }
        for (Thread thread : threads) {
            thread.interrupt();
        }
        long takeTime = System.currentTimeMillis() - start;
        System.out.println("take time: " + takeTime);

        System.out.println(res);
    }
}
