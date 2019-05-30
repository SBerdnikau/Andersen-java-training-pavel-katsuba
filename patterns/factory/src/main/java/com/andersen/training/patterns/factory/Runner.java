package com.andersen.training.patterns.factory;

import com.andersen.training.patterns.factory.factories.EmployeeFactory;
import com.andersen.training.patterns.factory.interfaces.Employee;

public class Runner {
    public static void main(String[] args) {
        System.out.println("start param: " + args[0]);
        Employee employee = EmployeeFactory.getInstance("Guard");
        System.out.println("Type: " + employee.getClass().getSimpleName());
    }

}
