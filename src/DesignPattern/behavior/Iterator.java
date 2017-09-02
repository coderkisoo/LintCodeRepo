package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */

/***
 * 迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，
 * 理解本模式会十分轻松。这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对
 * 象，用于对聚集对象进行遍历访问。我们看下关系图：
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

    char[] strs = new char[]{'a','b','c','d','e'};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public int size() {
        return strs.length;
    }

    @Override
    public Object get(int i) {
        return strs[i];
    }
}

class MyIterator implements Iterator{

    Collection collection;
    int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
        if (this.collection.size()>0)
            pos = 0;
    }

    @Override
    public Object prev() {
        if (pos>=0)
            return collection.get(pos);
        return null;
    }

    @Override
    public Object next() {
        if (hasNext())
            return collection.get(++pos);
        return null;
    }

    @Override
    public boolean hasNext() {
        return collection.size()-1>pos;
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}