package main.java.swing;

import main.java.figure.Figure;
import main.java.manager.IReserveListener;

import javax.swing.*;
import java.awt.*;

public class DrawReserve extends JPanel implements IReserveListener {
    private int typeOfFigure;
    DrawImage drawImage;




    @Override
    public void paintReserveFigure(Figure figure) {
        this.typeOfFigure = figure.getTypeOfFigure();
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Фигура в резерве:"));
        drawImage = new DrawImage();
        drawImage.setSize(this.getWidth(), this.getHeight());

        if(typeOfFigure == Figure.FIGURE_T){
            drawImage.drawImage(PaintQueue.FIGURE_T);
            this.add(drawImage);
        } else if (typeOfFigure == Figure.FIGURE_I) {
            drawImage.drawImage(PaintQueue.FIGURE_I);
            this.add(drawImage);
        } else if (typeOfFigure == Figure.FIGURE_O) {
            drawImage.drawImage(PaintQueue.FIGURE_O);
            this.add(drawImage);
        } else if (typeOfFigure == Figure.FIGURE_J) {
            drawImage.drawImage(PaintQueue.FIGURE_J);
            this.add(drawImage);
        } else if (typeOfFigure == Figure.FIGURE_Z){
            drawImage.drawImage(PaintQueue.FIGURE_Z);
            this.add(drawImage);
        } else if (typeOfFigure == Figure.FIGURE_S){
            drawImage.drawImage(PaintQueue.FIGURE_S);
            this.add(drawImage);
        } else{
            drawImage.drawImage(PaintQueue.FIGURE_L);
            this.add(drawImage);
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
