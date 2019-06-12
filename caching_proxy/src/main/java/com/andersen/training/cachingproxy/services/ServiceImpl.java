package com.andersen.training.cachingproxy.services;

import com.andersen.training.cachingproxy.annotations.Cacheble;
import com.andersen.training.cachingproxy.interfaces.Service;

public class ServiceImpl implements Service {
    private int callCount;

    @Override
    @Cacheble
    public String doHardWork(String param) {
        return "we call this method " + callCount++ + " time with param -> " + param;
    }
}
