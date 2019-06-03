package com.andersen.test.refactor.services;

import com.andersen.test.refactor.interfaces.Position;

public enum Orientation {
    NORTH {
        @Override
        public void moveForwards(Position position) {
            position.goUp();
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.EAST;
        }
    },
    SOUTH {
        @Override
        public void moveForwards(Position position) {
            position.goDown();
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.WEST;
        }
    },
    WEST {
        @Override
        public void moveForwards(Position position) {
            position.goLeft();
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.NORTH;
        }
    },
    EAST {
        @Override
        public void moveForwards(Position position) {
            position.goRight();
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.SOUTH;
        }
    };

    public abstract void moveForwards(Position position);

    public abstract Orientation turnClockwise();

}
