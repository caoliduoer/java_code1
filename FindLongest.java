package practice;

import java.util.Scanner;
public class FindLongest{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        String oldst="";
        String st="";
        boolean flag=true;
        for(int i=0;i<=str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                 st="";
                st+=str.charAt(i);
                i++;
                flag=true;
                while(flag&&i<str.length()){
                    if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                        st+=str.charAt(i);
                    }
                    else{
                        flag=false;
                        if(oldst.length()<st.length()){
                            oldst=st;
                        }
                    }
                    i++;
                }

            }
        }
        if(oldst.length()<st.length()){
            oldst=st;}
        System.out.println(oldst);

    }
}
