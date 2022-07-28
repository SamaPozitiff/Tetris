package main.java.swing;

import main.java.figure.Figure;
import main.java.manager.IReserveListener;

import javax.swing.*;
import java.awt.*;

public class DrawReserve extends JPanel implements IReserveListener {
    private int typeOfFigure;
    DrawFigure drawFigure;




    @Override
    public void paintReserveFigure(Figure figure) {
        this.typeOfFigure = figure.getTypeOfFigure();
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Фигура в резерве:"));
        drawFigure = new DrawFigure();
        drawFigure.setSize(this.getWidth(), this.getHeight());
            drawFigure.drawImage(typeOfFigure);
            this.add(drawFigure);
        validate();
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,200,1000);
    }

}
