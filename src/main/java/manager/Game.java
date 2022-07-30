package main.java.manager;

import java.util.ArrayList;
import java.util.List;

import main.java.figure.Block;
import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.swing.DrawReserve;
import main.java.swing.IPaintGame;
import main.java.swing.PaintQueue;

import javax.swing.*;

public class Game extends JPanel{
    Field field;
    FigureManager figureManager;
    FigureControl figureControl;
    IPaintGame paintGame;
    IReserveListener reserveListener;

    public Game(IQueueListener queueListener, IPaintGame paintGame, IReserveListener drawReserve) {
        field = new Field();
        figureManager = new FigureManager(queueListener);
        reserveListener = drawReserve;
        figureControl = new FigureControl(field, figureManager, reserveListener);
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
        if (figureControl.isGameOver()){
            int result = JOptionPane.showConfirmDialog(this, "GAME OVER" + "\n" + "Начать сначала?", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION){
                figureControl.setGameOver(false);
                field.makeFieldClean();
                startGame();
                repaint();

            }
        }
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

