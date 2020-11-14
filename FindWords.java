package practice;

import java.util.TreeMap;
import java.util.TreeSet;

class Findwords {
    public static String mostCommonWord(String paragraph, String[] banned) {
        TreeMap<String,Integer> map=new TreeMap();
        TreeSet<String> set=new TreeSet();
        for(int k=0;k<banned.length;k++){
            set.add(banned[k]);
        }
        String st=paragraph.toLowerCase();
        String[] str=st.split("\\W+");
        for(int i=0;i<str.length;i++){
            if(set.contains(str[i])){
                continue;
            }
            else if(map.get(str[i])==null){//map中没有这个单词
                map.put(str[i],1);
            }else{//map中有这个单词
                int num=map.get(str[i]);
                num++;
                map.put(str[i],num);
            }
        }
        Integer max=0;
        String maxString="";
        for(String s:map.keySet()){
            if(map.get(s)>max){
                max=map.get(s);
                maxString=s;
            }
        }
        return maxString;
    }
    public  static void main(String[] args){

        String str="i an an honest girl,i am ok!";
        String str1[]={"an"};
        String s=mostCommonWord(str, str1);
        System.out.println(mostCommonWord(str, str1));
    }
}