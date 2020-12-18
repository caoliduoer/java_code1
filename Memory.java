package dynamicpartition;

import java.util.LinkedList;
import java.util.Scanner;

public class Memory {
    /**
     * 分区节点类
     */
    static class Zone{
        private int size; // 分区大小
        private int head; //分区始址
        private boolean isFree; //空闲状态

        public Zone(int head, int size) {
            this.head = head;
            this.size = size;
            this.isFree = true;
        }
    }

   public int size; //内存大小
    public static final int MIN_SIZE = 2; //最小剩余分区大小
    public LinkedList<Zone> zones; //内存分区
    private int pointer; //上次分配的空闲区位置

    //默认内存大小512K
    public Memory(){
        this.size = 512;
        this.pointer = 0;
        this.zones = new LinkedList<>();
        zones.add(new Zone(0, size));
    }

    public Memory(int size) {
        this.size = size;
        this.pointer = 0;
        this.zones = new LinkedList<>();
        zones.add(new Zone(0, size));
    }

    /**
     * 内存分配选择
     * @param size 大小
     */
    public void allocation(int size){
        //System.out.println("1.First Fit   2.Next Fit   3.Best Fit   4.Worst Fit");
        //System.out.print("Please select assignment algorithm:");
        //Scanner in = new Scanner(System.in);
       // int xuanze = in.nextInt();
        /*switch (xuanze){
            case 1:*/
                fristFit(size);
            /*case 2:
                nextFit(size);break;*/
            //case 3:
                //bestFit(size);
            /*case 4:
                worstFit(size);break;
            default:
                System.out.println("Please reselect!");
        }*/
    }

    /**
     * FF
     * @param size
     */
    private void fristFit(int size){//首次适应算法
        //遍历分区链表
        for (pointer = 0; pointer < zones.size(); pointer++){//地址递增的顺序遍历
            Zone tmp = zones.get(pointer);
            //找到可用分区（空闲且大小足够）
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size, pointer, tmp);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("No memory space!");
    }

    /**
     * NF
     * @param size
     */
    /*private void nextFit(int size){
        Zone tmp = zones.get(pointer);
        if (tmp.isFree && (tmp.size > size)){
            doAllocation(size, pointer, tmp);
            return;
        }
        int len = zones.size();
        int i = (pointer + 1) % len;
        for (; i != pointer; i = (i+1) % len){
            tmp = zones.get(i);
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size, i, tmp);
                return;
            }
        }
        //全遍历后如果未分配则失败
        System.out.println("No memory space!");
    }*/

    /**
     * BF
     * @param size
     */
    public void bestFit(int size){
        int flag = -1;
        int min = this.size;//提前设定512
        for (pointer = 0; pointer < zones.size(); pointer++){//按照容量大小形成空闲分区链
            Zone tmp = zones.get(pointer);
            if (tmp.isFree && (tmp.size > size)){
                if (min > tmp.size - size){
                    min = tmp.size - size;
                    flag = pointer;
                }
            }
        }
        if (flag == -1){
            System.out.println("No memory space!");
        }else {
            doAllocation(size, flag, zones.get(flag));
        }
    }

    /**
     * WF
     * @param size
     */
    /*private void worstFit(int size){
        int flag = -1;
        int max = 0;
        for (pointer = 0; pointer < zones.size(); pointer++){
            Zone tmp = zones.get(pointer);
            if (tmp.isFree && (tmp.size > size)){
                if (max < tmp.size - size){
                    max = tmp.size - size;
                    flag = pointer;
                }
            }
        }
        if (flag == -1){
            System.out.println("No memory space!");
        }else {
            doAllocation(size, flag, zones.get(flag));
        }
    }*/

    //开始分配
    private void doAllocation(int size, int location, Zone tmp) {
        //要是剩的比最小分区MIN_SIZE小，则把剩下那点给前一个进程
        if (tmp.size - size <= MIN_SIZE){
            tmp.isFree = false;//不空闲
        } else {
            Zone split = new Zone(tmp.head + size, tmp.size - size);//分割这个分许
            zones.add(location + 1, split);//添加到链表
            tmp.size = size;
            tmp.isFree = false;
        }
        System.out.println("Successful distribution " + size + "KB memory!");
    }

    //内存回收
    public void collection(int id){
        if (id >= zones.size()){
            System.out.println("No partition number!");
            return;
        }
        Zone tmp = zones.get(id);
        int size = tmp.size;
        if (tmp.isFree) {
            System.out.println("Specifies that partitions are not allocated and need not be recycled.");
            return;
        }
        //如果回收的分区后一个是空闲就和后一个合并
        if (id < zones.size() - 1 && zones.get(id + 1).isFree){
            Zone next = zones.get(id + 1);
            tmp.size += next.size;
            zones.remove(next);
        }
        //回收的分区要是前一个是空闲就和前分区合并
        if (id > 0 && zones.get(id - 1).isFree){
            Zone previous = zones.get(id - 1);
            previous.size += tmp.size;
            zones.remove(id);
            id--;
        }
        zones.get(id).isFree = true;
        System.out.println("Memory recovery!, This is recycled " + size + "KB space!");
    }
    /**
     * 展示分区状况
     */
    public void showZones(){
        System.out.println("Partition number    Partition inception    Partition size    Idle state");
        for (int i = 0; i < zones.size(); i++){
            Zone tmp = zones.get(i);
//            System.out.println(i + "\t\t\t\t      " + tmp.head + "\t\t\t\t      " + tmp.size + "\t\t\t\t      " + tmp.isFree);
            System.out.printf("%8d%20d%20d%20s\n",i,tmp.head,tmp.size,tmp.isFree);
        }

    }

}
