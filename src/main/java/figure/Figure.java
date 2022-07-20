package main.java.figure;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
    protected ArrayList<Block> blocks;
    private int absoluteX;
    private int absoluteY;
    protected int typeOfFigure = 0;
    public static final int SIZE = 4;
    public static final int FIGURE_L = 1;
    public static final int FIGURE_J = 2;
    public static final int FIGURE_I = 3;
    public static final int FIGURE_S = 4;
    public static final int FIGURE_Z = 5;
    public static final int FIGURE_O = 6;
    public static final int FIGURE_T = 7;
    public static final int MAX_VARIANTS_OF_FIGURE = 7;

    Figure(){
       absoluteX = 0;
       absoluteY = 0;
    }



    public Block getBlock(int index) {
        Block block = blocks.get(index);
        Block absBlock = new Block(absoluteX + block.getX(), absoluteY + block.getY(), block.getImage());
        return absBlock;
    }

    public List<Block> getAllBlocks(){
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < Figure.SIZE; i++){
            blocks.add(getBlock(i));
        }
        return blocks;
    }

    public void setAbcoluteY(int y) {
        absoluteY = y;
    }

    public void setAbsoluteX(int x) {
        absoluteX = x;
    }

    public void goDown() {
        absoluteY++;
    }

    public void goLeft() {
        absoluteX--;
    }

    public void goRight() {
        absoluteX++;
    }

    public void rotateRight() {
        for (int i = 1; i < SIZE; i++) {
            int x = blocks.get(i).getY() * -1;
            int y = blocks.get(i).getX();

            blocks.get(i).setX(x);
            blocks.get(i).setY(y);
        }
    }

    public void rotateLeft() {
        for (int i = 1; i < SIZE; i++) {
            int x = blocks.get(i).getY();
            int y = blocks.get(i).getX() * -1;

            blocks.get(i).setX(x);
            blocks.get(i).setY(y);
        }
    }

    public Figure cloneFigure(Figure figure) {
        Figure newFigure = GenerateFigure.createParticularFigure(figure.typeOfFigure);
        for (int i = 0; i < SIZE; i++) {
            newFigure.getBlock(i).setX(figure.getBlock(i).getX());
            newFigure.getBlock(i).setY(figure.getBlock(i).getY());
        }
        newFigure.setAbsoluteX(figure.absoluteX);
        newFigure.setAbcoluteY(figure.absoluteY);
        return newFigure;
    }
}
