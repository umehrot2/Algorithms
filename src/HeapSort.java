/**
 * Created by uditmehrotra on 24/12/14.
 */
public class HeapSort
{

    private void sink(Comparable[] arr, int k, int N)
    {
        while(2*k <= N)
        {
            int j = 0;
            if(less(arr[k],arr[2*k]))
                j = 2*k;

            if((2*k + 1) <= N)
            {
                if(less(arr[2*k],arr[2*k+1]) && less(arr[k],arr[2*k+1]))
                {
                    j = 2*k + 1;
                }
            }

            if(j > 0) {
                exch(arr, k, j);
                k = j;
            }
            else
                break;
        }
    }

    private boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private void exch(Comparable arr[], int x, int y)
    {
        Comparable temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void constructHeap(Comparable[] arr)
    {
        int N = arr.length-1;
        int k = N/2;

        while( k >= 1)
        {
            sink(arr, k, N);
            k--;
        }
    }

    private void heap_sort(Comparable[] arr)
    {
        int N = arr.length - 1;
        while(N > 1)
        {
            exch(arr, 1, N);
            N--;
            sink(arr, 1, N);
        }
    }

    private void sort(Comparable[] arr)
    {
        constructHeap(arr);
        heap_sort(arr);
    }

    private void print(Integer arr[])
    {
        System.out.println("Heap : ");
        for(int i = 1; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
    }

    public static void main(String[] args)
    {
        Integer arr[] = {0,100,50,200,500,600,34,45,67,180,99,101,123,456,76,88,94,145,678,123,101};

        HeapSort hs = new HeapSort();
        hs.sort(arr);
        hs.print(arr);
    }

}
