package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */
/**
 * 自我感觉，状态模式和策略模式是极为接近的两个模式，区别就是策略模式更趋向策略，状态模式更趋向状态的修改
 * */

interface State{

}

class Client{

    State state;

    void setState(State state){
        this.state = state;
    }
}

class State1 implements State{}

class State2 implements State{}

interface Main{
    public static void main(String[] args){
        Client client = new Client();
        client.setState(new State1());
        client.setState(new State2());
    }
}
