package com.andersen.training.multithreading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private static volatile int count = -1;
    private static boolean isInterrurted = false;

    public static void main(String[] args) throws TestException, InterruptedException {
        Set<Double> res = new HashSet<>();
        List<Thread> threads = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            Thread exThread = new Thread(() -> {
                while (count < TestConsts.N) {
                    try {
                        synchronized (res) {
                            count++;
                        }
                        if (count < TestConsts.N) {
                            Set<Double> result = TestCalc.calculate(count);
                            synchronized (res) {
                                res.addAll(result);
                            }
                        }
                    } catch (TestException e) {
                        logger.log(Level.WARNING, e.getMessage(), e);
                        count = TestConsts.N;
                        isInterrurted = true;
                    }
                }
            });
            exThread.start();
            threads.add(exThread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long takeTime = System.currentTimeMillis() - start;
        if (!isInterrurted) {
            System.out.println("take time: " + takeTime);
            System.out.println(res);
        }

    }

}
