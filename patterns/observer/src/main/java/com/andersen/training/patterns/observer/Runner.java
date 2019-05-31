package com.andersen.training.patterns.observer;

import com.andersen.training.patterns.observer.publishers.Shop;
import com.andersen.training.patterns.observer.subscribers.DiscountBuyer;
import com.andersen.training.patterns.observer.subscribers.SimpleBuyer;

/**
 * Class Shop works like publisher, Buyers work like subscriber
 */
public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.subscribe(new SimpleBuyer());
        shop.setProductReady(true);
        shop.subscribe(new DiscountBuyer());
        shop.notifySubscribers();
    }
}
