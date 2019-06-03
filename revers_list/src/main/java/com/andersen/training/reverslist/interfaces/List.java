package com.andersen.training.reverslist.interfaces;

import java.util.Comparator;

public interface List<E> extends Collection<E> {
    int add(E element);
    void addAll(Collection<? extends E> collection);
    void addAll(E[] elements);
    void clear();
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    E[] toArray(E[] elements);
    void trim();
    void filterMatches(Collection<E> collection);
    void filterMatches(E[] elements, Comparator<? super E> comparator);
    void filterDifference(Collection<E> collection);
    void filterDifference(E[] elements, Comparator<? super E> comparator);
    void setMaxSize(int size);
    int getMaxSize();
}
