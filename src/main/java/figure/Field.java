package main.java.figure;

import main.java.manager.IField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Field implements IField {
    ArrayList<Block> blocks;
    public static final int FIELD_Y = 20;
    public static final int FIELD_X = 20;

    public Field() {
        blocks = new ArrayList<Block>();
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
        for (int i = 0; i < Field.FIELD_Y; i++) {
            if (countBlocksInRow(i) == Field.FIELD_X) {
                removeBlocksRow(i);
                moveRowsDown(i);
            }
        }
    }
}
