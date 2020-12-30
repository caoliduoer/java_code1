package shujiazuoye;

import java.util.Map;
import java.util.TreeMap;

public class FindTwoNmber {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,7,1,3,5,9};
        findTwoNumber(arr);

    }

    private static void findTwoNumber(int[] arr) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])!=null){
                int a=map.get(arr[i]);
                map.put(arr[i],++a);

            }else{
                map.put(arr[i],1);
            }
        }
        for(int a:map.keySet()){
            if(map.get(a)==1){
                System.out.println(a);
            }
        }
    }

}
