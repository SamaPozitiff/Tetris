package main.java.swing;


import main.java.manager.Controller;
import main.java.manager.Game;

import javax.swing.*;
import java.awt.*;

public class Frame {
    static JFrame jFrame = new JFrame("Tetramino");
    static Game game;
    static PaintComponent paintGame;
    static Controller controller;
    static PaintQueue paintQueue;
    static DrawReserve drawReserve;

    public static void initialize() {
        paintGame = new PaintComponent();
        paintQueue = new PaintQueue();
        drawReserve = new DrawReserve();
        game = new Game(paintQueue, paintGame, drawReserve);
        controller = new Controller(game,
                paintGame);
    }

    public static void buildGUI() {
        jFrame.setSize(1500, 1050);
        jFrame.setLayout(new FlowLayout());
        paintGame.setPreferredSize(new Dimension(1000,1000));
        paintQueue.setPreferredSize(new Dimension(200,1000));
        drawReserve.setPreferredSize(new Dimension(200,1000));
        jFrame.getContentPane().add(drawReserve);
        jFrame.getContentPane().add(paintGame);
        jFrame.getContentPane().add(paintQueue);

       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.addKeyListener(controller);
       jFrame.setVisible(true);
    }



    public static void main(String[] args) {
        initialize();
        buildGUI();
        game.startGame();
    }

}
