package swing;

import manager.HighScore;
import manager.Observer;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    Image tree = new ImageIcon("src/main/resources/House.png").getImage();
    public LeftPanel(DrawReserve drawReserve, DrawHighScore drawHighScore){
        this.add(drawReserve);
        this.add(drawHighScore);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tree, 0, 0, this);
    }

}
