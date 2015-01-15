/**
 * Created by udit mehrotra on 27/12/14.
 */
public class HashTableLinkedList<Key,Value> {

    private Node first = null;

    private class Node
    {
        Key key;
        Value value;
        Node next;
    }

    private void put(Key key, Value value)
    {
        if(first == null)
        {
            first = new Node();
            first.key = key;
            first.value = value;
            first.next = null;
            return;
        }

        Node cur = first;
        while(cur != null)
        {
            if(cur.key == key)
            {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        Node old_first = first;
        first = new Node();
        first.key = key;
        first.value = value;
        first.next = old_first;
    }

    private void get(Key key)
    {
        Node cur = first;
        Value value = null;
        while(cur != null)
        {
            if(cur.key == key)
            {
                value = cur.value;
            }
            cur = cur.next;
        }

        System.out.println("Got : " + value);
    }

    private void print()
    {
        Node cur = first;
        System.out.print("\nCurrent List :  ");
        while(cur != null)
        {
            System.out.print(cur.key + "," + cur.value + "   ");
            cur = cur.next;
        }
    }


    public static void main(String[] args)
    {
        HashTableLinkedList<String,Integer> ht = new HashTableLinkedList<String, Integer>();
        ht.put("udit", 123);
        ht.print();
        ht.put("susmita", 221);
        ht.print();
        ht.put("jaya",12);
        ht.print();
        ht.put("neeraj", 56);
        ht.print();
        ht.put("ujjwal", 78);
        ht.print();
        ht.put("suchitra", 345);
        ht.print();
        ht.put("udit", 66);
        ht.print();
        ht.put("suchitra", 678);
        ht.print();
        ht.put("apoorv", 90);
        ht.print();

        ht.get("udit");
        ht.get("apoorv");
        ht.get("jaya");



    }
}
