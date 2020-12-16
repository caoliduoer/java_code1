package BitOS;

/*
* t和main同时并发执行，但因为main线程正在运行态执行代码，很快执行后续代码
* 打印main和t，本应该乱序随机，但是先打印后面的效率高。
* */
public class Join {
    public static void main(String[] args) throws InterruptedException {

            Thread t=new Thread(){
                @Override
                public void run() {
                    System.out.println("t");
                }
            };//申请系统创建线程t
            t.start();//申请系统执行线程t,:创建态转变成就绪态，由系统决定什么时候变成运行态
            t.join();//当前线程无条件等待（main线程无条件等待，直到t线程执行完毕，当前线程再往后执行；
        System.out.println("main");
    }
}
