package main.java.manager;

import main.java.swing.Frame;
import main.java.swing.PaintComponent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    Game game;
    Frame paintGame;
    FigureControl figureControl;


    public Controller(Game game, Frame paintGame) {
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
        if (key.equalsIgnoreCase("s")||key.equalsIgnoreCase("ы")){
            figureControl.goDown();
        }
        paintGame.repaint();
    }

    public void keyPressed(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar());


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
        if(key.equalsIgnoreCase(" ")){
            figureControl.reserveFigure();
        }
        paintGame.repaint();
    }

}

