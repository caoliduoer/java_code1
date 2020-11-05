import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] ch=str.toCharArray();
        System.out.print("year=");
        for(int i=0;i<4;i++){
            System.out.print(ch[i]);
        }
        System.out.println();
        System.out.print("month=");
        for(int i=4;i<6;i++){
            System.out.print(ch[i]);
        }
        System.out.println();
        System.out.print("date=");
        for(int i=6;i<ch.length;i++){
            System.out.print(ch[i]);
        }
    }
}