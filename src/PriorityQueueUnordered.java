/**
 * Created by uditmehrotra on 24/12/14.
 */
public class PriorityQueueUnordered<Key extends Comparable<Key>>
{
    private Key[] keys;
    private int N;

    public PriorityQueueUnordered(Key[] arr)
    {
        keys = (Key[]) new Comparable[arr.length];
        N = arr.length-1;
        for(int i = 0; i < N; i++)
            keys[i] = arr[i];
    }

    public PriorityQueueUnordered(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
    }

    private boolean isEmpty()
    {
        return N == 0;
    }

    private void insert(Key k)
    {
        keys[N++] = k;
    }

    private Key delMax()
    {
        int max = 0;
        for(int i = 1; i < N; i++)
        {
            if(less(keys[max],keys[i])) max = i;
        }

        exch(max,N-1);
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
        PriorityQueueUnordered<Integer> pq = new PriorityQueueUnordered<Integer>(20);
        pq.insert(100);
        pq.insert(56);
        pq.insert(88);
        pq.insert(78);
        pq.insert(67);
        pq.insert(55);
        pq.insert(106);
        pq.insert(678);
        pq.insert(98);

        pq.print();

        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());
        System.out.println("Deleted Item : " + pq.delMax());

    }
}
