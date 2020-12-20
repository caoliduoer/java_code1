package MyThreadClass;

public class CubbyHole {
    /*private int contents;
    public int get() { return contents; }
    public void put(int value)
    { contents = value; }*/
    /**
     * 线程同步
     * 加锁。控制多个线程对单一资源的独立访问，互补干扰
     * */
   /* private int contents;
    public synchronized int get()
    { return contents; }
    public synchronized void put(int value)
    { contents = value; }
*/
    /**
    * 线程加锁
     *
    * */
    private int contends;
    private boolean available=false;
    public synchronized int get(){
        while(available==false){
            try{
                wait();//打开锁，等待produc放
            }catch (InterruptedException e){

            }
        }
        available=false;
        notifyAll();//唤醒所有等待进程
        return  contends;
    }
    public  synchronized void put(int value){
        while(available==true){
            try{
                wait();//打开锁等待consumer取值
            }catch (InterruptedException e){}
        }
        contends=value;available=true;
        notifyAll();//唤醒所有等待进程
    }
}
