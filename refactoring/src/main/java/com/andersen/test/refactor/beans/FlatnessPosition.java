package com.andersen.test.refactor.beans;

import com.andersen.test.refactor.interfaces.Position;

public class FlatnessPosition implements Position {
    private int x;
    private int y;

    public FlatnessPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void goUp() {
        y++;
    }

    @Override
    public void goDown() {
        y--;
    }

    @Override
    public void goRight() {
        x++;
    }

    @Override
    public void goLeft() {
        x--;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
