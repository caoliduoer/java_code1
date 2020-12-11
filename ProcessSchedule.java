package Process;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;
public class ProcessSchedule {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arriveTime=new int[]{0,1,2,3,4};
        int[] serviceTime=new int[]{4,3,4,2,4};
        int[] priority=new int[]{1,2,5,9,3};

        menu(serviceTime,arriveTime);
        int select=sc.nextInt();
        switch (select){
            case 1:
                FCFS(arriveTime,serviceTime);
                break;
            case 2:
                System.out.println("请输入时间片的大小");
                int pice=sc.nextInt();
                TimePices(arriveTime,serviceTime,pice);

                break;
            case 3:
                priority(priority,serviceTime,arriveTime);//优先级调度算法
                break;
        }
    }

    private static void priority(int[] pro,int[] ser,int[] arr) {//优先级调度算法
        char[] c=new char[ser.length];//进程名
        char ch='A';
        for(int i=0;i<ser.length;i++,ch++){
            c[i]=ch;
        }
        int[] startTime=new int[ser.length];//开始时间
        int[] over=new int[ser.length];//结束时间
        int[] stadyTime=new int[ser.length];//周转时间
        float[] privilegedTime=new float[ser.length];//带权周转时间
        for(int i=0;i<pro.length;i++){
            for(int j=0;j<pro.length-i-1;j++){
                if(pro[j]<pro[j+1]){//优先级排序
                    pro[j]^=pro[j+1];
                    pro[j+1]^=pro[j];
                    pro[j]^=pro[j+1];
                    ser[j]^=ser[j+1];
                    ser[j+1]^=ser[j];
                    ser[j]^=ser[j+1];
                    c[j]^=c[j+1];
                    c[j+1]^=c[j];
                    c[j]^=c[j+1];
                }
            }
        }
        System.out.println("进程名     优先级    到达时间     服务时间   开始时间   完成时间   周转时间   带权周转时间");
        for(int i=0;i<ser.length;i++){
            if(i==0){
                startTime[i]=arr[0];
            }
            else{
                startTime[i]=over[i-1];//新的进程的开始时间等于上一个进程的结束时间
            }
            over[i]=startTime[i]+ser[i];//该进程额结束时间，等于该进程的开始时间+服务时间；
            stadyTime[i]=over[i]-arr[i];//进程的周转时间=完成时间-到达时间
            privilegedTime[i]=stadyTime[i]/(float)ser[i];//带权周转时间=周转时间/服务时间
        }
        for (int i=0;i<ser.length;i++){

            System.out.printf(c[i]+"          "+pro[i]+"           "+arr[i]+"          "+ser[i]+"         "+startTime[i]+"         "+over[i]+"         "+stadyTime[i]+"           "+privilegedTime[i]);
            System.out.println();
        }
    }

    private static void TimePices(int[] arr,int[] ser,int pice) {
        int[] over=new int[arr.length];//结束时间
        int[] startTime=new int[arr.length];//开始时间
        int[] stadyTime=new int[arr.length];//周转时间
        int[] ser1=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            ser1[i]=ser[i];
        }
        float[] privilegedTime=new float[arr.length];//带权周转时间
            int j=0;
            List<Character> c=new ArrayList<>();
            while (c.size()<arr.length-1) {
                for (int i = 0; i < ser1.length; i++) {
                    if(j<arr.length) {
                        startTime[i] = i * pice;//初次赋值即可
                    }
                    if (ser1[i] == 0) {
                        continue;
                    } else {
                        j++;//计算有多少步,只要不为0就要被执行进程，当前进程就被执行结束
                        if (ser1[i] - pice <= 0) {
                            over[i]=(j-1)*pice+ser1[i];
                            stadyTime[i]=over[i]-arr[i];
                            privilegedTime[i]=stadyTime[i]/(float)ser[i];//计算时使用原有的服务时间
                            char ch= (char) ('A'+i);
                            c.add(ch);//添加进程号
                            ser1[i]=0;//操作结束后将其置零
                        }else{
                            ser1[i]-=pice;
                        }
                    }

                }
            }
        System.out.println("进程名      到达时间     服务时间   开始时间   完成时间   周转时间   带权周转时间");
        for (int i=0;i<ser.length;i++){
            System.out.printf(c.get(i)+"          "+arr[i]+"          "+ser[i]+"         "+startTime[i]+"         "+over[i]+"         "+stadyTime[i]+"           "+privilegedTime[i]);
            System.out.println();
        }
    }

    private static void FCFS(int[] arr,int[] ser) {//先来先服务
        int[] over=new int[arr.length];//结束时间
        int[] startTime=new int[arr.length];//开始时间
        int[] stadyTime=new int[arr.length];//周转时间
        float[] privilegedTime=new float[arr.length];//带权周转时间
        for(int i=0;i<arr.length;i++){
            if(i==0){
                startTime[i]=arr[0];
            }
            else{
                startTime[i]=over[i-1];//新的进程的开始时间等于上一个进程的结束时间
            }
            over[i]=startTime[i]+ser[i];//该进程额结束时间，等于该进程的开始时间+服务时间；
            stadyTime[i]=over[i]-arr[i];//进程的周转时间=完成时间-到达时间
            privilegedTime[i]=stadyTime[i]/(float)ser[i];//带权周转时间=周转时间/服务时间
        }
        System.out.print("进程名    到达时间     服务时间   开始时间   完成时间   周转时间   带权周转时间\n");
        char c=65;
        for (int i=0;i<ser.length;i++){

            System.out.printf("%c"+"           "+arr[i]+"          "+ser[i]+"         "+startTime[i]+"         "+over[i]+"         "+stadyTime[i]+"           "+privilegedTime[i],c++);
            System.out.println();
        }
    }
    public static void menu(int[] ser,int[] arr){
        System.out.println("现在有进程数目："+ser.length);
        System.out.println("****************************************************");
        System.out.println("***************请选择你希望的进程调度方式****************");
        System.out.println("*****************1.先来先服务*************************");
        System.out.println("*****************2.时间片轮转算法**********************");
        System.out.println("*****************3.优先级队列算法**********************");
    }
}
