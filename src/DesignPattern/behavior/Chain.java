package DesignPattern.behavior;

/**
 * Created by kangqizhou on 2017/9/3.
 */

/***
 * 此处强调一点就是，链接上的请求可以是一条链，可以是一个树，还可以是一个环，
 * 模式本身不约束这个，需要我们自己去实现，同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
 */
interface Interceptor {

    void operator();
}

abstract class BaseInterceptor {

    private Interceptor interceptor;


    public Interceptor nextInterceptor() {
        return interceptor;
    }

    public void setInterceptor(Interceptor interceptor){
        this.interceptor = interceptor;
    }
}


class InterceptorA extends BaseInterceptor implements Interceptor {

    @Override
    public void operator() {
        if (nextInterceptor() != null)
            nextInterceptor().operator();
    }
}

interface InterceptorMain{
    public static void main(String[] args){
        InterceptorA interceptorA = new InterceptorA();
        InterceptorA interceptorB= new InterceptorA();
        InterceptorA interceptorC = new InterceptorA();
        interceptorA.setInterceptor(interceptorB);
        interceptorB.setInterceptor(interceptorC);
    }
}

