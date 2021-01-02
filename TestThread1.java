package Thread;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.net.URL;

//实现多线程同步下载图片
public class TestThread1 extends Thread{
    private String url;//网络图片地址
    private String name;//保存的文件名
    public TestThread1(String url,String name){
        this.url=url;
        this.name=name;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
        webDownLoader web=new webDownLoader();
        web.downLoader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread1 t=new TestThread1("https://img-home.csdnimg.cn/images/20201231031228.jpg","28.jpg");
        TestThread1 t1=new TestThread1("https://img-home.csdnimg.cn/images/20210101032346.jpg","46.jpg");
        TestThread1 t2=new TestThread1("https://img-home.csdnimg.cn/images/20210101031518.jpg","18.jpg");
        //先下载t
        t.start();
        //先下载t1
        t1.start();
        //下载t2
        t2.start();
    }

}
//下载器
class webDownLoader{
    //下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法出现问题");
        }
    }
}
