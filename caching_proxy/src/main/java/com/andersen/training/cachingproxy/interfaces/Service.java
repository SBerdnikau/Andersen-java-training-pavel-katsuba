package com.andersen.training.cachingproxy.interfaces;

import com.andersen.training.cachingproxy.annotations.Cacheble;

public interface Service {
    @Cacheble
    String doHardWork(String param);
}
