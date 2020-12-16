package BitOS;

public class StopThreadTest {
    private static volatile  boolean STOP=false;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //执行任务，时间较长

                    try {
                        for(int i=0;i<10000&&!STOP;i++){
                        System.out.println(i);
                            Thread.sleep(1000);
                            //使用标志位自行实现，无法解决线程阻塞
                    }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        });
        t.start();
        System.out.println("t.start");
        //模拟执行5秒之后没有结束，就要中断停止
        //让线程中断，停止
        Thread.sleep(5000);
        STOP=true;
        System.out.println("t.stop");
    }
}
