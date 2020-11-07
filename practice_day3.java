import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int time=sc.nextInt();
        int second=time%60;

        int hour=time/3600;
        int minute=time%3600/60;
        System.out.println(hour+" "+minute+" "+second);
    }
}