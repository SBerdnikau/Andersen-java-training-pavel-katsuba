package com.andersen.training.patterns.delegate;

import com.andersen.training.patterns.delegate.beans.Person;
import com.andersen.training.patterns.delegate.enums.Gender;

/**
 * Class Person has Gender object like field.
 * When we call method getGender() from user, user delegates call to Gender.
 */
public class Runner {
    public static void main(String[] args) {
        Person user = new Person("Pasha", Gender.MALE);
        String gender = user.getGender();
        System.out.println(gender);
    }
}
