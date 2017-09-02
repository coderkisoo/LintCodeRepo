package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */
interface Collection{
    Iterator iterator();
    int size();
    Object get(int i);
}

interface Iterator{
    Object prev();
    Object next();
    boolean hasNext();
    Object first();
}

class MyCollection implements Collection{

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int i) {
        return null;
    }
}

