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
    public static final Image FIGURE_L = new ImageIcon("src/main/resources/FigureL.png").getImage();
    public static final Image FIGURE_J = new ImageIcon("src/main/resources/FigureJ.png").getImage();
    public static final Image FIGURE_I = new ImageIcon("src/main/resources/FigureI.png").getImage();
    public static final Image FIGURE_O = new ImageIcon("src/main/resources/FigureO.png").getImage();
    public static final Image FIGURE_T = new ImageIcon("src/main/resources/FigureT.png").getImage();
    public static final Image FIGURE_S = new ImageIcon("src/main/resources/FigureS.png").getImage();
    public static final Image FIGURE_Z = new ImageIcon("src/main/resources/FigureZ.png").getImage();



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
                drawImage.drawImage(FIGURE_I);
                this.add(drawImage);

            } else if (typeOfFigure == Figure.FIGURE_L) {

                drawImage.drawImage(FIGURE_L);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_J) {
                drawImage.drawImage(FIGURE_J);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_O) {
                drawImage.drawImage(FIGURE_O);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_S) {
                drawImage.drawImage(FIGURE_S);
                this.add(drawImage);
            } else if (typeOfFigure == Figure.FIGURE_Z) {
                drawImage.drawImage(FIGURE_Z);
                this.add(drawImage);
            } else {
                drawImage.drawImage(FIGURE_T);
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


