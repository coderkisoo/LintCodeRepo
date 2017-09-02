package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */

/***
 * 模板模式，主方法调用模板方法
 */
abstract class Template{
    void mainMethod(int i){
        abstractMethod(i);
    }

    abstract void abstractMethod(int i);
}

class TemplateImpl extends Template{

    @Override
    void abstractMethod(int i) {

    }
}

interface TemplateMain{
    public static void main(String[] args){
        Template template = new TemplateImpl();
        template.mainMethod(1);
    }
}