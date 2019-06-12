package com.andersen.training.reverslist.exceptions;

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }

    public EmptyCollectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
