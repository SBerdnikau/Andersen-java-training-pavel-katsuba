package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.interfaces.Place;
import com.andersen.test.refactor.interfaces.Position;

public class Figure {
    protected Position position;
    protected Place field;

    public Figure() {
    }

    public Figure(FlatnessPosition position, Place field) {
        this.position = position;
        this.field = field;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Place getField() {
        return field;
    }

    public void setField(Place field) {
        this.field = field;
    }
}
