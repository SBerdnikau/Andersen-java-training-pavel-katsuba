package com.andersen.training.cachingproxy.factories;

import com.andersen.training.cachingproxy.handlers.FileCacheHandler;
import com.andersen.training.cachingproxy.handlers.MapCacheHandler;
import com.andersen.training.cachingproxy.interfaces.Service;

import java.lang.reflect.InvocationHandler;

public enum HandlerFactory {
    FILE {
        @Override
        public InvocationHandler getHandler(Service service) {
            return new FileCacheHandler(service);
        }
    },
    MAP {
        @Override
        public InvocationHandler getHandler(Service service) {
            return new MapCacheHandler(service);
        }
    };
    public abstract InvocationHandler getHandler(Service service);
}
