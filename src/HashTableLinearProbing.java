/**
 * Created by uditmehrotra on 14/01/15.
 */
public class HashTableLinearProbing<Key, Value>
{

    private int capacity = 10;
    private Key[] keys = (Key[]) new Object[capacity];
    private Value[] values = (Value[]) new Object[capacity];

    private int hash(Key key)
    {
        int hash = key.hashCode();
        return (hash & 0x7fffffff) % capacity;
    }

    private void put(Key key, Value val)
    {
        int hash = hash(key);
        while(keys[hash] != null)
        {
            if(key.equals(keys[hash]))
            {
                values[hash] = val;
                return;
            }
            hash = (hash+1) % capacity;
        }

        keys[hash] = key;
        values[hash] = val;
    }

    private Value get(Key key)
    {
        int hash = hash(key);
        while(keys[hash] != null)
        {

            if(key.equals(keys[hash]))
            {
                return values[hash];
            }

            hash = (hash + 1) % capacity;
        }

        return null;
    }

    public static void main(String[] args)
    {
        HashTableLinearProbing<String, Integer> obj = new HashTableLinearProbing<String, Integer>();
        obj.put("udit", 109);
        obj.put("susmita", 78);
        obj.put("ujjwal", 189);
        obj.put("neeraj", 75);
        obj.put("jaya", 567);
        obj.put("suchitra", 45);
        obj.put("ankit", 47);
        obj.put("yasha", 999);
        obj.put("shikha", 234);
        obj.put("shikha", 2341);
        System.out.println("Got : " + obj.get("udit"));
        System.out.println("Got : " + obj.get("yasha"));
        System.out.println("Got : " + obj.get("shikha"));
        System.out.println("Got : " + obj.get("neeraj"));
        System.out.println("Got : " + obj.get("jaya"));
        System.out.println("Got : " + obj.get("suchitra"));
        System.out.println("Got : " + obj.get("susmita"));
        System.out.println("Got : " + obj.get("ankit"));
        System.out.println("Got : " + obj.get("ankit"));
    }
}
