package DesignPattern.struct;

/**
 * Created by kangqizhou on 2017/9/2.
 */

/***
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：
 * 将抽象化与实现化解耦，使得二者可以独立变化
 */
public class BridgeImpl implements Bridge{

    @Override
    public void bridgeMethod() {

    }

    public static void main(String args){
        Bridge impl = new BridgeImpl();
        BrigeGlobal global = new MyBridge();
        global.setBridge(impl);
        global.method();
    }
}

class MyBridge extends BrigeGlobal{
    public void method(){
        getBridge().bridgeMethod();
    }
}

abstract class BrigeGlobal {

    Bridge bridge;

    public void method(){
        bridge.bridgeMethod();
    }

    public void setBridge(Bridge bridge){
        this.bridge = bridge;
    }

    public Bridge getBridge(){
        return this.bridge;
    }

}

interface Bridge{
    void bridgeMethod();
}
