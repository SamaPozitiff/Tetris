package main.java.swing;

import javax.swing.JPanel;
import java.awt.*;

public class DrawImage extends JPanel {
    Image figure;

    public void drawImage(Image figure) {
        this.figure = figure;
        repaint();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,200, 200);
        g.drawImage(figure, 0, 0, 200, 200, this);

    }
}
