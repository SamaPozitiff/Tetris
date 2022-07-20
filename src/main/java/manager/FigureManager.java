package main.java.manager;

import java.util.LinkedList;
import java.util.Queue;

import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.figure.GenerateFigure;

public class FigureManager implements IFigureManager{
    Queue<Figure> queue;
    Figure currentFigure;
    GenerateFigure generate;

    public FigureManager() {
        queue = new LinkedList<Figure>();
        generate = new GenerateFigure();
        addFigureAtQueue();
    }

    public void addFigureAtQueue() {
        queue.add(generate.createRandomFigure());
    }


    @Override
    public Figure getNextFigure() {
        addFigureAtQueue();
        return queue.poll();
    }
}

