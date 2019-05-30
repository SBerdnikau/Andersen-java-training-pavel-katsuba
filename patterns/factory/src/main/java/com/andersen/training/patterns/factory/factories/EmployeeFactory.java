package com.andersen.training.patterns.factory.factories;

import com.andersen.training.patterns.factory.beans.Cashier;
import com.andersen.training.patterns.factory.beans.Guard;
import com.andersen.training.patterns.factory.interfaces.Employee;

public class EmployeeFactory {
    public static Employee getInstance(String type) {
        switch (type) {
            case "Cashier":
                return new Cashier();
            case "Guard":
                return new Guard();
            default:
                throw new IllegalArgumentException("wrong type -> " + type);
        }
    }
}
