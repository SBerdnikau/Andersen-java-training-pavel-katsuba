package com.andersen.training.patterns.factory_method;

import com.andersen.training.patterns.factory_method.factories.FieldTroops;
import com.andersen.training.patterns.factory_method.factories.SeaTroops;
import com.andersen.training.patterns.factory_method.factories.Troops;

/**
 * Here are two factory SeaTroops and FieldTroops.
 * They can create warriors. SeaTroops creates SeaWarrior, FieldTroops creates FieldWarrior.
 */
public class Runner {
    public static void main(String[] args) {
        Troops troops = null;
        switch (args[0]) {
            case "SeaBattle":
                troops = new SeaTroops();
                break;
            case "FieldBattle":
                troops = new FieldTroops();
                break;
                default: throw new IllegalArgumentException("wrong type of battle -> " + args[0]);
        }
        troops.sendWarriorToWar();
    }
}
