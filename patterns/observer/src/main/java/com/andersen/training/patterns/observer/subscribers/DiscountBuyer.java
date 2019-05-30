package com.andersen.training.patterns.observer.subscribers;

import com.andersen.training.patterns.observer.interfaces.Buyer;

public class DiscountBuyer implements Buyer {
    @Override
    public void buy() {
        System.out.println("buying with discount");
    }
}
