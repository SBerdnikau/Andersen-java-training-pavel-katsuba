package com.andersen.training.cachingproxy;

import com.andersen.training.cachingproxy.interfaces.Service;
import com.andersen.training.cachingproxy.proxies.CacheProxy;
import com.andersen.training.cachingproxy.services.ServiceImpl;

public class Runner {
    public static void main(String[] args) {
        Service cache = new CacheProxy().cache(new ServiceImpl());
        String res = cache.doHardWork("hhh");
        System.out.println(res);
        System.out.println(cache.doHardWork("hhh"));
        System.out.println(cache.doHardWork("ggg"));
        System.out.println(cache.doHardWork("ggg"));
    }
}
