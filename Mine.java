package mylistener;

public class Mine {
    /*s
    * 事件源是Mine
    * */
    private Listener listener;

    /*
    * 注册我的监听器
    * */
    public void registerListener (Listener listener){
        this.listener=listener;
    }
    /*
    *创建触发事件
    *
    * */
    public  void working(){
        if(listener!=null){//如果监听器不为空，那就创建事件，监听
            Event event=new Event(this);//新建对象之后，调用将当前类的引用作为参数传入
           listener.working(event);//
        }
        System.out.println("我开始工作了");
    }
}
