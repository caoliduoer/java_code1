package practice;

import java.util.*;

public class Finder {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        return sort(a,0,n-1,n-K);
    }
    public static  int sort(int[] arr,int lowIndex,int highIndex,int K){
        int index=partition( arr,lowIndex,highIndex);
        if(index==K){
            return arr[index];
        }else if(index<K){
            return sort(arr,index+1,highIndex,K);
        }else{
            return sort(arr,lowIndex,index-1,K);
        }
    }
    public static int partition(int[] arr,int lowIndex,int highIndex){
        int keyIndex=lowIndex;
        int headIndex=lowIndex;
        int tailIndex=highIndex;
        while(headIndex<tailIndex){
            if(arr[tailIndex]>arr[keyIndex]){
                tailIndex--;
            }else{
                if(arr[headIndex]>arr[keyIndex]){
                    swap(arr,headIndex,tailIndex);
                    headIndex++;
                    tailIndex--;
                }else{
                    headIndex++;
                }
            }


        }
        swap(arr,lowIndex,tailIndex);
        return tailIndex;
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int[] arr=arr= new int[]{3, 9, 22, 53, 22};

        System.out.println(findKth(arr,5,3));
    }

}