package swing;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import figure.Block;
import figure.Field;

public class PaintComponent extends JPanel {
    final int CELL = 50;
    ArrayList<Block> blocks;



    public void paintBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
        repaint();
    }


    public void paintComponent(Graphics g) {

        Image blockImage = new ImageIcon("src/main/resources/Block.png").getImage();
        g.setColor(getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.gray);
        for (int i = 0; i < Field.FIELD_X; i++) {
            for (int j = 0; j < Field.FIELD_Y; j ++) {
                g.drawRect(i * CELL, j * CELL, CELL, CELL);
            }
        }
        for(Block block:blocks) {
            int x = block.getX() * CELL;
            int y = block.getY() * CELL;
            g.drawImage(blockImage, x, y, CELL, CELL, this);
        }

    }

}

