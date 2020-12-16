package BitOS;

/*
* t和main同时并发执行，但因为main线程正在运行态执行代码，很快执行后续代码
* 打印main和t，本应该乱序随机，但是先打印后面的效率高。
* */
public class ThreadTest1 {
    public static void main(String[] args) {

            Thread t=new Thread(){
                @Override
                public void run() {
                    System.out.println("t");
                }
            };//申请系统创建线程t
            t.start();//申请系统执行线程t,:创建态转变成就绪态，由系统决定什么时候变成运行态

        System.out.println("main");
    }
}
