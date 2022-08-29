package swing;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import figure.Block;
import figure.Field;
import figure.Figure;
import manager.Observable;
import manager.Observer;

public class PaintComponent extends JPanel implements Observer {
    final int CELL = 50;
    ArrayList<Block> blocks;
    Image blockImage;
    Image backgroundImage = new ImageIcon("src/main/resources/Background.png").getImage();

    public PaintComponent(Observable observable){
        observable.addObserver(this);
        blocks = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        for(int k = 0; k < 1000;){
            for (int n = 0; n<1000;){
                g.drawImage(backgroundImage, k, n, 500,500, this);
                n+=500;
            }
        k+=500;
        }
        g.setColor(Color.gray);
        for (int i = 0; i < Field.FIELD_X; i++) {
            for (int j = 0; j < Field.FIELD_Y; j ++) {
                g.drawRect(i * CELL, j * CELL, CELL, CELL);
            }
        }
        for(Block block:blocks) {

            int x = block.getX() * CELL;
            int y = block.getY() * CELL;
            if (block.getImage() == Figure.FIGURE_L){
                blockImage = new ImageIcon("src/main/resources/BlockL.png").getImage();
            }else if(block.getImage() == Figure.FIGURE_J){
                blockImage = new ImageIcon("src/main/resources/BlockJ.png").getImage();
            } else if (block.getImage() == Figure.FIGURE_I){
                blockImage = new ImageIcon("src/main/resources/BlockI.png").getImage();
            } else if (block.getImage() == Figure.FIGURE_S){
                blockImage = new ImageIcon("src/main/resources/BlockS.png").getImage();
            } else if (block.getImage() == Figure.FIGURE_Z){
                blockImage = new ImageIcon("src/main/resources/BlockZ.png").getImage();
            } else if (block.getImage() == Figure.FIGURE_O){
                blockImage = new ImageIcon("src/main/resources/BlockO.png").getImage();
            }
            else{
                blockImage = new ImageIcon("src/main/resources/BlockT.png").getImage();
            }
            g.drawImage(blockImage, x, y, CELL, CELL, this);
        }

    }

    @Override
    public void update (Object obj) {
        this.blocks = (ArrayList<Block>) obj;
        repaint();
    }
}

