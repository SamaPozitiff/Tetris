package main.java.swing;

import main.java.manager.HighScore;
import main.java.manager.Observable;
import main.java.manager.Observer;

import javax.swing.*;
import java.awt.*;

public class DrawHighScore extends JPanel implements Observer {
    JLabel jLabel;
    DrawHighScore(Observable observable){
        observable.addObserver(this);
        this.add(jLabel = new JLabel("High Score: 0" ));
        jLabel.setBackground(new Color(0,0,0,0));
    }

    @Override
    public void update(Object obj) {
        jLabel.setText("High Score: " + obj);
        jLabel.validate();
        jLabel.repaint();
        getParent().repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0,0,0,0));

    }

}
