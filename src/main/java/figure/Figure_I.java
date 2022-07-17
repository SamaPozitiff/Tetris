package main.java.figure;

import java.util.ArrayList;

public class Figure_I extends Figure{

    public Figure_I(){
        blocks = newFigureI();
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
            int x = blocks.get(i).getY();
            int y = blocks.get(i).getX();

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
