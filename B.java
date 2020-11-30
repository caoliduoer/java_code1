package practice;

public class B
{
    public static B t1 = new B();//静态对象，提升了地位，成为了静态区，是在main方法之前加载的
    public static B t2 = new B();//创建静态对象，所以就执行了构造块
    {
        System.out.println("构造块");//构造块是每次创建对象的时候执行
    }
    static
    {
        System.out.println("静态块");//JVM加载类时执行，仅执行一次
    }
    public static void main(String[] args)
    {
        B t =new B();
    }
}
