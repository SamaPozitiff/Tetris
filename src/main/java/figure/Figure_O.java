package main.java.figure;

import java.util.ArrayList;

public class Figure_O extends Figure{
    public Figure_O() {
        blocks = newFigureO();
    }

    public ArrayList<Block> newFigureO() {
        ArrayList<Block> figureO = new ArrayList<Block>();

        figureO.add(new Block(0, 0));
        figureO.add(new Block(1, 0));
        figureO.add(new Block(0, -1));
        figureO.add(new Block(1, -1));
        return figureO;
    }

    public void rotateRight() {

    }

    public void rotateLeft() {

    }
}
