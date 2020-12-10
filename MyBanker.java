package Banker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MyBanker {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println("");
        int[] available=new int[]{3,3,2};
        int[][] max=new int[][]{{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        int[][] allocation=new int[][]{{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
        int[][] need=new int[][]{{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};
        bank(available,allocation,need);
    }



    private static void bank(int[] ava,  int[][] allo, int[][] need) {
        List<int[]> need1=new ArrayList<>();
        List<int[]> allo1=new ArrayList<>();//列表
        for(int i=0;i<need.length;i++){
            need1.add(need[i]);
            allo1.add(allo[i]);
        }

        List<String> list=new ArrayList<>();
        for(int i=0;i<need.length;i++) {
            list.add("P" + i);
        }
        while(need1.size()>0) {
            int i = 0;
            int len=0;//判断是否安全；
            for (; i < need1.size(); i++) {//进程的个数
                len=need1.size();
                int count = 0;
                int[] info = need1.get(i);
                for (int j = 0; j < ava.length; j++) {
                    if (info[j] > ava[j]) {
                        break;//直接跳出，不满足了need<available
                    } else {
                        count++;
                    }
                }
                if (count == ava.length) {//满足资源数目大于need
                    System.out.print(list.remove(i) + "->");
                    need1.remove(i);//将需求队列里面的数字改变

                    //改变ava的变量值；
                    int[] all = allo1.get(i);
                    for (int k = 0; k < ava.length; k++) {
                        ava[k] = all[k] + ava[k];//改变ava的值
                    }
                    allo1.remove(i);//同时将分配当前情况也删掉，便于下次查找
                    break;
                }

            }if(i==len){
                System.out.println("状态不安全");
            }
        }
        System.out.println("找到一个安全序列，此时系统是安全的");
        /*for(int i:list){
            System.out.print("p"+i+"->");
        }*/
    }
}
