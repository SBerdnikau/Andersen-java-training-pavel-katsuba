package com.andersen.training.patterns.factory_method.beans;

import com.andersen.training.patterns.factory_method.interfaces.Warrior;

public class SeaWarrior implements Warrior {
    @Override
    public void war() {
        System.out.println("fighting in sea");
    }
}
