package practice;

import java.util.*;

public class RightAndLeft {
    public static void main(String[] args) {
        String A="()()())";
        int n=7;
        System.out.println(chkParenthesis(A,n));
    }
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        if(n%2==1){
            return false;
        }else{
            int right=0;
            int left=0;
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)=='['){
                    right++;
                }else if(A.charAt(i)==']'){
                    left++;
                }
            }
            if(right==left&&(right+left)==n){
                return true;
            }
            return false;
        }
    }
}
