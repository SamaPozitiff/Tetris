package main.java.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.figure.Field;
import main.java.figure.Figure;
import main.java.figure.GenerateFigure;

public class FigureManager implements IFigureManager{
    List<Figure> queue;
    GenerateFigure generate;
    IQueueListener queueListener;

    public FigureManager(IQueueListener queueListener) {
        queue = new LinkedList<Figure>();
        generate = new GenerateFigure();
        this.queueListener = queueListener;
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
        queueListener.paintQueue(queue);
        return poll();
    }

    public Figure poll(){
        Figure firstFigure = queue.get(0);
        queue.remove(0);
        return firstFigure;
    }
}

