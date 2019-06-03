package com.andersen.test.refactor;

import com.andersen.test.refactor.beans.Flatness;
import com.andersen.test.refactor.beans.FlatnessPosition;
import com.andersen.test.refactor.beans.Tractor;
import com.andersen.test.refactor.commands.MoveForwardCommand;
import com.andersen.test.refactor.commands.TurnCommand;
import com.andersen.test.refactor.services.Orientation;

public class Runner {
    public static void main(String[] args) {
        Tractor tractor = new Tractor(new FlatnessPosition(0, 0), new Flatness(5, 5), Orientation.NORTH);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                tractor.move(new TurnCommand());
            }
            tractor.move(new MoveForwardCommand());
        }
    }
}
