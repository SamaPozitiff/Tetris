package main.java.manager;

import java.util.LinkedList;
import java.util.Queue;

import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.figure.GenerateFigure;

public class FigureManager {
    Queue<Figure> queue;
    Field field;
    Figure currentFigure;
    GenerateFigure generate;

    public FigureManager(Field field) {
        queue = new LinkedList<Figure>();
        generate = new GenerateFigure();
        addFigureAtQueue();
        this.field = field;
    }

    public void addFigureAtQueue() {
        queue.add(generate.createFigure());
    }

    public Figure getFigureAndDeleteFromQueue() {
        return queue.poll();

    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public void figureOnStart() {
        currentFigure = queue.poll();
        currentFigure.setAbcoluteY(0);
        currentFigure.setAbsoluteX(Field.FIELD_X / 2);
    }

    public boolean canFigureFall() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isNextDownBlockEmpty(currentFigure.getBlock(i).getX(), currentFigure.getBlock(i).getY()) == false
                    || currentFigure.getBlock(i).getY() == Field.FIELD_Y - 1) {
                return false;
            }

        }
        return true;
    }

    public boolean canFigureMoveRight() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isNextRightBlockEmpty(currentFigure.getBlock(i).getX(), currentFigure.getBlock(i).getY()) == false
                    || currentFigure.getBlock(i).getX() == Field.FIELD_X - 1) {
                return false;
            }

        }
        return true;
    }

    public boolean canFigureMoveLeft() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isNextLeftBlockEmpty(currentFigure.getBlock(i).getX(), currentFigure.getBlock(i).getY()) == false
                    || currentFigure.getBlock(i).getX() == 0) {
                return false;
            }

        }
        return true;
    }

    public void figureGoDown() {
        if (canFigureFall()) {
            currentFigure.goDown();
        } else {
            field.addFigureToField(currentFigure);
            addFigureAtQueue();
            figureOnStart();
        }
    }

    public boolean canFigureRotateRight() {
        Figure tester = currentFigure.cloneFigure(currentFigure);
        tester.rotateRight();
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.IsBlockEmpty(tester.getBlock(i).getX(), tester.getBlock(i).getY()) == false
                    || tester.getBlock(i).getX() < 0 || tester.getBlock(i).getX() >= Field.FIELD_X - 1
                    || tester.getBlock(i).getY() >= Field.FIELD_Y - 1) {
                return false;

            }
        }
        return true;
    }

    public boolean canFigureRotateLeft() {
        Figure tester = currentFigure.cloneFigure(currentFigure);
        tester.rotateLeft();
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.IsBlockEmpty(tester.getBlock(i).getX(), tester.getBlock(i).getY()) == false
                    || tester.getBlock(i).getX() < 0 || tester.getBlock(i).getX() == Field.FIELD_X - 1
                    || tester.getBlock(i).getY() >= Field.FIELD_Y - 1) {
                return false;
            }
        }
        return true;
    }

}

