/**
 * Created by uditmehrotra on 24/12/14.
 */
public class PriorityQueueOrdered<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public PriorityQueueOrdered(Key[] arr)
    {
        keys = (Key[]) new Comparable[arr.length];
        N = arr.length-1;
        for(int i = 0; i < N; i++)
            keys[i] = arr[i];
    }

    public PriorityQueueOrdered(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
    }

    private boolean isEmpty()
    {
        return N == 0;
    }

    private void insert(Key k)
    {
        for(int i = 0; i < N; i++)
        {
            if(less(k,keys[i]))
            {
                for(int j = N-1; j >= i; j--)
                {
                    keys[j+1] = keys[j];
                }
                keys[i] = k;
                N++;
                return;
            }
        }

        keys[N++] = k;
    }

    private Key delMax()
    {
        return keys[--N];
    }

    private boolean less(Key i, Key j)
    {
        return i.compareTo(j) < 0;
    }

    private void exch(int i, int j)
    {
        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    private void print()
    {
        System.out.println("Queue elements : ");
        for(int i = 0; i < N; i++)
        {
            System.out.println(keys[i]);
        }
    }

    public static void main(String[] args)
    {
        PriorityQueueOrdered<Integer> pq = new PriorityQueueOrdered<Integer>(20);
        pq.insert(100);
        pq.insert(56);
        pq.insert(88);
        pq.insert(78);
        pq.insert(67);
        pq.insert(55);
        pq.insert(106);
        pq.insert(678);
        pq.insert(678);
        pq.insert(98);

        pq.print();

        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());

        pq.print();

    }
}
