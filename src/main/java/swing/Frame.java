package main.java.swing;


import main.java.manager.Controller;
import main.java.manager.Game;
import main.java.manager.Observer;

import javax.swing.*;
import java.awt.*;

public class Frame implements Observer {
    private final JFrame jFrame;
    Game game;
    private PaintComponent paintGame;
    private PaintQueue paintQueue;
    private DrawReserve drawReserve;
    private LeftPanel leftPanel;
    private DrawHighScore drawHighscore;


    public Frame(Game game){
        this.game = game;
        jFrame = new JFrame("Tetramino");
        game.getGameOverObservable().addObserver(this);
        initialize();
    }



    public void buildGUI() {



        jFrame.setSize(1100, 1050);
        jFrame.setLayout(new FlowLayout());
        paintGame.setPreferredSize(new Dimension(500,1000));
        paintQueue.setPreferredSize(new Dimension(250,1000));
        leftPanel.setPreferredSize(new Dimension(250,1000));
        drawReserve.setPreferredSize(new Dimension(250, 250));
        drawHighscore.setPreferredSize(new Dimension(250, 250));
        jFrame.getContentPane().add(leftPanel);
        jFrame.getContentPane().add(paintGame);
        jFrame.getContentPane().add(paintQueue);

       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.setVisible(true);
    }

    public void addController(Controller controller){
        jFrame.addKeyListener(controller);
    }

    private void initialize(){
        paintGame = new PaintComponent(game.getGameOverObservable());
        paintQueue = new PaintQueue(game.getQueueObservable());
        drawReserve = new DrawReserve(game.getFigureObservable());
        drawHighscore = new DrawHighScore(game.getFieldObservable());
        leftPanel = new LeftPanel(drawReserve, drawHighscore);
    }

    public void showGameOver(){
        int result = JOptionPane.showConfirmDialog(jFrame, "GAME OVER" + "\n" + "Начать сначала?", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION){
            initialize();
            buildGUI();
            game.startGame();

        }
    }

    public void repaint(){
        jFrame.repaint();
    }


    @Override
    public void update(Object obj) {
        showGameOver();
    }
}
