package CardWindows;

import java.awt.*;
public class CardWindow extends Frame{

    public static void main(String[] args) {
        Frame f=new Frame();
        //setLayout(new BorderLayout());

       // setFont(new Font("Helvetica",Font.PLAIN,14));
        //创建选择列表
        Panel cp=new Panel();
        cp.add(new Button("text1"));
        //cp.add(new Button("text2"));
        Button b2=new Button("Text2");
        cp.add(new Button("text3"));
        //cp.add(new Button("text4"));
        Button b=new Button("tex7");
        f.add(cp);
        f.setBounds(200,300,900,500);
        f.setVisible(true);
        Thread t=new Thread(){
            @Override
            public void run() {

                while(true) {
                    try {b.setVisible(true);
                        cp.add(b);
                        sleep(10);
                        b.setVisible(false);//隐藏
                        //f.add(cp);

                    } catch (Exception e) {
                        return;
                    }
                }

            }
        };
        t.start();
        Thread t2=new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        b2.setVisible(false);//隐藏
                        cp.add(b2);
                        sleep(10);
                        b2.setVisible(true);
                        //f.add(cp);

                    } catch (Exception e) {
                        return;
                    }
                }
            }
        };
        t2.start();
    }
}
