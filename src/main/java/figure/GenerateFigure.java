package main.java.figure;

public class GenerateFigure {

    public GenerateFigure() {

    }

    public Figure createFigure() {
        Figure newFigure;
        int i = (int) (Math.random() * Figure.MAX_VARIANTS_OF_FIGURE + 1);
        if (i == Figure.FIGURE_I) {
            newFigure = new Figure_I();
        } else if (i == Figure.FIGURE_L) {
            newFigure = new Figures_L_J_T(i);
        } else if (i == Figure.FIGURE_J) {
            newFigure = new Figures_L_J_T(i);
        } else if (i == Figure.FIGURE_O) {
            newFigure = new Figure_O();
        } else if (i == Figure.FIGURE_S) {
            newFigure = new Figures_S_Z(i);
        } else if (i == Figure.FIGURE_Z) {
            newFigure = new Figures_S_Z(i);
        } else {
            newFigure = new Figures_L_J_T(i);
        }
        newFigure.absolute = new Block(0, 0);
        newFigure.typeOfFigure = i;
        return newFigure;
    }


    public static Figure createParticularFigure(int typeOfFigure) {
        Figure newFigure;

        if (typeOfFigure == Figure.FIGURE_I) {
            newFigure = new Figure_I();
        } else if (typeOfFigure == Figure.FIGURE_L) {
            newFigure = new Figures_L_J_T(typeOfFigure);
        } else if (typeOfFigure == Figure.FIGURE_J) {
            newFigure = new Figures_L_J_T(typeOfFigure);
        } else if (typeOfFigure == Figure.FIGURE_O) {
            newFigure = new Figure_O();
        } else if (typeOfFigure == Figure.FIGURE_S) {
            newFigure = new Figures_S_Z(typeOfFigure);
        } else if (typeOfFigure == Figure.FIGURE_Z) {
            newFigure = new Figures_S_Z(typeOfFigure);
        } else {
            newFigure = new Figures_L_J_T(typeOfFigure);
        }
        newFigure.absolute = new Block(0, 0);
        newFigure.typeOfFigure = typeOfFigure;
        return newFigure;
    }


}

