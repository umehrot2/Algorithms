/**
 * Created by uditmehrotra on 23/12/14.
 */
public class QuickSort {

    private int partition(Comparable[] arr, int low, int high)
    {

        int i = low+1, j = high;
        while(true)
        {
            while(less(arr[i],arr[low])) {
                i++;
                if(i == high) break;
            }

            while(less(arr[low],arr[j]))
            {
                j--;
                if(j == low) break;
            }

            if(i < j)
                exch(arr,i,j);
            else
                break;

        }

        exch(arr,low,j);
        return j;

    }

    private void sort(Comparable[] arr, int low, int high)
    {

        if(low < high)
        {
            int par = partition(arr,low,high);
            sort(arr, low, par-1);
            sort(arr, par+1, high);
        }

    }

    private void exch(Comparable[] arr, int x, int y)
    {
        Comparable temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private void sort(Comparable[] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    public static void main(String[] args)
    {
        Integer arr[] = {45,23,10,56,90,66,78,34,567,78,234,123, 1, 15, 6 ,9};

        QuickSort qs = new QuickSort();
        qs.sort(arr);

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
                new Date(1988, 6, 17)
        };

        qs.sort(dates);

        System.out.println("\nSorted Dates : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }
    }
}
