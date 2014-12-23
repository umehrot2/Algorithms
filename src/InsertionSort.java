/**
 * Created by uditmehrotra on 22/12/14.
 */
public class InsertionSort {

    private void sort(Comparable[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(less(arr[j], arr[j-1]))
                {
                    exch(arr,j,j-1);
                }
                else
                {
                    break;
                }
            }
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

    public static void main(String args[])
    {
        Integer arr[] = {100,50,200,36,89,23,66,134,13,456,789,987,235,234,34,36,34,56,11,19,80};

        InsertionSort ss = new InsertionSort();
        ss.sort(arr);

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

        ss.sort(dates);

        System.out.println("\nSorted Dates : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }

    }
}
