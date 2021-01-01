package Thread;

import com.sun.org.apache.xpath.internal.objects.XObject;

public class ThreadTransfer {
    public static void main(String[] args) throws InterruptedException {
        Object o=new Object();
        Thread t=new Thread(()->{
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<1000_000;i++){}
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t.getState());//没有被启动之前是new的状态
        t.start();
        System.out.println(t.getState());//线程被启动后是runnable状态
        Thread.sleep(10);
        synchronized (o){
            for(int i=0;i<10;i++){
                System.out.println(t.getState());//
            }
            o.notify();
        }while (t.isAlive()){
            System.out.println(t.getState());
        }
    }
}
