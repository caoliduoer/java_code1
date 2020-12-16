package BitOS;

/*
* 打印语句是在main线程里面的，
* 主线程和子线程同时执行，但是子线程休眠了三秒钟才执行，所以推迟了打印，先打印了OK
* */
public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] Threads=new Thread[20];
        for(int i=0;i<20;i++){
            final int n=i;
            //new操作有点耗时。
            Threads[i] =new Thread(){
                @Override
                public void run() {

                        //Thread.sleep(3000);
                        System.out.println(n);//内部类使用外部的变量，必须是final修饰的

                }
            };

        }
        for(Thread t:Threads){
            t.start();
//            t.join();//一个线程启动后，等待他执行完，再执行下一个。
        }
        /*while (Thread.activeCount()>1){
            Thread.yield();//当前线程让步：从运行态转换为就绪态
        }*/
        for(Thread t:Threads){
            t.join();//当前线程无条件等待（main），等待他执行结束。（同时执行所有的线程完毕）
        }
        System.out.println("ok");
    }
}
