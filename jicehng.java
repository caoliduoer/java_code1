package practice;

public class jicehng {
    private static int a=100;

    public static void main(String[] args) {
        jicehng j1=new jicehng();
        j1.a++;
        jicehng j2=new jicehng();
        j2.a++;
        j1=new jicehng();
        j1.a++;
        jicehng.a--;
        System.out.println(a);
    }
}
