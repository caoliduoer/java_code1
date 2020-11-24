package practice;

import java.util.Scanner;
public class Try{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int sum=sc.nextInt();
            int newEmpty=sum/3;
            int count=newEmpty;
            while(sum>3){
                sum=newEmpty+sum%3;
                newEmpty=sum/3;
                count+=newEmpty;
            }
            if(sum==2){
                System.out.println(count+1);

            }else{
                System.out.println(count);
            }
        }
    }
}