package main.java.figure;

import java.util.ArrayList;

public class FigureO extends Figure{
    public FigureO() {
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_O));
        blocks.add(new Block(1, 0, Figure.FIGURE_O));
        blocks.add(new Block(0, -1, Figure.FIGURE_O));
        blocks.add(new Block(1, -1, Figure.FIGURE_O));
        typeOfFigure = FIGURE_O;
    }

    @Override
    public void rotateRight() {

    }
    @Override
    public void rotateLeft() {

    }
}
