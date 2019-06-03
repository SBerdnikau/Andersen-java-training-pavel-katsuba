package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.constants.ExceptionConstants;
import com.andersen.test.refactor.exceptions.TractorInDitchException;
import com.andersen.test.refactor.interfaces.Place;
import com.andersen.test.refactor.interfaces.Position;

public class Flatness implements Place {
    private int height;
    private int width;

    public Flatness() {
    }

    public Flatness(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void isGetInto(Position position) {
        if (position.getClass() != FlatnessPosition.class) {
            throw new IllegalArgumentException(ExceptionConstants.POSITION_TYPE_EXCEPTION);
        }
        FlatnessPosition flatnessPosition = (FlatnessPosition) position;
        int x = flatnessPosition.getX();
        int y = flatnessPosition.getY();
        if (x > width || x < 0 || y > height || y < 0) {
            throw new TractorInDitchException(ExceptionConstants.FIELD_OUT_EXCEPTION);
        }
    }
}
