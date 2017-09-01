package DesignPattern.build;

/**
 * Created by shs1329 on 2017/9/1.
 */
public class Singleton {
    private static Singleton hungrySingleton = new Singleton();//饿汉
    private static Singleton lazySingleton;//懒汉
    private static Singleton lockLazySingleton;//加锁的懒汉
    private static volatile Singleton dclSingleton;//双重检查的懒汉
    private static class SingletonHolder{//静态内部类的懒汉
        private static Singleton SINGLETON = new Singleton() ;
    }

    public enum EnumSingleton{//枚举类型的singleton
        EnumSingleton;

        EnumSingleton get(){
            return EnumSingleton;
        }

        private EnumSingleton(){

        }
    }

    public static Singleton hungrySingleton(){
        return hungrySingleton;
    }

    public static Singleton singleInstance() {
        if (lazySingleton == null) {
            lazySingleton = new Singleton();
        }
        return lazySingleton;
    }

    public static Singleton dclInstance() {
        if (dclSingleton == null) {
            synchronized (Singleton.class) {
                if (dclSingleton == null)
                    dclSingleton = new Singleton();
            }
        }
        return dclSingleton;
    }

    public synchronized static Singleton lockLazySingleton() {
        if (lockLazySingleton == null)
            lockLazySingleton = new Singleton();
        return lockLazySingleton;
    }

    public static Singleton innerSingleton(){
        return SingletonHolder.SINGLETON;
    }

    private Singleton(){}

}
