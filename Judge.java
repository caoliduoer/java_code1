package shujiazuoye;

import java.util.Arrays;

public class Judge {


    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        //String a=adjust(arr).toString();
        System.out.println(Arrays.toString(adjust(arr)));
    }

    private static int[] adjust(int[] arr) {
        int[] a;
        int head=0;
        int tail=arr.length-1;
        while (head<tail){
            if(((arr[head])&1)==0){//前面为偶数
                if(((arr[tail])&1)==1){//后面为奇数
                    arr[head]^=arr[tail];
                    arr[tail]^=arr[head];
                    arr[head]^=arr[tail];
                }
                else{//后面为偶数
                    tail--;
                }
            }else{//前面为奇数
                head++;
            }
        }
        return arr;
    }

}
