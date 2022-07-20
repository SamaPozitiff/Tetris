package main.java.figure;

import java.util.ArrayList;

public class FigureT extends Figure{

    public FigureT() {
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_T));
        blocks.add(new Block(1, 0, Figure.FIGURE_T));
        blocks.add(new Block(0, 1, Figure.FIGURE_T));
        blocks.add(new Block(0, -1, Figure.FIGURE_T));
        typeOfFigure = FIGURE_T;
    }

}

