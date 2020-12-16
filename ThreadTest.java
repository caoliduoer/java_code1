package BitOS;

/*
* 打印语句是在main线程里面的，
* 主线程和子线程同时执行，但是子线程休眠了三秒钟才执行，所以推迟了打印，先打印了OK
* */
public class ThreadTest {
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            final int n=i;
            //new操作有点耗时。
            Thread t=new Thread(){
                @Override
                public void run() {
                    try{
                        Thread.sleep(3000);
                        System.out.println(n);//内部类使用外部的变量，必须是final修饰的
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        System.out.println("ok");
    }
}
