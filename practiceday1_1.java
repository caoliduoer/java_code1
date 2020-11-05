import java.util.Scanner;
public class Main{
    public static void main(String[] srgs){
       Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str1[]=str.split(",");
        String first[]=str1[0].split("=");
        String second[]=str1[1].split("=");
        System.out.println(first[0]+"="+second[1]+","+second[0]+"="+first[1]);
    }
}