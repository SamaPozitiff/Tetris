package main.java.manager;

import java.util.ArrayList;

import main.java.figure.Block;
import main.java.figure.Field;
import main.java.figure.Figure;

public class Game {
    Field field;
    FigureManager figureManager;

    public Game() {
        field = new Field();
        figureManager = new FigureManager(field);
        figureManager.figureOnStart();
    }

    public void makeGameStep() {
        figureManager.figureGoDown();
    }

    public ArrayList<Block> getAllBlocks() {
        ArrayList<Block> allBlocks = new ArrayList<Block>();
        for (Block block : field.getBlocks()) {
            allBlocks.add(block);
        }
        for (int i = 0; i < Figure.SIZE; i++) {
            allBlocks.add(figureManager.getCurrentFigure().getBlock(i));
        }
        return allBlocks;
    }

    public void moveLeft() {
        if (figureManager.canFigureMoveLeft()) {
            figureManager.currentFigure.goLeft();
        }
    }

    public void moveRight() {
        if (figureManager.canFigureMoveRight()) {
            figureManager.currentFigure.goRight();
        }
    }

    public void rotateFigureRight() {
        if (figureManager.canFigureRotateRight()) {
            figureManager.currentFigure.rotateRight();

        }

    }

    public void rotateFigureLeft() {
        if (figureManager.canFigureRotateLeft()) {
            figureManager.currentFigure.rotateLeft();
        }
    }

    public void dropFigureDown(){
        while(figureManager.canFigureFall()){
            figureManager.currentFigure.goDown();
        }
    }

}

