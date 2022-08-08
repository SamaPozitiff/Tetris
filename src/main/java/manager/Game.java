package main.java.manager;

import java.util.ArrayList;
import java.util.List;

import main.java.figure.Block;
import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.swing.Frame;
import main.java.swing.PaintComponent;


public class Game implements Observable {
    Field field;
    FigureManager figureManager;
    FigureControl figureControl;
    private List<Observer> observers;

    public Game() {
        observers = new ArrayList<>();
        field = new Field();
        figureManager = new FigureManager();
        figureControl = new FigureControl(field, figureManager);

    }

    public Observable getGameOverObservable(){
        return this;
    }

    public Observable getFigureObservable(){
        return figureControl;
    }

    public Observable getQueueObservable(){
        return figureManager;
    }

    public void startGame() {
        figureManager.resetQueue();
        field.makeFieldClean();
        figureControl.getFigureFromQueue();
        while (figureControl.isGameOver() == false) {
            makeGameStep();
            notifyObserver();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void makeGameStep() {
        figureControl.goDown();
        if (figureControl.isGameOver()) {
            notifyGameOver();
        }
    }

    public List<Block> getAllBlocks() {
        ArrayList<Block> allBlocks = new ArrayList<Block>();
        for (Block block : field.getBlocks()) {
            allBlocks.add(block);
        }
        for (int i = 0; i < Figure.SIZE; i++) {
            allBlocks.add(figureControl.getFigure().getBlock(i));
        }
        return allBlocks;
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyGameOver() {
        observers.stream()
                .filter(e -> e instanceof Frame)
                .forEach(e -> e.update(true));
    }

    @Override
    public void notifyObserver() {

        observers.stream()
                .filter(e -> e instanceof PaintComponent)
                .forEach(e -> e.update(getAllBlocks()));
    }
}

