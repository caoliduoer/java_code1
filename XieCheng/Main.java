package XieCheng;

import java.util.Map;
import java.util.Scanner;
public class Main{
    public static int count=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        String[] s1=s.split(" ");

        int[] arr=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            arr[i]=Integer.parseInt(s1[i]);
        }

        quickSort(arr,0,arr.length-1);
        getSum(arr.length-1,arr,num);
        System.out.println(count);



    }

    public static int[] getSum(int n,int[] arr,int num){

        int len=(int)Math.pow(2,(n))-1;
        int a[]=new int[len];
        int b[]=getSum(n-1,arr,num);
        int i=0;
        for(i=0;i<(len-1)/2;i++){
            a[i]=b[i];
            int temp=b[i]+arr[n];
            if(temp==num){
                count++;
            }
            a[i+(len+1)/2]=temp;
        }
        return a;
    }
    public  static  void quickSort(int [] array,int left,int right){
        if(left>=right){
            return;
        }
        int q=partition(array,left,right);
        quickSort(array,left,q-1);
        quickSort(array,q+1,right);
    }
    public static  int partition(int[] array,int left,int right){
        int i=left,j=right+1;
        int p= (int) (Math.random() * (right - left + 1)) +left;
        int temp=array[left];
        array[left]=array[p];
        array[p]=temp;
        int x=array[left];
        while (true){
            while(i<right&&array[++i]<x);
            while (j>left&&array[--j]>x);
            if(i>j){
                break;
            }
            int t1=array[i];
            array[i]=array[j];
            array[j]=t1;

        }
        return  j;
    }
}
