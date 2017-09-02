package DesignPattern.struct;

/**
 * Created by kangqizhou on 2017/9/2.
 */

/***
 * 而外观模式就是将他们的关系放在一个Facade类中，降
 * 低了类类之间的耦合度，该模式中没有涉及到接口
 */
public class Fade {
    private Component1 conponment1;
    private Component2 conponment2;
    private Component3 conponment3;

    public Fade(){
        conponment1 = new Component1();
        conponment2 = new Component2();
        conponment3 = new Component3();
    }

    public void compoment(){
        conponment1.conponment();
        conponment2.conponment();
        conponment3.conponment();
    }



}

class Component1{
    void conponment(){

    }
}
class Component2{
    void conponment(){

    }
}
class Component3{
    void conponment(){

    }
}
