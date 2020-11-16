package practice;
import java.util.Scanner;
public class PrintfUse {

        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                int num=sc.nextInt();
                for(int i=0;i<=num;i++){
                    for(int j=0;j<(num-i)*2;j++){
                        System.out.print(" ");
                    }
                    for(int j=i+1;j>0;j--){
                        System.out.print("*");
                    }System.out.println("");
                }
                for(int i=0;i<num;i++){
                    for(int j=(i+1)*2;j>0;j--){
                        System.out.printf(" ");
                    }
                    for(int j=(num-i);j>0;j--){
                        System.out.printf("*");
                    }
                    System.out.println("");
                }
            }
        }

}

