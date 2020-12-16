package BitOS;

public class InterruptText {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000 && !Thread.currentThread().isInterrupted(); i++) {
                        System.out.println(i);
                        Thread.sleep(1000);
                        //使用标志位自行实现，无法解决线程阻塞
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }



    });
    System.out.println("t.start");
        //模拟执行5秒之后没有结束，就要中断停止
        //让线程中断，停止
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupted();//告诉t线程，要中断（设置t线程的标志位为true），由t的代码自行决定是否中断
        // STOP=true;
        System.out.println("t.stop");
}
}

