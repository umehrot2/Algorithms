/**
 * Created by uditmehrotra on 23/12/14.
 */
public class MergeSortBottomUp {

    private void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high)
    {
        int i = low, j = mid+1;

        for(int loop = low; loop <= high; loop++)
        {
            aux[loop] = arr[loop];
        }

        for(int loop = low; loop <= high; loop++)
        {
            if(i > mid)
                arr[loop] = aux[j++];
            else if(j > high)
                arr[loop] = aux[i++];
            else if(less(aux[j],aux[i]))
                arr[loop] = aux[j++];
            else
                arr[loop] = aux[i++];
        }

    }

    private boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private void exch(Comparable[] arr, int x, int y)
    {
        Comparable temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void sort(Comparable[] arr, Comparable[] aux, int low, int high)
    {

        if(low < high)
        {
            int mid = low + (high-low) / 2;
            sort(arr, aux, low, mid);
            sort(arr, aux, mid+1, high);
            merge(arr, aux, low, mid, high);
        }

    }

    private void sort(Comparable[] arr)
    {
        int size = 1;
        while(size < arr.length)
        {
            for (int loop = 0; loop < arr.length; loop=loop+2*size)
            {
                merge(arr,new Comparable[arr.length],loop, loop+size-1,Math.min(loop+2*size-1,arr.length-1));
            }

            size = size * 2;
        }
    }

    public static void main(String[] args)
    {
        Integer arr[] = {100,50,200,36,89,23,66,134,13,456,789,987,235,234,34,36,34,56,11,19,80,1005,7658,433,123};

        MergeSortBottomUp ms = new MergeSortBottomUp();
        ms.sort(arr);

        System.out.println("Sorted Integers : ");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        Date dates[] = {
                new Date(1990, 10, 30),
                new Date(1988, 5, 23),
                new Date(1789, 10, 12),
                new Date(1990, 8, 20),
                new Date(1990, 10, 11),
                new Date(1988, 6, 17),
                new Date(1990, 4, 30)
        };

        ms.sort(dates);

        System.out.println("\nSorted Dates : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }
    }

}
