package com.andersen.training.patterns.observer.interfaces;

public interface Publisher<T> {
    void subscribe(T subscriber);
    void unsubscribe(T subscriber);
    void notifySubscribers();
}
