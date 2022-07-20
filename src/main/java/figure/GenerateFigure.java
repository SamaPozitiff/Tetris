package main.java.figure;

public class GenerateFigure {


    public Figure createRandomFigure() {
        Figure newFigure;
        int i = (int) (Math.random() * Figure.MAX_VARIANTS_OF_FIGURE + 1);
        if (i == Figure.FIGURE_I) {
            newFigure = new FigureI();
        } else if (i == Figure.FIGURE_L) {
            newFigure = new FigureL();
        } else if (i == Figure.FIGURE_J) {
            newFigure = new FigureJ();
        } else if (i == Figure.FIGURE_O) {
            newFigure = new FigureO();
        } else if (i == Figure.FIGURE_S) {
            newFigure = new FigureS();
        } else if (i == Figure.FIGURE_Z) {
            newFigure = new FigureZ();
        } else {
            newFigure = new FigureT();
        }
        return newFigure;
    }


    public static Figure createParticularFigure(int typeOfFigure) {
        Figure newFigure;
        if (typeOfFigure == Figure.FIGURE_I) {
            newFigure = new FigureI();
        } else if (typeOfFigure == Figure.FIGURE_L) {
            newFigure = new FigureL();
        } else if (typeOfFigure == Figure.FIGURE_J) {
            newFigure = new FigureJ();
        } else if (typeOfFigure == Figure.FIGURE_O) {
            newFigure = new FigureO();
        } else if (typeOfFigure == Figure.FIGURE_S) {
            newFigure = new FigureS();
        } else if (typeOfFigure == Figure.FIGURE_Z) {
            newFigure = new FigureZ();
        } else {
            newFigure = new FigureT();
        }
        return newFigure;
    }


}

