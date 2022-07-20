package main.java.figure;

import java.util.ArrayList;

public class Figure_O extends Figure{
    public Figure_O() {
        blocks = newFigureO();
    }

    public ArrayList<Block> newFigureO() {
        ArrayList<Block> figureO = new ArrayList<Block>();
        int image = (int)(Math.random() * 4);

        figureO.add(new Block(0, 0, Figure.FIGURE_O));
        figureO.add(new Block(1, 0, Figure.FIGURE_O));
        figureO.add(new Block(0, -1, Figure.FIGURE_O));
        figureO.add(new Block(1, -1, Figure.FIGURE_O));
        return figureO;
    }

    public void rotateRight() {

    }

    public void rotateLeft() {

    }
}
