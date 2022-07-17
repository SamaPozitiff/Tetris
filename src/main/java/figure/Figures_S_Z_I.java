package main.java.figure;

import java.util.ArrayList;

public class Figures_S_Z_I extends Figure {
    public static final int STATE_HORIZONTAL = 0;
    public static final int STATE_VERTICAL = 1;


    public Figures_S_Z_I(int i) {
        if (i == FIGURE_I) {
            blocks = newFigureI();
        }
        if (i == FIGURE_S) {
            blocks = newFigureS();
        }
        if (i == FIGURE_Z) {
            blocks = newFigureZ();
        }
    }

    public ArrayList<Block> newFigureS() {
        ArrayList<Block> figureS = new ArrayList<Block>();

        figureS.add(new Block(0, 0));
        figureS.add(new Block(0, 1));
        figureS.add(new Block(-1, 0));
        figureS.add(new Block(-1, -1));
        return figureS;
    }

    public ArrayList<Block> newFigureZ() {
        ArrayList<Block> figureZ = new ArrayList<Block>();

        figureZ.add(new Block(0, 0));
        figureZ.add(new Block(0, -1));
        figureZ.add(new Block(-1, 0));
        figureZ.add(new Block(1, -1));
        return figureZ;
    }

    public ArrayList<Block> newFigureI() {
        ArrayList<Block> figureI = new ArrayList<Block>();

        figureI.add(new Block(0, 0));
        figureI.add(new Block(0, -1));
        figureI.add(new Block(0, -2));
        figureI.add(new Block(0, -3));
        return figureI;
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
}
