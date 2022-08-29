package figure;

import java.util.ArrayList;

public class FigureS extends Figure {


    public FigureS() {
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_S));
        blocks.add(new Block(0, 1, Figure.FIGURE_S));
        blocks.add(new Block(-1, 0, Figure.FIGURE_S));
        blocks.add(new Block(-1, -1, Figure.FIGURE_S));
        typeOfFigure = FIGURE_S;
    }
}
