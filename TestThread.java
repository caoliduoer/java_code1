package MyThreadClass;

public class TestThread {
    public static void main(String[] args) {
        CubbyHole h=new CubbyHole();
        Producer p=new Producer(h);
        Consumer c=new Consumer(h);
        p.start();
        c.start();
    }
}
