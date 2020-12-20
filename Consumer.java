package MyThreadClass;

public class Consumer extends Thread{
    private CubbyHole cubbyHole;
    public Consumer(CubbyHole c){
        cubbyHole=c;
    }
    public void run(){
        int value=0;
        for(int i=0;i<10;i++){
            value=cubbyHole.get();
            System.out.println("Consumer   "+"got:"+value);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
