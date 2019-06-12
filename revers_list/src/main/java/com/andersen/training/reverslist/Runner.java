package com.andersen.training.reverslist;

import com.andersen.training.reverslist.impls.LinkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(1);
        ints.add(8);
        ints.add(6);
        ints.add(1);
        ints.add(null);
        System.out.println(ints);
        ints.reversList();
        System.out.println(ints);
    }
}
