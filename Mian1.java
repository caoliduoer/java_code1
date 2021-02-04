package winCount;

import java.util.Scanner;

public class Mian1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num= sc.nextLine();
        int n=Integer.parseInt(num);
        char[] ch=new char[]{'B','C','J'};
        int[] count=new int[3];//分别表示a胜，a平，a败
        int[][] arr=new int[3][2];
        for (int i = 0; i < n; i++) {
            char c1=sc.next().charAt(0);
            char c2=sc.next().charAt(0);
            int index1=0;int index2=0;
            for(int j=0;j<ch.length;j++){
                if(c1==ch[j]){
                    index1=j;
                }if(c2==ch[j]){
                    index2=j;
                }
            }
            switch (index1-index2){
                case 2:
                case -1://a胜
                    count[0]++;arr[index1][0]++;break;

                case 0:count[1]++;break;

                case -2:
                case 1://b胜
                    count[2]++;arr[index2][1]++;break;

            }
        }
            System.out.println(count[0]+" "+count[1]+" "+count[2]);
            System.out.println(count[2]+" "+count[1]+" "+count[0]);

            for(int j=0;j<2;j++){
                int max=arr[0][j];
                int key=0;
                for(int k=0;k<3;k++){
                    if(arr[k][j]>max){
                        max=arr[k][j];
                        key=k;
                    }
                }
                System.out.print(ch[key]+" ");
            }

    }
}
