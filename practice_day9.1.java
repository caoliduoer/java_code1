import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            for(int i=0;i<num+1;i++){
                for(int j=num-i;j>0;j--){
                    System.out.print(" ");
                }for(int j=i+1;j>0;j--){
                    System.out.print("* ");
                }
                System.out.println();
            }
            for(int j=0;j<num;j++){
                for(int i=j+1;i>0;i--){
                    System.out.print(" ");
                }
                for(int i=num-j;i>0;i--){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}