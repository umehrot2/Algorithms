/**
 * Created by uditmehrotra on 27/12/14.
 */
public class HashTableBinarySearch<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] values;
    private int N;

    private HashTableBinarySearch(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    private void put(Key key, Value value)
    {
        int i = 0;
        for(i = 0; i < N; i++)
        {
            if(key.compareTo(keys[i]) < 0)
            {
                for(int j = N-1; j >= i; j--)
                {
                    keys[j+1] = keys[j];
                    values[j+1] = values[j];
                }
                keys[i] = key;
                values[i] = value;
                N++;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    private Value get(Key key)
    {
        if(keys.length == 0) return null;

        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0)
            return values[i];

        return null;
    }

    private int rank(Key key)
    {
        int low = 0, high = N-1;

        while(low < high)
        {
            int mid = low + (high-low)/2;

            if(key.compareTo(keys[mid]) < 0)
                high = mid - 1;

            else if(key.compareTo(keys[mid]) > 0)
                low = mid + 1;

            else
                return mid;
        }

        return low;
    }

    private void print()
    {
        System.out.print("\nKeys : ");
        for(int i = 0; i < N; i++)
            System.out.print(keys[i] + "  ");

        System.out.print("\nValues : ");
        for(int i = 0; i < N; i++)
            System.out.print(values[i] + "  ");
    }

    public static void main(String[] args)
    {
        HashTableBinarySearch<Integer,String> ht = new HashTableBinarySearch<Integer, String>(100);
        ht.put(10,"udit");
        ht.print();
        ht.put(56,"jaya");
        ht.print();
        ht.put(5,"neeraj");
        ht.print();
        ht.put(89,"ujjwal");
        ht.print();
        ht.put(66,"suchitra");
        ht.print();

        System.out.println("\nGot : " + ht.get(56));
        System.out.println("Got : " + ht.get(5));
        System.out.println("Got : " + ht.get(10));
        System.out.println("Got : " + ht.get(66));
        System.out.println("Got : " + ht.get(90));
    }
}
