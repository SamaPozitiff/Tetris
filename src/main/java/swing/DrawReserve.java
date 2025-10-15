package swing;

import figure.Figure;
import manager.HighScore;
import manager.Observable;
import manager.Observer;

import javax.swing.*;
import java.awt.*;

public class DrawReserve extends JPanel implements Observer {

    DrawFigure drawFigure;
    public DrawReserve(Observable observable){
        observable.addObserver(this);

    }



    @Override
    public void update (Object obj) {

        if(obj == null){
            removeAll();
            repaint();
            return;
        }

        int typeOfFigure = ((Figure)obj).getTypeOfFigure();
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0,0,0,0));
    }


}
