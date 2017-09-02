package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/2.
 */

/***
 * 策略模式，不需要写太多的if else，将算法单独封装，可以单独替换，独立于客户产生变换
 */
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void caculate(){
        strategy.strategy();
    }

}

interface Strategy{
    void strategy();
}

class StategyA implements Strategy{

    @Override
    public void strategy() {
        System.out.println("strategyA");
    }
}

class StrategyB implements Strategy{

    @Override
    public void strategy() {
        System.out.println("strategyB");
    }
}
