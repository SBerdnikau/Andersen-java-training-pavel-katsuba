package com.andersen.training.cachingproxy.handlers;

import com.andersen.training.cachingproxy.constants.Constants;
import com.andersen.training.cachingproxy.annotations.Cacheble;
import com.andersen.training.cachingproxy.beans.Pair;
import com.andersen.training.cachingproxy.factories.PropertyFactory;
import com.andersen.training.cachingproxy.interfaces.Service;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCacheHandler implements InvocationHandler {
    private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());
    private final Service service;
    private final Optional<String> fileNameKey;
    private final Optional<String> rootDirKey;

    public FileCacheHandler(Service service) {
        this.service = service;
        Properties property = PropertyFactory.getProperty(Constants.PROPERTIES);
        fileNameKey = Optional.ofNullable(property.getProperty(Constants.DO_HARD_WORK_KEY));
        rootDirKey = Optional.ofNullable(property.getProperty(Constants.ROOT_PATH_PROP_KEY));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getAnnotation(Cacheble.class) != null) {
                String key = fileNameKey.orElse(method.getName());
                String rootDir = rootDirKey.orElse(Constants.DEFAULT_ROOT_PATH);
                Path filePath = Paths.get(rootDir + key);
                StringBuilder argsBuilder = new StringBuilder();
                for (Object arg : args) {
                    argsBuilder.append(arg);
                }
                if (Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
                    List<String> cachedResults = Files.readAllLines(filePath);
                    Pair pair = new Pair(cachedResults.get(0).split(Constants.REGEX));
                    if (pair.getArgs().equals(argsBuilder.toString())) {
                        return pair.getResult();
                    }
                }
                String result = (String) method.invoke(service, args);
                Files.write(filePath, (argsBuilder.toString() + Constants.REGEX + result).getBytes(), StandardOpenOption.CREATE);
                return result;
            }
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage(), e);
        }
        return method.invoke(service, args);
    }
}
