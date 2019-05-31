package com.andersen.training.patterns.builder;

import com.andersen.training.patterns.builder.beans.Account;
import com.andersen.training.patterns.builder.beans.Authorization;
import com.andersen.training.patterns.builder.beans.Registration;
import com.andersen.training.patterns.builder.builders.AccountBuilder;

/**
 * Here is created 2 objects Account with AccountBuilder.
 * classes Authorization, and Registration are needed for show that builder can create different objects of Account.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("First user:");
        Account firstUser = new AccountBuilder()
                .setName("p")
                .setPassword("1")
                .setEmail("k@v.com")
                .create();
        Registration.reg(firstUser);
        Authorization.login(firstUser);
        System.out.println("\r\nSecond user:");
        Account secondUser = new AccountBuilder()
                .setName("p")
                .setPassword("1")
                .create();
        Registration.reg(secondUser);
        Authorization.login(secondUser);
    }
}
