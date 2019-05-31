package com.andersen.training.patterns.factory_method.factories;

import com.andersen.training.patterns.factory_method.interfaces.Warrior;

public abstract class Troops {
    /**
     * Method sendWarriorToWar() creates Warrior object and call his method war().
     */
    public void sendWarriorToWar() {
        Warrior warrior = createWarrior();
        warrior.war();
    }

    protected abstract Warrior createWarrior();
}
