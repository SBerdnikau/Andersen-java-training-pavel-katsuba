package com.andersen.training.cachingproxy.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private final String login;
    private final String password;
    private final LocalDate birthday;
    private final int id;

    public User(String login, String password, LocalDate birthday, int id) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", id=" + id +
                '}';
    }
}
