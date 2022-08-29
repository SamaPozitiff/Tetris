package figure;

import java.util.ArrayList;

public class FigureL extends Figure{
    public FigureL(){
        super();
        blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, Figure.FIGURE_L));
        blocks.add(new Block(1, 0, Figure.FIGURE_L));
        blocks.add(new Block(0, -1, Figure.FIGURE_L));
        blocks.add(new Block(0, -2, Figure.FIGURE_L));
        typeOfFigure = FIGURE_L;
    }
}
