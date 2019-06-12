package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.interfaces.Command;
import com.andersen.test.refactor.interfaces.Place;
import com.andersen.test.refactor.services.Orientation;

public class Tractor extends MoveFigure {

    public static final String CURRENT_POSITION = "Current position: ";

    public Tractor(FlatnessPosition position, Place field, Orientation orientation) {
        super(position, field, orientation);
    }

    @Override
    public void move(Command command) {
        command.execute(this);
        System.out.println(CURRENT_POSITION + position);
    }
}
