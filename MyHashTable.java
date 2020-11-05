package MyHashTable;
//拉链法
public class MyHashTable {
    public  Node[] array=new Node[11];//数组，存储节点
    public int size;//方便维护，记录哈希表中元素的个数。
    //插入节点向数组里面。
    public boolean insert(Integer key){
        //先得到节点的哈希值；
        //在得到坐标
        //查看该下标里面是不是有元素，如果没有就插入数组，如果有就头插。
        int hashValue=key.hashCode();
        int index=hashValue% array.length;
        Node current=array[index];
        if(current==null){//假如头结点是空的直接插入，成为头结点。
            Node node=new Node(key);
            array[index]=node;
            size++;
            return true;
        }
        while(current!=null){
            if(key.equals(current.val)){
                return false;//在没有插入的情况下已经存在。
            }
            current=current.next;

        }
        //确认这个数组里面没有这个值之后进行头插
       Node newhead=new Node(key);
        newhead.next=array[index];
        array[index]=newhead;
        size++;
        return true;
    }
    public boolean remove(Integer key){
        //先求出该哈希值
        //然后再通过哈希值求得应存下标
        //从这个下标找到头结点，然后遍历链表寻找要删除的这个值
        //如果找到了，那就直接删除，返回true，没有找到就返回false，
        int hashValue=key.hashCode();
        int index=hashValue%array.length;
        Node current=array[index];
        Node parent=current;
        if(current==null){
            return false;
        }
        while(current!=null){
            if(key.equals(current.val)){
                if(current==parent){
                    array[index]=current.next;
                    size--;
                    return true;
                }else {
                    parent.next = current.next;
                    size--;
                    return true;
                }
                //删除节点
            }
            parent=current;
            current=current.next;
        }
        return false;
    }
    public boolean search(Integer key){
        //先要得到对应的哈希值
        //通过哈希值得到对应的下标
        //从这个下标开始向下遍历每一个节点，看是否有这个节点。
        int hashValue=key.hashCode();
        int index=hashValue%array.length;
        Node current=array[index];
        while(current!=null){
            if(key.equals(current.val)){//值相等，則表示找到了
                return true;
            }
            current=current.next;
        }
        return false;
    }
}
