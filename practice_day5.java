import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        float weight=sc.nextFloat();
        float height=sc.nextFloat();
        double bmi=weight/Math.pow(height,2);
        if(bmi<=23.9&&bmi>=18.5){
            System.out.println("Normal");
        }else{
            System.out.println("Abnormal");
        }
    }
}