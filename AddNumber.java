package shujiazuoye;

import java.util.Arrays;

public class AddNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,7,7,8};
        int key=8;
        System.out.println(Arrays.toString(FindAdd(arr,key)));
    }

    private static int[] FindAdd(int[] arr,int key ) {
/**
* 让数组有序，然后让第一个数和最后一个数相加
 * 和key比较
 * 大于key--->那就是后面的数字大了，向前找一位
 * 小于key----》前面的数字小了，向后找一位。
* */
        int[] num=new int[2];
        int head=0;
        int tail=arr.length-1;
        while (head<tail){
            if(arr[head]+arr[tail]>key){
                tail--;
            }else if(arr[head]+arr[tail]==key){
                num[0]=head;
                num[1]=tail;
                System.out.println("("+head+","+tail+")");
                break;
            }else{
                head++;
            }

        }
        return num;
    }
}
