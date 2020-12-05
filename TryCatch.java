package practice;

public class TryCatch {
    public int mytry(int s,int b){
        //int b=0;
        try{
            int a=0;
            return b+100;
        }catch (Exception e){
            return 0;
        }finally {
            return b-10;
        }
      //  System.out.println(9);
    }
    public static void compat(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }
    public static void main(String[] args) {
        TryCatch t=new TryCatch();
        int b=100;
        System.out.println(t.mytry(4,100));
        System.out.println(b);
        StringBuffer a=new StringBuffer("A");
        StringBuffer c=new StringBuffer("B");
        compat(a,c);
        System.out.println(a+","+c);

    }
}
