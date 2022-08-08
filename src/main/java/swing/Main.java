package main.java.swing;

import main.java.manager.Controller;
import main.java.manager.Game;

public class Main {
    static Game game;
    static Controller controller;
    static Frame frame;


    public static void initialize() {
        game = new Game();
        frame = new Frame(game);
        controller = new Controller(game, frame);
        frame.addController(controller);

    }

    public static void main(String[] args) {
        initialize();
        frame.buildGUI();
        game.startGame();

    }
}
