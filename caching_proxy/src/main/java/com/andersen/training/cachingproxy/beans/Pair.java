package com.andersen.training.cachingproxy.beans;

public class Pair {
    private final String result;
    private final String args;

    public Pair(String result, String args) {
        this.result = result;
        this.args = args;
    }

    public Pair(String[] arr) {
        this.result = arr[1];
        this.args = arr[0];
    }

    public String getResult() {
        return result;
    }

    public String getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return args + ":" + result;
    }
}
