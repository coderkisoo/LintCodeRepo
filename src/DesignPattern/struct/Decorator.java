package DesignPattern.struct;

/**
 * Created by shs1329 on 2017/9/1.
 */

/***
 * 装饰模式
 */
public class Decorator implements DecoratorInterface{

    @Override
    public void decorator() {

    }
}

class Owner implements DecoratorInterface{

    DecoratorInterface decorator;

    public Owner(DecoratorInterface decorator){
        this.decorator = decorator;
    }

    @Override
    public void decorator() {
        decorator.decorator();
    }
}

interface DecoratorInterface{
    void decorator();
}

abstract class InputStream {
    abstract void getStream();
}


class FileStream extends InputStream{

    private InputStream target;
    public FileStream(InputStream target) {
        this.target = target;
    }

    @Override
    void getStream() {
        target.getStream();
    }

    void getFileStream(){

    }
}

class BufferStream extends InputStream{
    private InputStream target;
    public BufferStream(InputStream target) {
        this.target = target;
    }

    @Override
    void getStream() {
        target.getStream();
    }

    public void getButterStream() {

    }
}