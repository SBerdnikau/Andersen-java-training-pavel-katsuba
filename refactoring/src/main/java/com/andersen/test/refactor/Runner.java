package com.andersen.test.refactor;

import com.andersen.test.refactor.beans.Position;
import com.andersen.test.refactor.beans.Tractor;
import com.andersen.test.refactor.services.Orientation;

public class Runner {
    public static void main(String[] args) {
        Tractor tractor = new Tractor(new Position(0, 0), new int[]{5, 5}, Orientation.NORTH);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                tractor.move(Constants.TURN_COMMAND);
            }
            tractor.move(Constants.FORWARD_COMMAND);
        }
    }
}
