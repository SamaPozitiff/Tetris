package main.java.manager;

public interface ObservableFigure {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
