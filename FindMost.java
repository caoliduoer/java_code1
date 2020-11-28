package practice;

import java.util.Scanner;
import java.util.TreeMap;
public class FindMost{
    public static void main(String[] args){
        TreeMap<String,Integer> map=new TreeMap();
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] word=str.split(" ");
        int i=0;
        for(;i<word.length;i++){
            int count=0;


            if(map.get(word[i])==null){
                map.put(word[i],1);
            }else{
                count=map.get(word[i]);
                map.put(word[i],++count);
            }

        }
       
        for(String key:map.keySet()){
            if(map.get(key)>=(i/2)){
                System.out.println(key);
            }
        }
    }
}
