package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */

/***
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通
 * 俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一
 * 些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。
 */
class Memento {
    int value;

    public Memento(int value) {
        this.value = value;
    }

    void setValue(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}

class Original {

    int value;

    public Memento createMemento() {
        return new Memento(value);
    }

    public Original(int value) {
        this.value = value;
    }

    public void restoreMemento(Memento memento) {
        this.value = memento.getValue();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class Storage {
    Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

interface MementoMain {
    public static void main(String[] args) {
        Original original = new Original(1);
        System.out.println("初始化状态为：" + original.getValue());
        Storage storage = new Storage(original.createMemento());
        System.out.println("备忘状态为：" + storage.memento.value);
        original.setValue(2);
        System.out.println("修改状态为：" + original.getValue());
        original.restoreMemento(storage.getMemento());
        System.out.println("重新装载状态为：" + original.getValue());
    }
}