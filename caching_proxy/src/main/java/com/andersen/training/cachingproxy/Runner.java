package com.andersen.training.cachingproxy;

import com.andersen.training.cachingproxy.interfaces.Service;
import com.andersen.training.cachingproxy.interfaces.Storage;
import com.andersen.training.cachingproxy.proxies.CacheProxy;
import com.andersen.training.cachingproxy.services.ServiceImpl;
import com.andersen.training.cachingproxy.services.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        CacheProxy cacheProxy = new CacheProxy();
        Service cache = cacheProxy.cache(new ServiceImpl());
        String res = cache.doHardWork("hhh");
        System.out.println(res);
        System.out.println(cache.doHardWork("hhh"));
        System.out.println(cache.doHardWork("ggg"));
        System.out.println(cache.doHardWork("ggg"));
        System.out.println(cache.doHardWork("hhh"));
        Storage supluier = cacheProxy.cache(new UserStorage());
        System.out.println(supluier.getEntityById(1));
        System.out.println(supluier.getEntityById(2));
        System.out.println(supluier.getEntityById(1));
//        System.out.println(supluier.getEntityByName("miron"));
//        System.out.println(supluier.getEntityByName("masha"));
//        System.out.println(supluier.getEntityByName("miron"));

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(() -> {
            System.out.println(supluier.getEntityByName("miron"));
        }));
        threads.add(new Thread(() -> {
            System.out.println(supluier.getEntityByName("masha"));
        }));
        threads.add(new Thread(() -> {
            System.out.println(supluier.getEntityByName("miron"));
        }));
        threads.add(new Thread(() -> {
            System.out.println(supluier.getEntityByName("miron"));
        }));
        threads.add(new Thread(() -> {
            System.out.println(supluier.getEntityByName("petya"));
        }));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
