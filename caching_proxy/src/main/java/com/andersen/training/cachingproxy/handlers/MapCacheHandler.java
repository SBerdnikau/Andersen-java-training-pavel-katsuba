package com.andersen.training.cachingproxy.handlers;

import com.andersen.training.cachingproxy.constants.Constants;
import com.andersen.training.cachingproxy.annotations.Cacheble;
import com.andersen.training.cachingproxy.beans.Pair;
import com.andersen.training.cachingproxy.factories.PropertyFactory;
import com.andersen.training.cachingproxy.interfaces.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class MapCacheHandler implements InvocationHandler {
    private final Map<String, Pair> cache = new HashMap<>();
    private final Service service;
    private final Optional<String> methodKey;

    public MapCacheHandler(Service service) {
        this.service = service;
        Properties properties = PropertyFactory.getProperty(Constants.PROPERTIES);
        methodKey = Optional.ofNullable(properties.getProperty(Constants.DO_HARD_WORK_KEY));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getAnnotation(Cacheble.class) != null) {
            String key = methodKey.orElse(method.getName());
            StringBuilder argsBuilder = new StringBuilder();
            for (Object arg : args) {
                argsBuilder.append(arg);
            }
            Pair pair = cache.get(key);
            if (pair != null && pair.getArgs().equals(argsBuilder.toString())) {
                return pair.getResult();
            }
            String result = (String) method.invoke(service, args);
            cache.put(key, new Pair(result, argsBuilder.toString()));
            return result;
        }
        return method.invoke(service, args);
    }
}
