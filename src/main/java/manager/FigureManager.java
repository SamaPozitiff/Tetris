package manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import figure.Field;
import figure.Figure;
import figure.GenerateFigure;

public class FigureManager implements Observable, IFigureManager{
    private List<Figure> queue;
    private GenerateFigure generate;
    private List<Observer> observers;

    public FigureManager() {
        observers = new ArrayList<>();

        generate = new GenerateFigure();
        resetQueue();


    }

    public void resetQueue(){
        queue = new LinkedList<>();
        addFigureAtQueue();
        addFigureAtQueue();
        addFigureAtQueue();
        addFigureAtQueue();
    }

    public void addFigureAtQueue() {
        queue.add(generate.createRandomFigure());
    }


    @Override
    public Figure getNextFigure() {
        addFigureAtQueue();
        notifyObserver();
        return poll();
    }

    public Figure poll(){
        Figure firstFigure = queue.get(0);
        queue.remove(0);
        return firstFigure;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(e -> e.update(queue));
    }
}

