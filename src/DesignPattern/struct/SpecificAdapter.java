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

        target = new Adapter();
        target.method1();
    }
}

class Adapter extends SpecificAdapter implements Target{

    @Override
    public void method1() {
        super.method2();
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
