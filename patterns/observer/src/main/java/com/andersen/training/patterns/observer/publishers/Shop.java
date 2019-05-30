package com.andersen.training.patterns.observer.publishers;

import com.andersen.training.patterns.observer.interfaces.Buyer;
import com.andersen.training.patterns.observer.interfaces.Publisher;

import java.util.HashSet;
import java.util.Set;

public class Shop implements Publisher<Buyer> {
    private Set<Buyer> buyers = new HashSet<>();
    private boolean isProductReady;

    public Shop(Set<Buyer> buyers, boolean isProductReady) {
        this.buyers = buyers;
        this.isProductReady = isProductReady;
    }

    public Shop() {
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(Set<Buyer> buyers) {
        this.buyers = buyers;
    }

    public boolean isProductReady() {
        return isProductReady;
    }

    public void setProductReady(boolean productReady) {
        isProductReady = productReady;
        if (isProductReady) {
            notifySubscribers();
        }
    }

    @Override
    public void subscribe(Buyer subscriber) {
        System.out.println("add subscriber");
        buyers.add(subscriber);
    }

    @Override
    public void unsubscribe(Buyer subscriber) {
        System.out.println("delete subscriber");
        buyers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        System.out.println("notifying buyers");
        for (Buyer buyer: buyers) {
            buyer.buy();
        }
    }
}
