package com.andersen.training.cachingproxy.beans;

import java.io.Serializable;

public class Pair<T> implements Serializable {
    private final T result;
    private final Object[] args;

    public Pair(T result, Object[] args) {
        this.result = result;
        this.args = args;
    }

    public T getResult() {
        return result;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public int hashCode() {
        int h = 31;
        for (Object arg : args) {
            h = h + h * arg.hashCode();
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (args.length != pair.getArgs().length) {
            return false;
        }
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals(pair.getArgs()[i])) {
                return false;
            }
        }
        return true;
    }
}
