package shujiazuoye;
import java.util.Scanner;
public class FindNumber {


    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println("请输入一个要查找的数字：");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(findNum(arr, a));
    }
    private static int  findNum(int[][] arr,int a) {
        int i=arr.length-1,j=0;
        int num=0;
        //int key=arr[i][j];
        while (i>0&&j<arr[i].length){
            if(a>arr[i][j]){
                j++;
            }else if(a==arr[i][j]){
                num=a;
                break;
            }else{
                i--;
            }
        }if(j>arr[i].length||i<0){
            return -1;
        }
        return num;
    }
}

