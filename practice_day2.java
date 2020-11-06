import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        while(num>0){
            int dev=num%10;
            System.out.print(dev);
            num=num/10;
        }
    }
}