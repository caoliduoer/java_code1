package sort;


import java.util.Arrays;

public class sortDemo {
    public static void main(String[] args) {
        int arr[]={9,10,2,22,3,5,6,18};//乱序
        int arr1[]={9,7,6,3,2,1};//逆序
        int arr2[]={1,4,5,6,8,9};//顺序
        QuickSort.quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
