package com.andersen.test.refactor.commands;

import com.andersen.test.refactor.beans.Figure;
import com.andersen.test.refactor.beans.MoveFigure;
import com.andersen.test.refactor.constants.ExceptionConstants;
import com.andersen.test.refactor.interfaces.Command;
import com.andersen.test.refactor.services.Orientation;

public class TurnCommand implements Command {

    @Override
    public void execute(Figure figure) {
        if (!(figure instanceof MoveFigure)) {
            throw new IllegalArgumentException(ExceptionConstants.FIGURE_TYPE_EXCEPTION);
        }
        MoveFigure moveFigure = (MoveFigure) figure;
        Orientation orientation = moveFigure.getOrientation();
        moveFigure.setOrientation(orientation.turnClockwise());
    }
}
