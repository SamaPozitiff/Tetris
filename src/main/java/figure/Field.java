package figure;

import java.util.ArrayList;
import java.util.Iterator;

public class Field {
    ArrayList<Block> blocks;
    public static final int FIELD_Y = 20;
    public static final int FIELD_X = 20;

    public Field() {
        blocks = new ArrayList<Block>();
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public boolean isNextDownBlockEmpty(int x, int y) {
        for (Block blockInArray : blocks) {
            if (blockInArray.getX() == x && blockInArray.getY() == y + 1) {
                return false;
            }
        }
        return true;
    }

    public void addFigureToField(Figure figure) {
        for (int i = 0; i < Figure.SIZE; i++) {
            blocks.add(figure.getBlock(i));
        }
        checkFullRow();
    }

    public boolean isNextLeftBlockEmpty(int x, int y) {
        for (Block blockInArray : blocks) {
            if (blockInArray.getX() == x - 1 && blockInArray.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public boolean isNextRightBlockEmpty(int x, int y) {
        for (Block blockInArray : blocks) {
            if (blockInArray.getX() == x + 1 && blockInArray.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public void removeBlocksRow(int y) {

        Iterator<Block> iterator = blocks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getY() == y) {
                iterator.remove();
            }
        }

//		for(Block block: blocks) {
//			if (block.getY() == y) {
//				blocks.remove(block);
//			}
//		}
    }

    public void moveRowsDown(int y) {
        for (Block block : blocks) {
            if (block.getY() < y) {
                block.setY(block.getY() + 1);
            }
        }
    }

    public int countBlocksInRow(int y) {
        int blocksInRow = 0;
        for (Block block : blocks) {
            if (block.getY() == y) {
                blocksInRow++;
            }
        }
        return blocksInRow;
    }

    public void checkFullRow() {
        for (int i = 0; i < Field.FIELD_Y; i++) {
            if (countBlocksInRow(i) == Field.FIELD_X) {
                removeBlocksRow(i);
                moveRowsDown(i);
            }
        }
    }

    public boolean IsBlockEmpty(int x, int y) {
        for (Block block : blocks) {
            if (block.getX() == x && block.getY() == y) {
                return false;
            }
        }
        return true;
    }
}
