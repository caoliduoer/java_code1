package sort;

public class QuickSort {
    public static void quickSort(int[] arr){
        sortInternal(arr,0,arr.length-1);
    }
    public static void sortInternal(int[] arr,int lowIndex,int highIndex){
        int size=highIndex-lowIndex+1;
        if(size<=1){
            return;
        }
        int keyIndex=partitionLeftRightIndex(arr,lowIndex,highIndex);
        sortInternal(arr,lowIndex ,keyIndex-1);
        sortInternal(arr,keyIndex+1,highIndex);
    }

    public static int partitionDighill(int[] arr, int lowIndex, int highIndex){//挖坑法解决
        int headIndex=lowIndex;
        int tailIndex=highIndex;
        int key=arr[lowIndex];
        while(headIndex<tailIndex){
            while(arr[tailIndex]>key&&headIndex<tailIndex){
                tailIndex--;
            }if(headIndex<tailIndex){
                arr[headIndex]=arr[tailIndex];
                headIndex++;
            }
            while(arr[headIndex]<=key&&headIndex<tailIndex){
                headIndex++;
            }if(headIndex<tailIndex){
                arr[tailIndex]=arr[headIndex];
                tailIndex--;
            }
        }
        arr[tailIndex]=key;
        return tailIndex;
    }
    public static int partitionLeftRightIndex(int[] arr, int lowIndex, int highIndex){
        //设置两个初始下标指向数组的开头(headIndex,tailIndex)
        //先判断tailIndex对应的元素是不是大于key值。大于就向后走，要保证两个线标之间的元素是大于key的。
        //如果遇到了一个不大于的元素，那就交换前后指针指向的元素，并且两个指针同时向后走一步
        //重复这个操作一直到后面的下标超出数组的范围。
        //返回下标（分情况）。
        int headIndex=lowIndex;
        int tailIndex=headIndex;
        int key=arr[headIndex];
        while (tailIndex<=highIndex) {
            if(arr[headIndex]>key){
                if(arr[tailIndex]>key){
                    tailIndex++;
                }
                else{
                    swap(arr,headIndex,tailIndex);
                    headIndex++;
                    tailIndex++;
                }
            }else{
                if(tailIndex<=key){
                    headIndex++;
                    tailIndex++;
                }
            }
        }
        swap(arr,lowIndex,headIndex-1);
        return headIndex-1;

    }
    public static int partition(int[] arr, int lowIndex, int highIndex){
        int headIndex=lowIndex;
        int tailIndex=highIndex;
        int key=arr[lowIndex];
        while(headIndex<tailIndex){
            if(arr[tailIndex]>key){
                tailIndex--;
            }else if(arr[tailIndex]<=key){
                if(arr[headIndex]>key){
                    swap(arr,headIndex,tailIndex);
                    headIndex++;
                    tailIndex--;
                }
                else if(arr[headIndex]<=key){
                    headIndex++;
                }
            }
        }
        swap(arr,lowIndex,tailIndex);
        return tailIndex;
    }
    public static void swap(int[] arr,int index1,int index2){
        int tmp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=tmp;
    }


}
