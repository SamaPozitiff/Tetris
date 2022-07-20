package main.java.figure;

import java.util.ArrayList;

public class Figure {
    protected ArrayList<Block> blocks;
    Block absolute;
    public int typeOfFigure = 0;
    public static final int SIZE = 4;
    public static final int FIGURE_L = 1;
    public static final int FIGURE_J = 2;
    public static final int FIGURE_I = 3;
    public static final int FIGURE_S = 4;
    public static final int FIGURE_Z = 5;
    public static final int FIGURE_O = 6;
    public static final int FIGURE_T = 7;
    public static final int MAX_VARIANTS_OF_FIGURE = 7;


    public Figure() {
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0,0));
        blocks.add(new Block(0,0));
        blocks.add(new Block(0,0));
        blocks.add(new Block(0,0));
        absolute = new Block(0,0);
    }

    public Block getBlock(int index) {
        Block block = blocks.get(index);
        Block absBlock = new Block(absolute.getX() + block.getX(), absolute.getY() + block.getY(), block.getImage());
        return absBlock;
    }

    public int getTypeOfFigure(){
        return typeOfFigure;
    }

    public void setAbcoluteY(int y) {
        absolute.setY(y);
    }

    public void setAbsoluteX(int x) {
        absolute.setX(x);
    }

    public void goDown() {
        absolute.setY(absolute.getY() + 1);
    }

    public void goLeft() {
        absolute.setX(absolute.getX() - 1);
    }

    public void goRight() {
        absolute.setX(absolute.getX() + 1);
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
        newFigure.setAbsoluteX(figure.absolute.getX());
        newFigure.setAbcoluteY(figure.absolute.getY());
        return newFigure;
    }
}
