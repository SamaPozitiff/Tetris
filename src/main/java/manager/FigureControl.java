package main.java.manager;

import main.java.figure.Figure;

//НЕ КОНТРОЛЛЕР
public class FigureControl {
    private IFigureManager figureManager;
    private IField field;
    private Figure figure;
    private Figure reserve;
    private IReserveListener reserveListener;
    private static boolean gameOver = false;

    public FigureControl(IField field, IFigureManager figureManager, IReserveListener reserveListener) {
        this.figureManager = figureManager;
        this.field = field;
        this.reserveListener = reserveListener;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }

    public void checkGameOver(){
        for (int i = 0; i < Figure.SIZE; i++){
            if (field.isBlockEmpty(figure.getBlock(i).getX(), figure.getBlock(i).getY()) == false){
               gameOver = true;
               break;
            }else {
                gameOver = false;
            }
        }
    }

    public void getFigureFromQueue() {
        figure = figureManager.getNextFigure();
        figure.setAbsoluteX(IField.FIELD_X / 2);
        checkGameOver();
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
        if (canRotate(testFigure)){
            return true;
        }else{
            return false;
        }
    }

    public void rotateLeft() {
        if (canRotateLeft()) {
            figure.rotateLeft();
        }
    }

    private boolean canRotateLeft() {
        Figure testFigure = figure.cloneFigure(figure);
        testFigure.rotateLeft();
        if (canRotate(testFigure)){
            return true;
        }else{
            return false;
        }
    }

    private boolean canRotate(Figure figure){
        for (int i = 0; i < Figure.SIZE; i++) {
            if (field.isBlockEmpty(figure.getBlock(i).getX(), figure.getBlock(i).getY()) == false
                    || figure.getBlock(i).getX() < 0
                    || figure.getBlock(i).getX() >= IField.FIELD_X
                    || figure.getBlock(i).getY() >= IField.FIELD_Y) {
                return false;
            }
        }
        return true;
    }


    public void reserveFigure() {
        if (reserve == null) {
            reserve = figure;
            getFigureFromQueue();
        } else {
            Figure intermediateFigure = reserve;
            intermediateFigure.setAbsoluteX(figure.getAbsoluteX());
            intermediateFigure.setAbcoluteY(figure.getAbsoluteY());
            reserve = figure;
            figure = intermediateFigure;
        }
        reserveListener.paintReserveFigure(reserve);
    }


}

