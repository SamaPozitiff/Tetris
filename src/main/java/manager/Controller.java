package main.java.manager;

import main.java.swing.PaintComponent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    Game game;
    PaintComponent paintGame;


    public Controller(Game game, PaintComponent paintGame) {
        this.game = game;
        this.paintGame = paintGame;
    }

    public void keyTyped(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());
        if (key.equalsIgnoreCase("a") || key.equalsIgnoreCase("ф")) {
            game.moveLeft();

        }
        if (key.equalsIgnoreCase("d") || key.equalsIgnoreCase("в")) {
            game.moveRight();
        }
        paintGame.repaint();
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void keyReleased(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());
        if (key.equalsIgnoreCase("e") || key.equalsIgnoreCase("у")) {
            game.rotateFigureRight();
        }
        if (key.equalsIgnoreCase("q") || key.equalsIgnoreCase("й")) {
            game.rotateFigureLeft();
        }
        if (key.equalsIgnoreCase("w") || key.equalsIgnoreCase("ц")){
            game.dropFigureDown();
        }
        paintGame.repaint();
    }

}

