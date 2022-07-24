package main.java.swing;

import main.java.figure.Figure;
import main.java.manager.IQueueListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintQueue extends JPanel implements IQueueListener {
    int typeOfFigure;
    ArrayList<Figure> queue;
    DrawImage drawImage;
    Image figureL = new ImageIcon("src/main/resources/FigureL.png").getImage();
    Image figureJ = new ImageIcon("src/main/resources/FigureJ.png").getImage();
    Image figureI = new ImageIcon("src/main/resources/FigureI.png").getImage();
    Image figureO = new ImageIcon("src/main/resources/FigureO.png").getImage();
    Image figureT = new ImageIcon("src/main/resources/FigureT.png").getImage();
    Image figureS = new ImageIcon("src/main/resources/FigureS.png").getImage();
    Image figureZ = new ImageIcon("src/main/resources/FigureZ.png").getImage();



    @Override
    public void paintQueue(List<Figure> queue) {
        this.queue = new ArrayList<Figure>();
        this.queue.addAll(queue);
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Очередь:"));


        for(int i = 1; i < queue.size(); i++) {
            drawImage = new DrawImage();
            drawImage.setSize(this.getWidth(), this.getHeight());
            typeOfFigure = queue.get(i).getTypeOfFigure();
            if (typeOfFigure == Figure.FIGURE_I) {
                drawImage.drawImage(figureI);
                this.add(drawImage);

            } else if (typeOfFigure == Figure.FIGURE_L) {

                drawImage.drawImage(figureL);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_J) {
                drawImage.drawImage(figureJ);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_O) {
                drawImage.drawImage(figureO);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_S) {
                drawImage.drawImage(figureS);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_Z) {
                drawImage.drawImage(figureZ);
                this.add(drawImage);
            } else {
                drawImage.drawImage(figureT);
                this.add(drawImage);
            }
        }
        validate();
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,200,1000);
    }
}


