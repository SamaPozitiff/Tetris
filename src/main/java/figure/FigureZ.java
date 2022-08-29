package figure;

import java.util.ArrayList;

public class FigureZ extends Figure{

    public FigureZ(){
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_Z));
        blocks.add(new Block(0, -1, Figure.FIGURE_Z));
        blocks.add(new Block(-1, 0, Figure.FIGURE_Z));
        blocks.add(new Block(-1, 1, Figure.FIGURE_Z));
        typeOfFigure = FIGURE_Z;
    }

}
