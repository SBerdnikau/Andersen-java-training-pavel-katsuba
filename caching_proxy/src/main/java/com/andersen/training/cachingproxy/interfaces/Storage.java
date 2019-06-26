package com.andersen.training.cachingproxy.interfaces;

import com.andersen.training.cachingproxy.annotations.Caching;
import com.andersen.training.cachingproxy.utils.CacheManager;

public interface Storage<T> {
    @Caching(cachingWay = CacheManager.MAP)
    T getEntityById(int id);

    @Caching(key = "UsersByName")
    T getEntityByName(String name);
}
