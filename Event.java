package mylistener;

public class Event {
    private Mine me;

    public Event(Mine mine) {//构造方法：创建对象的时候调用
        super();
        this.me=mine;
    }

    public Mine getMe() {
        return me;
    }

    public void setMe(Mine me) {
        this.me = me;
    }
}
