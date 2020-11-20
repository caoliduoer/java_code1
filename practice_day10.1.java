import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        float sum=0;
        while(sc.hasNext()){
            float height=sc.nextFloat();
            sum+=height;
        }
        System.out.printf("%.2f",sum/5);
    }
}