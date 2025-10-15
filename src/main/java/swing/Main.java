package swing;

import manager.Controller;
import manager.Game;

public class Main {

    static Controller controller;
    static Game game;


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
