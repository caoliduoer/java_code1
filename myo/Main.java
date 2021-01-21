package javaScript.myo;

import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str2=sc.nextLine();
        String str1=sc.nextLine();
        char[] ch1=str1.toCharArray();
        List<Character> list1=new ArrayList<>();
        for(int i=0;i<ch1.length;i++){
            list1.add(ch1[i]);
        }
        char[] ch2=str2.toCharArray();
        List<Character> list2=new ArrayList<>();
        for(int i=0;i<ch2.length;i++){
            list2.add(ch2[i]);
        }
        int a=0;
        while(a<list1.size()){

            int index=list2.indexOf(list1.get(a));
            if(index>=0){
                list2.remove(index);
                list1.remove(a);
            }else{
                a++;
            }
        }
        if(list1.size()==0){
            System.out.println("Yes"+" "+list2.size());
        }else{
            System.out.println("No"+" "+list1.size());
        }

    }
}
