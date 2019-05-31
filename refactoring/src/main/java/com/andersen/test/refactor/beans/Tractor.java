package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.Constants;
import com.andersen.test.refactor.services.Orientation;
import com.andersen.test.refactor.exceptions.TractorInDitchException;

public class Tractor extends MoveFigure {

    public static final String CURRENT_POSITION = "Current position: ";
    public static final String SEPARATOR = " ";

    public Tractor(Position position, int[] field, Orientation orientation) {
        super(position, field, orientation);
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

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void move(String command) {
        if (Constants.FORWARD_COMMAND.equals(command)) {
            moveForwards();
        } else if (Constants.TURN_COMMAND.equals(command)) {
            turnClockwise();
        }
        System.out.println(CURRENT_POSITION + position.getX() + SEPARATOR + position.getY());
    }

    private void moveForwards() {
        orientation.moveForwards(position);
        int x = position.getX();
        int y = position.getY();
        if (x > field[0] || x < 0 || y > field[1] || y < 0) {
            throw new TractorInDitchException(Constants.FIELD_OUT_EXCEPTION);
        }
    }

    private void turnClockwise() {
        orientation = orientation.turnClockwise();
    }
}
