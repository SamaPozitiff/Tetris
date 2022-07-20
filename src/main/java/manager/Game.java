package main.java.manager;

import java.util.ArrayList;

import main.java.figure.Block;
import main.java.figure.Field;
import main.java.figure.Figure;

public class Game {
    Field field;
    FigureManager figureManager;
    FigureControl figureControl;

    public Game() {
        field = new Field();
        figureManager = new FigureManager();
        figureControl = new FigureControl(field, figureManager);
        figureControl.getFigureFromQueue();
    }

    public void makeGameStep() {
        figureControl.goDown();
    }

    public ArrayList<Block> getAllBlocks() {
        ArrayList<Block> allBlocks = new ArrayList<Block>();
        for (Block block : field.getBlocks()) {
            allBlocks.add(block);
        }
        for (int i = 0; i < Figure.SIZE; i++) {
            allBlocks.add(figureControl.getFigure().getBlock(i));
        }
        return allBlocks;
    }



}

