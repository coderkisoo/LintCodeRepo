package DesignPattern.build;

/**
 * Created by shs1329 on 2017/9/1.
 */

/***
 * 抽象工厂模式
 */
public abstract class AbstractFactory {

    public interface Product{}

    abstract Product produce();

}

class FactoryA extends AbstractFactory{

    public static class ProductA implements Product{

    }

    @Override
    Product produce() {
        return new ProductA();
    }
}

class FactoryB extends AbstractFactory{

    public static class ProductB implements Product{

    }

    @Override
    Product produce() {
        return new ProductB();
    }
}
