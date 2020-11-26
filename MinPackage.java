package practice;

import java.util.Scanner;
public class MinPackage{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int temp=100;
        int count=0;
        int i=1;
        while(i*8<=num){
            if((num-i*8)%6==0){
                count=i+(num-i*8)/6;
                if(count<temp){
                    temp=count;
                }
            }
            i++;
        }
        if(temp==100&&num!=6){
            System.out.println(-1);
        }
        else if(num==6||num==8){
            System.out.println(1);
        }else{
            System.out.println(temp);
        }
    }
}
