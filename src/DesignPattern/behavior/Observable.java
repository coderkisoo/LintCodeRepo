package DesignPattern.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangqizhou on 2017/9/3.
 */

/***
 * 当一个对象改变时，观察者都会结收到通知
 */
interface Observer{
    void update();
}

interface Observable{
    void addObserver(Observer observer);
    void delObserver(Observer observer);
    void notifyObservers();
    void operation();
}

abstract class AbstreactObservable implements Observable{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers){
            observer.update();
        }
    }
}

class ObservableL extends AbstreactObservable{

    @Override
    public void operation() {
        System.out.println("operation");
        notifyObservers();
    }
}