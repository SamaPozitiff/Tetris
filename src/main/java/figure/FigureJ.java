package figure;

import java.util.ArrayList;

public class FigureJ extends Figure{
    public FigureJ(){
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, FIGURE_J));
        blocks.add(new Block(-1, 0, FIGURE_J));
        blocks.add(new Block(0, -1, FIGURE_J));
        blocks.add(new Block(0, -2, FIGURE_J));
        typeOfFigure = FIGURE_J;
    }
}
