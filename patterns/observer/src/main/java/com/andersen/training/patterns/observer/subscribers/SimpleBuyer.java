package com.andersen.training.patterns.observer.subscribers;

import com.andersen.training.patterns.observer.interfaces.Buyer;

public class SimpleBuyer implements Buyer {
    @Override
    public void buy() {
        System.out.println("just buying");
    }
}
