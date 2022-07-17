package figure;

import java.util.ArrayList;

public class Figures_L_J_T extends Figure{

    public Figures_L_J_T(int i) {
        if (i == FIGURE_J) {
            blocks = newFigureJ();
        }
        if (i == FIGURE_L) {
            blocks = newFigureL();
        }
        if (i == FIGURE_T) {
            blocks = newFigureT();
        }
    }

    public ArrayList<Block> newFigureJ() {
        ArrayList<Block> figureJ = new ArrayList<Block>();

        figureJ.add(new Block(0, 0));
        figureJ.add(new Block(-1, 0));
        figureJ.add(new Block(0, -1));
        figureJ.add(new Block(0, -2));
        return figureJ;
    }

    public ArrayList<Block> newFigureL() {
        ArrayList<Block> figureL = new ArrayList<Block>();

        figureL.add(new Block(0, 0));
        figureL.add(new Block(1, 0));
        figureL.add(new Block(0, -1));
        figureL.add(new Block(0, -2));
        return figureL;
    }

    public ArrayList<Block> newFigureT() {
        ArrayList<Block> figureT = new ArrayList<Block>();

        figureT.add(new Block(0, 0));
        figureT.add(new Block(1, 0));
        figureT.add(new Block(0, 1));
        figureT.add(new Block(0, -1));
        return figureT;
    }
}

