package MyHashTable;

public class MyHashTableTest {
    public static  void main(String[] args){
        int first=99;
        MyHashTable myhash=new MyHashTable();
        System.out.println(myhash.insert(first));
        System.out.println(myhash.remove(99));
        myhash.insert(13);
        myhash.insert(23);
        System.out.println(myhash.search(22));
        for(int i=0;i<myhash.array.length;i++){
            if(myhash.array[i]!=null) {
                System.out.println(i + ":" + myhash.array[i].val);
            }
        }
    }
}
