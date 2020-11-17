package practice;
import java.util.Scanner;
public class Printfuse1 {


        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                int num=sc.nextInt();
                for(int i=0;i<num;i++){
                    for(int j=i;j>0;j--){
                        System.out.printf(" ");
                    }System.out.printf("*\n");

                }
            }
        }

}
