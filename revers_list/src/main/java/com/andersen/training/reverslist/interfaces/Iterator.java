package com.andersen.training.reverslist.interfaces;

public interface Iterator<T> {
    T getNext();
    boolean hasNext();
    void remove();
    int addBefore(T element);
    int addAfter(T element);
}
