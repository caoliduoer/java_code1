import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int arr[] =new int[sc.nextInt()];
        int i=0;
        
        while(sc.hasNext()){
            arr[i]=sc.nextInt();
            
            i++;
        }
        for(int j=5;j<arr.length-1;j++){
        getTop(arr,j);
        }
        int[] five=getTop(arr,arr.length-1);
        for(int k:five){
            System.out.printf("%d ",k);
        }
    }
    public static int[] getTop(int[] arr,int index){
        //int []five=new int[5];
        int last=arr[0];
        int lastIndex=0;
        for(int i=0;i<5;i++){
            //five[i]=arr[i];
            if(last>arr[i]){
                last=arr[i];
                lastIndex=i;
            }
        }
        if(last>=arr[index]){
            int[] five=new int[5];
            for(int i=0;i<5;i++){
                five[i]=arr[i];
            }
            return five;
        }else{
            int temp=arr[lastIndex];
            arr[lastIndex]=arr[index];
            arr[index]=temp;
            int[] five=new int[5];
            for(int i=0;i<5;i++){
                five[i]=arr[i];
            }
        return five;
        }
    }
}