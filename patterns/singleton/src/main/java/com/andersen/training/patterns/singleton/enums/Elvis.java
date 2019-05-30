package com.andersen.training.patterns.singleton.enums;

public enum Elvis {
    INSTANCE;

    Elvis() {
        System.out.println("creating Elvis");
    }

    public void leaveTheBuilding() {
        System.out.println("leaving");
    }
}
