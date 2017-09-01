package DesignPattern;

/**
 * Created by shs1329 on 2017/9/1.
 */

/***
 * 工厂模式
 */
public abstract class SimpleFactory {
    public Product produce(int type){
        switch (type){
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();
        }
        return null;
    }
}

class ProductA implements Product{

}

class ProductB implements Product{

}

interface Product{

}