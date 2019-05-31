package com.andersen.training.patterns.delegate.beans;

import com.andersen.training.patterns.delegate.enums.Gender;

public class Person {
    private String name;
    private Gender gender;

    public Person() {
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender.name();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

