package com.andersen.training.patterns.factory_method.factories;

import com.andersen.training.patterns.factory_method.beans.SeaWarrior;
import com.andersen.training.patterns.factory_method.interfaces.Warrior;

public class SeaTroops extends Troops {
    @Override
    public Warrior createWarrior() {
        return new SeaWarrior();
    }
}
