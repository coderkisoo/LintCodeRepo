package DesignPattern.struct;


/**
 * Created by shs1329 on 2017/9/1.
 */


public class SpecificAdapter {


    public void method2() {
        System.out.println("特殊功能");
    }

    public static void main(String[] args){
        Target target = new ConcreteTarget();
        target.method1();

        target = new ClassAdapter();
        target.method1();

        target = new ObjectAdapter(new SpecificAdapter());
        target.method1();
    }
}

/***
 *  这种实现的适配器称为类适配器，因为 Adapter 类既继承了 Adaptee （被适配类），也实现了 Target 接口（因为 Java 不支持多继承，
 *  所以这样来实现），在 Client 类中我们可以根据需要选择并创建任一种符合需求的子类，来实现具体功能。
 */
class ClassAdapter extends SpecificAdapter implements Target{

    @Override
    public void method1() {
        super.method2();
    }
}

/***
 * 一种适配器模式是对象适配器，它不是使用多继承或继承再实现的方式，而是使用直接关联，或者称为委托的方式
 */
class ObjectAdapter implements Target{

    private SpecificAdapter specificAdapter;

    public ObjectAdapter(SpecificAdapter adapter){
        this.specificAdapter = adapter;
    }

    @Override
    public void method1() {
        this.specificAdapter.method2();
    }
}

class ConcreteTarget implements Target{

    @Override
    public void method1() {
        System.out.println("普通功能");

    }
}

interface Target{
    void method1();
}
