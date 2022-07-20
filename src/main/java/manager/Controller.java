package main.java.manager;

import main.java.swing.PaintComponent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    Game game;
    PaintComponent paintGame;
    FigureControl figureControl;


    public Controller(Game game, PaintComponent paintGame) {
        this.game = game;
        this.paintGame = paintGame;
        figureControl = game.figureControl;
    }

    public void keyTyped(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());
        if (key.equalsIgnoreCase("a") || key.equalsIgnoreCase("ф")) {
            figureControl.goLeft();

        }
        if (key.equalsIgnoreCase("d") || key.equalsIgnoreCase("в")) {
            figureControl.goRight();
        }
        paintGame.repaint();
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void keyReleased(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());
        if (key.equalsIgnoreCase("e") || key.equalsIgnoreCase("у")) {
            figureControl.rotateRight();
        }
        if (key.equalsIgnoreCase("q") || key.equalsIgnoreCase("й")) {
            figureControl.rotateLeft();
        }
        if (key.equalsIgnoreCase("w") || key.equalsIgnoreCase("ц")){
            figureControl.dropDown();
        }
        paintGame.repaint();
    }

}

