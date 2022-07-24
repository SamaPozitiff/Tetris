package main.java.manager;

import java.util.ArrayList;
import java.util.List;

import main.java.figure.Block;
import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.swing.IPaintGame;
import main.java.swing.PaintQueue;

public class Game {
    Field field;
    FigureManager figureManager;
    FigureControl figureControl;
    IPaintGame paintGame;

    public Game(IQueueListener queueListener, IPaintGame paintGame) {
        field = new Field();
        figureManager = new FigureManager(queueListener);
        figureControl = new FigureControl(field, figureManager);
        figureControl.getFigureFromQueue();
        this.paintGame = paintGame;
    }

    public void startGame() {
        while (true) {
            makeGameStep();
            paintGame.paintGame(getAllBlocks());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void makeGameStep() {
        figureControl.goDown();
    }

    public List<Block> getAllBlocks() {
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

