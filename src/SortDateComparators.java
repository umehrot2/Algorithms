import java.util.Comparator;
/**
 * Created by uditmehrotra on 23/12/14.
 */
public class SortDateComparators {

    private void sort(Object[] arr, Comparator c)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(less(c, arr[j], arr[j-1]))
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

    private boolean less(Comparator c, Object x, Object y)
    {
        return c.compare(x,y) < 0;
    }

    private void exch(Object[] arr, int x, int y)
    {
        Object temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String args[])
    {
        /*
        Integer arr[] = {100,50,200,36,89,23,66,134,13,456,789,987,235,234,34,36,34,56,11,19,80};

        InsertionSort ss = new InsertionSort();
        ss.sort(arr);

        System.out.println("Sorted Integers : ");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }*/

        SortDateComparators ss = new SortDateComparators();

        Date dates[] = {
                new Date(1990, 12, 30),
                new Date(1998, 5, 23),
                new Date(1789, 10, 12),
                new Date(1990, 8, 20),
                new Date(1990, 11, 11),
                new Date(1988, 6, 17)
        };

        ss.sort(dates, Date.BY_YEAR);

        System.out.println("\nSorted Dates by year : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }

        ss.sort(dates, Date.BY_MONTH);

        System.out.println("\nSorted Dates by month : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }

        ss.sort(dates, Date.BY_DAY);

        System.out.println("\nSorted Dates by day : ");
        for(int i = 0; i < dates.length; i++)
        {
            dates[i].print();
        }

    }
}
