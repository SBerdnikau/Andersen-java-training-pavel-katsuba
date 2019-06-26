package com.andersen.training.cachingproxy.services;

import com.andersen.training.cachingproxy.beans.User;
import com.andersen.training.cachingproxy.interfaces.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserStorage implements Storage<User> {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("petya", "pass", LocalDate.of(1962, 2, 12), 1));
        users.add(new User("masha", "world", LocalDate.of(1962, 2, 12), 2));
        users.add(new User("miron", "secret", LocalDate.of(1962, 2, 12), 3));
    }
    @Override
    public User getEntityById(int id) {
        System.out.println("doing work in getEntityById(int id) for id " + id);
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new IllegalArgumentException("wrong id: " + id);
    }

    @Override
    public User getEntityByName(String login) {
        System.out.println("doing work in getEntityByName(String login) for " + login);
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new IllegalArgumentException("wrong login: " + login);
    }
}
