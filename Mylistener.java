package mylistener;

import javax.xml.bind.Marshaller;

public class Mylistener implements Listener {
    @Override
    public void working(Event event) {
        Mine me=new Mine();
        System.out.println("准备开始工作了，请务必细心！");
    }
}
