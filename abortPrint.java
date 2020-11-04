import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char num=sc.nextLine().charAt(0);
        System.out.println("    "+num);
        System.out.println("   "+num+" "+num);
        System.out.println("  "+num+" "+num+" "+num);
        System.out.println(" "+num+" "+num+" "+num+" "+num);
        System.out.println(num+" "+num+" "+num+" "+num+" "+num);
    }
}