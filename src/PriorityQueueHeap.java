/**
 * This is an implementation of Priority Queue using Binary Heap data structure
 */
public class PriorityQueueHeap<Key extends Comparable<Key>> {

    private Key[] heap;
    private int N;

    public PriorityQueueHeap(int capacity)
    {
        heap = (Key[]) new Comparable[capacity + 1];
    }

    private boolean less(Key x, Key y)
    {
        return x.compareTo(y) < 0;
    }

    private void exch(int x, int y)
    {
        Key temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    private void swim()
    {
        int k = N;
        while(k > 1)
        {
            if(less(heap[k/2], heap[k]))
            {
                exch(k/2,k);
                k = k / 2;
            }
            else
            {
                break;
            }
        }
    }

    private void insert(Key item)
    {
        heap[++N] = item;
        swim();
    }

    private void sink()
    {
        int k = 1;
        while(2*k <= N)
        {
            int j = 0;
            if(less(heap[k], heap[2*k]))
            {
                j = 2*k;
            }

            if((2*k + 1) <= N)
            {
               if(less(heap[2*k],heap[2*k + 1]) && less(heap[k],heap[2*k+1]))
               {
                  j = 2*k + 1;
               }
            }

            if(j > 0) {
                exch(k, j);
                k = j;
            }
            else
                break;
        }
    }

    private Key delete()
    {
        exch(1, N);
        Key item = heap[N];
        heap[N--] = null;
        sink();
        return item;
    }

    private void print()
    {
        System.out.println("\nCurrent Heap : ");
        for(int i = 1; i <= N; i++)
            System.out.print(heap[i] + " ");
    }

    public static void main(String[] args)
    {
        PriorityQueueHeap pq = new PriorityQueueHeap(100);
        pq.insert(100);
        pq.print();

        pq.insert(50);
        pq.print();

        pq.insert(200);
        pq.print();

        pq.insert(500);
        pq.print();

        pq.insert(600);
        pq.print();

        pq.insert(123);
        pq.print();

        pq.insert(345);
        pq.print();

        pq.insert(45);
        pq.print();

        pq.insert(67);
        pq.print();

        pq.insert(34);
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();

        System.out.println("\nDeleted item : " + pq.delete());
        pq.print();
    }
}
