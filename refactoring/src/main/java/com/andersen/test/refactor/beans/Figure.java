package com.andersen.test.refactor.beans;

public class Figure {
    protected Position position;
    protected int[] field;

    public Figure() {
    }

    public Figure(Position position, int[] field) {
        this.position = position;
        this.field = field;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int[] getField() {
        return field;
    }

    public void setField(int[] field) {
        this.field = field;
    }
}
