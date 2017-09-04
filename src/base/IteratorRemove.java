package base;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shs1329 on 2017/9/4.
 */
public class IteratorRemove {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Iterator<Integer> iterator = list.iterator();
        int i = 6;
        while (iterator.hasNext()){
            int temp = iterator.next();
            System.out.println(temp);
            if (i == temp){
                list.remove(i);
                iterator.remove();
                System.out.println("remove:"+temp);
            }
        }
    }

    public static class Parent{

    }

    public static class Child extends Parent{

    }

    public static class Temp<A,B,C,D,E> {
        public Temp(){

        }

        public static void main(String[] args){
            Temp<String,String,String,String,Storage> temp = new Temp();
            Type types = (temp.getClass().getGenericSuperclass());
//            for (Type type: types){
                System.out.println(types);
//            }
//            Parent parent = new Child();
//            System.out.println(parent.getClass());
        }
    }
}
