package com.andersen.training.cachingproxy.services;

import com.andersen.training.cachingproxy.interfaces.Service;

public class ServiceImpl implements Service { ;

    @Override
    public String doHardWork(String param) {
        System.out.println("doing work in doHardWork(String param)");
        return "we call this method time with param -> " + param;
    }
}
