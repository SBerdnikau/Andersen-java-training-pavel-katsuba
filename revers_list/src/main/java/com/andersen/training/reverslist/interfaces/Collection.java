package com.andersen.training.reverslist.interfaces;

public interface Collection<E> extends Iterable<E> {
    int find(E element);
    int size();
}
