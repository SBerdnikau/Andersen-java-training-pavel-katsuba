package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.interfaces.Place;
import com.andersen.test.refactor.services.Orientation;
import com.andersen.test.refactor.interfaces.Move;

public abstract class MoveFigure extends Figure implements Move {
    protected Orientation orientation;

    public MoveFigure(FlatnessPosition position, Place field, Orientation orientation) {
        super(position, field);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
