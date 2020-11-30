package mylistener;

public class TestListenr {
    public static void main(String[] args) {
        Mine me=new Mine();//创建对象
        me.registerListener(new Mylistener());//对象新建了监听器
        me.working();//对象调用了监听器
    }
}
