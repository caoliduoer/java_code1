import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        float circ=(float)a+b+c;
        float area=(float)Math.pow((circ/2)*(circ/2-a)*(circ/2-b)*(circ/2-c),0.5);
        System.out.printf("circumference=%.2f area=%.2f",circ,area);
    }
}