package com.andersen.training.patterns.factory_method.factories;

import com.andersen.training.patterns.factory_method.beans.FieldWarrior;
import com.andersen.training.patterns.factory_method.interfaces.Warrior;

public class FieldTroops extends Troops {
    @Override
    public Warrior createWarrior() {
        return new FieldWarrior();
    }
}
