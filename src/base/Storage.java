package base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by shs1329 on 2017/8/30.
 */
public class Storage {

    static final BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
    static Integer count = 0;

    public  static void main(String[] args){
        new ThreadConsume().start();
        new ThreadConsume().start();
        new ThreadConsume().start();
        new ThreadProduce().start();
        new ThreadProduce().start();
        new ThreadProduce().start();

    }

    public static class ThreadProduce extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0;i< 5;i++){
                try {
                    Thread.sleep(1000);
                    bq.add(1);
                    count++;
                    System.out.println("生产者" + Thread.currentThread().getName() + "已生产完成，商品数量：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadConsume extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0;i<5;i++){
                try {
                    Thread.sleep(1000);
                    bq.take();
                    count--;
                    System.out.println("消费者"+Thread.currentThread().getName()+"已消费,剩余商品"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
