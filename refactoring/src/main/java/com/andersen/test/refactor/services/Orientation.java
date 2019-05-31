package com.andersen.test.refactor.services;

import com.andersen.test.refactor.beans.Position;

public enum Orientation {
    NORTH {
        @Override
        public void moveForwards(Position position) {
            position.setY(position.getY() + 1);
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.EAST;
        }
    },
    SOUTH {
        @Override
        public void moveForwards(Position position) {
            position.setY(position.getY() - 1);
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.WEST;
        }
    },
    WEST {
        @Override
        public void moveForwards(Position position) {
            position.setX(position.getX() - 1);
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.NORTH;
        }
    },
    EAST {
        @Override
        public void moveForwards(Position position) {
            position.setX(position.getX() + 1);
        }

        @Override
        public Orientation turnClockwise() {
            return Orientation.SOUTH;
        }
    };

    public abstract void moveForwards(Position position);

    public abstract Orientation turnClockwise();

}
