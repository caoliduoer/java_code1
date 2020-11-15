import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            for(int k=0;k<num;k++){
            for(int j=k;j>0;j--){
                System.out.print(" ");
            }
            for(int i=num-k;i>0;i--){
                System.out.print("* ");
            }
                System.out.println();
            }
        }
    }
}