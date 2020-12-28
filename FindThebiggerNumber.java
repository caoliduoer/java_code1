package shujiazuoye;

import java.util.Scanner;

public class FindThebiggerNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println("你想得到数组里面第几小的数字：");
        Scanner sc=new Scanner(System.in);
        int key=sc.nextInt();
        findBigger(arr,key);
        //System.out.println();
    }

    private static void findBigger(int[] arr, int key) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]^=arr[j+1];
                    arr[j+1]^=arr[j];
                    arr[j]^=arr[j+1];
                }
            }
        }
        for(int i=0;i<key;i++){
            System.out.print("  "+arr[i]);
        }
    }
}
