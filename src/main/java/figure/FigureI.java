package main.java.figure;

import java.util.ArrayList;

public class FigureI extends Figure{

    public FigureI(){
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_I));
        blocks.add(new Block(0, -1, Figure.FIGURE_I));
        blocks.add(new Block(0, -2, Figure.FIGURE_I));
        blocks.add(new Block(0, -3, Figure.FIGURE_I));
        typeOfFigure = FIGURE_I;
    }

    public void rotateRight() {
        for (int i = 1; i < SIZE; i++) {
            int x = blocks.get(i).getY()* -1;
            int y = blocks.get(i).getX()* -1;

            blocks.get(i).setX(x);
            blocks.get(i).setY(y);
        }
    }

    public void rotateLeft() {
        for (int i = 1; i < SIZE; i++) {
            int x = blocks.get(i).getY();
            int y = blocks.get(i).getX();

            blocks.get(i).setX(x);
            blocks.get(i).setY(y);
        }
    }
}
