package shujiazuoye;

import java.util.Scanner;

public class OneNumer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数，我来计算他有多少个1");
        int num=sc.nextInt();
        System.out.println(countOne(num));
    }

    private static int countOne(int num) {
        int count=0;
        if(num==0){
            return  count;
        }
        while(num!=0){
            if((num&1)==1){
                count++;
            }
            num=num>>1;
        }
        return count;

    }
}
