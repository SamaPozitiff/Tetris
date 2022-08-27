package main.java.figure;

import main.java.manager.HighScore;
import main.java.manager.IField;
import main.java.manager.Observable;
import main.java.manager.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Field implements IField, Observable {
    ArrayList<Block> blocks;
    public static final int FIELD_Y = 20;
    public static final int FIELD_X = 20;
    private List<Observer> observers;

    public Field() {
        blocks = new ArrayList<Block>();
        observers = new ArrayList<>();
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    @Override
    public boolean isBlockEmpty(int x, int y) {
        for (Block block : blocks) {
            if (block.getX() == x && block.getY() == y) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addBlock(List<Block> figure) {
        blocks.addAll(figure);
        checkFullRow();
    }

    public void makeFieldClean(){
        blocks.removeAll(blocks);
    }

    private void removeBlocksRow(int y) {

        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getY() == y) {
                iterator.remove();
            }
        }
    }

    private void moveRowsDown(int y) {
        for (Block block : blocks) {
            if (block.getY() < y) {
                block.setY(block.getY() + 1);
            }
        }
    }

    private int countBlocksInRow(int y) {
        int blocksInRow = 0;
        for (Block block : blocks) {
            if (block.getY() == y) {
                blocksInRow++;
            }
        }
        return blocksInRow;
    }

    private void checkFullRow() {
        int removedRows = 0;
        for (int i = 0; i < Field.FIELD_Y; i++) {
            if (countBlocksInRow(i) == Field.FIELD_X) {
                removeBlocksRow(i);
                removedRows++;
                moveRowsDown(i);
            }
        }
        HighScore.incrementHighScore(removedRows);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(e -> e.update(HighScore.getHighScore()));
    }
}
