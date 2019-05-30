package com.andersen.training.patterns.singleton;

import com.andersen.training.patterns.singleton.enums.Elvis;

/**
 * Enum Elvis can be used as singleton.
 * Here we can see when is created firstElvis Elvis constructor is called and message "creating Elvis" is printed to console.
 * When is created secondElvis massage isn't printed. Instead method returns already exist object.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("create firstElvis");
        Elvis firstElvis = Elvis.INSTANCE;
        System.out.println("first call");
        firstElvis.leaveTheBuilding();
        System.out.println("create secondElvis");
        Elvis secondElvis = Elvis.INSTANCE;
        System.out.println("second call");
        secondElvis.leaveTheBuilding();
    }
}
