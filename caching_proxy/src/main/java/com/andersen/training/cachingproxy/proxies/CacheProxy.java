package com.andersen.training.cachingproxy.proxies;

import com.andersen.training.cachingproxy.annotations.Caching;
import com.andersen.training.cachingproxy.exceptions.CacheManagerException;
import com.andersen.training.cachingproxy.utils.CacheManager;

import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CacheProxy {
    private static final Logger LOGGER = Logger.getLogger(CacheProxy.class.getName());

    @SuppressWarnings("unchecked")
    public <T> T cache(T service) {
        return ((T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    try {
                        Caching annotation = method.getAnnotation(Caching.class);
                        if (annotation != null) {
                            String key = "".equals(annotation.key()) ? method.getName() : annotation.key();
                            CacheManager cacheManager = annotation.cachingWay();
                            Object cacheResult = cacheManager.checkCache(annotation, args, key);
                            if (cacheResult != null) {
                                return cacheResult;
                            }
                            Object result = method.invoke(service, args);
                            cacheManager.cache(annotation, result, args, key);
                            return result;
                        }
                    } catch (CacheManagerException e) {
                        LOGGER.log(Level.INFO, e.getCause().getMessage().split(";")[0] + " should be marked Serializable");
                    }
                    return method.invoke(service, args);
                }));
    }
}

