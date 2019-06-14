package com.andersen.training.cachingproxy.exceptions;

public class CacheManagerException extends RuntimeException {
    public CacheManagerException(Throwable cause) {
        super(cause);
    }

    public CacheManagerException(String message) {
        super(message);
    }

    public CacheManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
