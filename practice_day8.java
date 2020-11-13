import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            for(int i=1;i<=num;i++){
                for(int j=(num-i)*2;j>0;j--){
                    System.out.printf(" ");
                }
                for(int k=i;k>0;k--){
                    System.out.printf("* ");
                }
                System.out.println();
}
        }
    }
}