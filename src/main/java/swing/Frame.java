package main.java.swing;


import main.java.manager.Controller;
import main.java.manager.Game;

import javax.swing.*;

public class Frame {
    static JFrame jFrame = new JFrame("Tetramino");
    static Game game;
    static PaintComponent paintGame;
    static Controller controller;

    public static void initialize() {
        game = new Game();
        paintGame = new PaintComponent();
        controller = new Controller(game,
                paintGame);
    }

    public static void buildGUI() {
        jFrame.setLayout(null);
        paintGame.setSize(1000, 1000);
        jFrame.add(paintGame);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1020, 1050);
        jFrame.addKeyListener(controller);
        jFrame.setVisible(true);
    }

    public static void startGame() {
        while (true) {
            game.makeGameStep();
            paintGame.paintBlocks(game.getAllBlocks());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        initialize();
        buildGUI();
        startGame();

    }

}
