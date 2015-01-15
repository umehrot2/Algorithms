/**
 * Created by uditmehrotra on 13/01/15.
 */
public class HashTableSeparateChaining<Key, Value>
{

    private int capacity = 5;
    private Node[] ht = new Node[capacity];

    private static class Node
    {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val)
        {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void put(Key key, Value val)
    {
        int index = hash(key);
        if(ht[index] == null)
        {
            ht[index] = new Node(key, val);
            return;
        }

        Node temp = ht[index];
        ht[index] = new Node(key, val);
        ht[index].next = temp;
    }

    private Value get(Key key)
    {
        int index = hash(key);
        Node cur = ht[index];
        while(cur != null)
        {
            if(cur.key.equals(key))
                return (Value) cur.val;

            cur = cur.next;
        }

        return null;
    }

    private void print()
    {
        for(int i = 0; i < capacity; i++)
        {
            Node cur = ht[i];
            while(cur != null)
            {
                System.out.print(cur.key + "," + cur.val + "  ");
                cur = cur.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        HashTableSeparateChaining<String, Integer> obj = new HashTableSeparateChaining<String, Integer>();
        obj.put("udit", 109);
        obj.put("susmita", 78);
        obj.put("ujjwal", 189);
        obj.put("neeraj", 75);
        obj.put("jaya", 567);
        obj.put("suchitra", 45);
        obj.put("ankit", 47);
        obj.put("yasha", 999);
        obj.put("shikha", 234);
        obj.print();

        System.out.println("Got : " + obj.get("udit"));
        System.out.println("Got : " + obj.get("yasha"));
        System.out.println("Got : " + obj.get("shikha"));
        System.out.println("Got : " + obj.get("neeraj"));
        System.out.println("Got : " + obj.get("suchitra"));

    }
}
