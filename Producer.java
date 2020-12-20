package MyThreadClass;


import static java.lang.Thread.sleep;

public class Producer extends Thread{
    private CubbyHole cubbyHole;
    public Producer(CubbyHole c){
        cubbyHole=c;
    }public void run(){
        for(int i=0;i<10;i++){
            cubbyHole.put(i);
            System.out.println("Producer"+"   put:"+i);
            try{
                sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
