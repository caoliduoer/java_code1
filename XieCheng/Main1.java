package XieCheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        String[] s1=s.split(" ");

        int[] arr=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            arr[i]=Integer.parseInt(s1[i]);
        }
        int count=0;
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=arr[i];
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum==num){
                    count++;
                    break;
                }
                else if(sum<num){
                    sum+=arr[j];
                }
                else{
                    sum-=arr[j];
                }
            }

        }
        System.out.println(count);
    }
}
