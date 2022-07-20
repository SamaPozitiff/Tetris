package main.java.figure;

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
        figureJ.add(new Block(0, 0, FIGURE_J));
        figureJ.add(new Block(-1, 0, FIGURE_J));
        figureJ.add(new Block(0, -1, FIGURE_J));
        figureJ.add(new Block(0, -2, FIGURE_J));
        return figureJ;
    }

    public ArrayList<Block> newFigureL() {
        ArrayList<Block> figureL = new ArrayList<Block>();
        figureL.add(new Block(0, 0, Figure.FIGURE_L));
        figureL.add(new Block(1, 0, Figure.FIGURE_L));
        figureL.add(new Block(0, -1, Figure.FIGURE_L));
        figureL.add(new Block(0, -2, Figure.FIGURE_L));
        return figureL;
    }

    public ArrayList<Block> newFigureT() {
        ArrayList<Block> figureT = new ArrayList<Block>();
        figureT.add(new Block(0, 0, Figure.FIGURE_T));
        figureT.add(new Block(1, 0, Figure.FIGURE_T));
        figureT.add(new Block(0, 1, Figure.FIGURE_T));
        figureT.add(new Block(0, -1, Figure.FIGURE_T));
        return figureT;
    }
}

