package main.java.manager;

import main.java.figure.Field;
import main.java.figure.Figure;

//НЕ КОНТРОЛЛЕР
public class FigureControl {
    IFigureManager figureManager;
    IField field;
    Figure figure;
    Figure inReserve;
    IReserveListener reserveListener;

    public FigureControl(IField field, IFigureManager figureManager, IReserveListener reserveListener) {
        this.figureManager = figureManager;
        this.field = field;
        this.reserveListener = reserveListener;
    }

    public void getFigureFromQueue() {
        figure = figureManager.getNextFigure();
        figure.setAbsoluteX(IField.FIELD_X / 2);
    }

    public Figure getFigure(){
        return figure;
    }



    public void goDown() {
        if (canGoDown()) {
            figure.goDown();
        } else {
            field.addBlock(figure.getAllBlocks());
            getFigureFromQueue();
        }
    }

    public void dropDown() {
        while (canGoDown()) {
            figure.goDown();
        }
    }

    private boolean canGoDown() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(figure.getBlock(i).getX(), figure.getBlock(i).getY() + 1) == false
                    || figure.getBlock(i).getY() >= IField.FIELD_Y -1) {
                return false;
            }
        }
        return true;
    }

    public void goLeft() {
        if (canMoveLeft()) {
            figure.goLeft();
        }
    }

    private boolean canMoveLeft() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(figure.getBlock(i).getX() - 1, figure.getBlock(i).getY()) == false
                    || figure.getBlock(i).getX() - 1 < 0) {
                return false;
            }
        }
        return true;
    }


    public void goRight() {
        if (canMoveRight()) {
            figure.goRight();
        }
    }

    private boolean canMoveRight() {
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(figure.getBlock(i).getX() + 1, figure.getBlock(i).getY()) == false
                    || figure.getBlock(i).getX() + 1 > IField.FIELD_X - 1) {
                return false;
            }
        }
        return true;
    }

    public void rotateRight() {
        if (canRotateRight()) {
            figure.rotateRight();
        }
    }

    private boolean canRotateRight() {
        Figure testFigure = figure.cloneFigure(figure);
        testFigure.rotateRight();
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(testFigure.getBlock(i).getX(), testFigure.getBlock(i).getY()) == false
                    || testFigure.getBlock(i).getX() < 0
                    || testFigure.getBlock(i).getX() >= IField.FIELD_X
                    || testFigure.getBlock(i).getY() >= IField.FIELD_Y) {
                return false;
            }
        }
        return true;
    }

    public void rotateLeft() {
        if (canRotateLeft()) {
            figure.rotateLeft();
        }
    }

    private boolean canRotateLeft() {
        Figure testFigure = figure.cloneFigure(figure);
        testFigure.rotateLeft();
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(testFigure.getBlock(i).getX(), testFigure.getBlock(i).getY()) == false
                    || testFigure.getBlock(i).getX() < 0
                    || testFigure.getBlock(i).getX() >= IField.FIELD_X
                    || testFigure.getBlock(i).getY() >= IField.FIELD_Y) {
                return false;
            }
        }
        return true;
    }
    public void reserveFigure(){
        if (inReserve == null){
            inReserve = figure;
            getFigureFromQueue();
        }else {
            Figure intermediateFigure = inReserve;
            intermediateFigure.setAbsoluteX(figure.getAbsoluteX());
            intermediateFigure.setAbcoluteY(figure.getAbsoluteY());
            inReserve = figure;
            figure = intermediateFigure;
        }
    reserveListener.paintReserveFigure(inReserve);
    }


}

