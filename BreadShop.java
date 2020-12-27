package Thread;

public class BreadShop {
    private  static int ProducerCOUNT;
    private static int ConsumerCount;
    public static class Consumer implements Runnable{
        private String name;
        public Consumer(String name){
            this.name=name;
        }
        @Override
        public void run() {
            try {
                while(true){
                    synchronized(BreadShop.class){
                        if(ConsumerCount==90){
                            BreadShop.class.wait();//释放对象锁
                        }else{
                            System.out.printf("消费者%s消费了10个面包\n",name);
                            ConsumerCount+=10;
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Producer implements Runnable{
        @Override
        public void run() {
            try {
                while(true){
                    synchronized(BreadShop.class){
                        if(ProducerCOUNT+3>100){
                            BreadShop.class.wait();
                        }else{
                            System.out.println("生产者生产了10个面包");
                           ProducerCOUNT+=10;
                           BreadShop.class.notifyAll();
                            Thread.sleep(50);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    Producer[] name;
    public static void main(String[] args) {
        //Thread[] t1=new Thread[20];
        Thread[] name=new Thread[3];
        Thread[] producer=new Thread[3];
        /*for(int i=0;i<t1.length;i++){
            t1[i].start();
        }*/
        for(int i=0;i<name.length;i++){
            name[i] = new Thread(new Consumer(String.valueOf(i)) );

        }
        for(int i=0;i<producer.length;i++){
            producer[i]=new Thread(new Producer());
        }
        for(Thread t:name){
            t.start();
        }
        for(Thread p:producer){
            p.start();
        }
    }
}
