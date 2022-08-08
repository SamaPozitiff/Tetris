package main.java.manager;

public interface Observable {
     void addObserver(Observer observer);
     void deleteObserver(Observer observer);
     void notifyObserver();
}
