package swing;

import figure.Figure;
import manager.Observable;
import manager.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintQueue extends JPanel implements Observer {
    int typeOfFigure;
    ArrayList<Figure> queue;
    DrawFigure drawFigure;
    Image tree = new ImageIcon("src/main/resources/House.png").getImage();

    public PaintQueue(Observable observable){
        observable.addObserver(this);
    }

//TODO Слушатель FigureControl

    @Override
    public void update (Object obj) {
        this.queue = new ArrayList<Figure>();
        this.queue.addAll((List<Figure>)obj);
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
        g.drawImage(tree, 0, 0, this);
    }
}


