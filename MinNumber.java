class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0){
            return num;
        }
            String[] str=num.split("");
            while(k>0){
            String s="";
            
            int i=0;
            for(i=0;i<str.length-1;i++){
                int n=Integer.parseInt(str[i]);
                if(n>Integer.parseInt(str[i+1])){
                    break;
                }
                s=s+str[i];
            }
            for(int j=i+1;j<str.length;j++){
                s=s+str[j];
            }
            str=s.split("");
            k--;
        }
        String s="";
        if(str[0]==""){
            return "0";
        }
        else{
        for(int i=0;i<str.length;i++){
            if((Integer.parseInt(str[i])==0)&&i==0){
                continue;
            }
            s=s+str[i];
        }
        if(s==""){
            return "0";
        }
       return s;
       }
        }
    
    
}