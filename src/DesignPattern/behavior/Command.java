package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */
/***
 * 命令模式的实现是为了将命令的发出者与接受者解耦，实现请求执行分隔
 */

interface Command{
    void exec();
}

class MyCommand implements Command{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exec() {

    }
}

class Receiver {
    public void receive(){}
}

class Invoker{
    Command command;
    Invoker(Command command){}

    void action(){
        command.exec();
    }
}

interface MainCommand{
    public static void main(String args){
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}