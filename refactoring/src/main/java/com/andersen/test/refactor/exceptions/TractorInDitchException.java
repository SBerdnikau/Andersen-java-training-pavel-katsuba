package com.andersen.test.refactor.exceptions;

public class TractorInDitchException extends RuntimeException {
    public TractorInDitchException() {
    }

    public TractorInDitchException(String message) {
        super(message);
    }
}
