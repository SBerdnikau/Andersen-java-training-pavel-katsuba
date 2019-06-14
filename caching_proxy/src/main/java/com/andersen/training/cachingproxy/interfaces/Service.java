package com.andersen.training.cachingproxy.interfaces;

import com.andersen.training.cachingproxy.annotations.Caching;

public interface Service {
    @Caching(key = "OK")
    String doHardWork(String param);
}
