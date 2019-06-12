package com.andersen.training.cachingproxy.proxies;

import com.andersen.training.cachingproxy.constants.Constants;
import com.andersen.training.cachingproxy.constants.ExceptionConstants;
import com.andersen.training.cachingproxy.factories.HandlerFactory;
import com.andersen.training.cachingproxy.factories.PropertyFactory;
import com.andersen.training.cachingproxy.interfaces.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CacheProxy {
    private static final Logger LOGGER = Logger.getLogger(CacheProxy.class.getName());
    private Optional<String> cacheKindOpt = Optional.ofNullable(PropertyFactory.getProperty(Constants.PROPERTIES).getProperty(Constants.WHERE_TO_CACHING));

    public Service cache(Service service) {
        try {
            InvocationHandler handler = HandlerFactory.valueOf(cacheKindOpt.orElse(Constants.DEFAULT_CACHE)).getHandler(service);
            return ((Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler));
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new IllegalArgumentException(ExceptionConstants.CACHE_TYPE_EXCEPTION, e);
        }
    }
}

