import java.util.Scanner;
import java.util.TreeMap;
public class Main{
    public static void main(String[] args){
        TreeMap<Integer,String> map=new TreeMap();
        map.put(200,"OK");
        map.put(202,"Accepted");
        map.put(400,"Bad Request");
        map.put(403,"Forbidden");
        map.put(404,"Not Found");
        map.put(500,"Internal Server Error");
        map.put(502,"Bad Gateway");
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            System.out.println(map.get(num));
        }
    }
}