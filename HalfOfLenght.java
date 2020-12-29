package shujiazuoye;

import java.util.Map;
import java.util.TreeMap;

public class HalfOfLenght {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,2,2,2,5,4,2};
        findNum(arr);
    }

    private static void findNum(int[] arr) {
        int len=arr.length/2;
        Map<Integer,Integer> map=new TreeMap();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])!=null){
                int value=(map.get(arr[i]));
                map.put(arr[i],++value);
            }else{
                map.put(arr[i],1);
            }
        }
        for(int k:map.keySet()){
            if(map.get(k)>len){
                System.out.println(map.get(k));
            }
        }
    }
}
