/**
 * Created by uditmehrotra on 24/12/14.
 */
public class ThreeWayQuickSort
{

    private void sort(Comparable[] arr, int low, int high)
    {
        if(low < high)
        {
            int lt = low, i = low, gt = high;
            Comparable v = arr[low];

            while(i <= gt)
            {
                int cmp = arr[i].compareTo(v);
                if(cmp < 0)
                {
                    exch(arr,lt++,i++);
                }
                else if(cmp > 0)
                {
                    exch(arr,gt--,i);
                }
                else
                {
                    i++;
                }
            }

            sort(arr,low,lt-1);
            sort(arr,gt+1, high);
        }
    }

    private void sort(Comparable[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }

    private void exch(Comparable[] arr, int x, int y)
    {
        Comparable temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args)
    {
        Integer arr[] = {100,50,200,36,89,23,66,134,13,456,789,987,235,234,34,36,34,56,11,19,80,101,123,45,67,33,21,34};

        ThreeWayQuickSort qs = new ThreeWayQuickSort();
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
