package main.java.swing;

import main.java.figure.Figure;

import javax.swing.*;
import java.awt.*;

public class DrawFigure extends JPanel {
    private Image figure;
    private final Image  figureL = new ImageIcon("src/main/resources/FigureL.png").getImage();
    private final Image figureJ = new ImageIcon("src/main/resources/FigureJ.png").getImage();
    private final Image figureI = new ImageIcon("src/main/resources/FigureI.png").getImage();
    private final Image figureO = new ImageIcon("src/main/resources/FigureO.png").getImage();
    private final Image figureT = new ImageIcon("src/main/resources/FigureT.png").getImage();
    private final Image figureS = new ImageIcon("src/main/resources/FigureS.png").getImage();
    private final Image figureZ = new ImageIcon("src/main/resources/FigureZ.png").getImage();


    public void drawImage(int typeOfFigure) {
        if (typeOfFigure == Figure.FIGURE_L) {
            figure = figureL;
        } else if (typeOfFigure == Figure.FIGURE_I) {
            figure = figureI;
        } else if (typeOfFigure == Figure.FIGURE_S) {
            figure = figureS;
        } else if (typeOfFigure == Figure.FIGURE_J) {
            figure = figureJ;
        } else if (typeOfFigure == Figure.FIGURE_O) {
            figure = figureO;
        } else if (typeOfFigure == Figure.FIGURE_Z) {
            figure = figureZ;
        } else {
            figure = figureT;
        }
        repaint();
    }

    public void paintComponent (Graphics g) {
        g.drawImage(figure, 25, 10, 200, 200, this);

    }

    }
