package com.andersen.training.cachingproxy;

import java.util.Comparator;

public class ArrayComporator implements Comparator<Object[]> {
    @Override
    public int compare(Object[] thisArr, Object[] thatArr) {
        if (thisArr.length != thatArr.length) {
            return -1;
        }
        for (int i = 0; i < thisArr.length; i++) {
            if (!thisArr[i].equals(thatArr[i])) {
                return -1;
            }
        }
        return 0;
    }
}
