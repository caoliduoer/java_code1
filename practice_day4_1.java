import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(sc.hasNext()){
            int num=sc.nextInt();
            System.out.println(2<<(num-1));
            i++;
        }
    }
}