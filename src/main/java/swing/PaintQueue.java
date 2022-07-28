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
    DrawFigure drawFigure;



    @Override
    public void paintQueue(List<Figure> queue) {
        this.queue = new ArrayList<Figure>();
        this.queue.addAll(queue);
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Очередь:"));
        for(int i = 1; i < queue.size(); i++) {
            drawFigure = new DrawFigure();
            drawFigure.setSize(this.getWidth(), this.getHeight());
            typeOfFigure = queue.get(i).getTypeOfFigure();
                drawFigure.drawImage(typeOfFigure);
                this.add(drawFigure);
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


