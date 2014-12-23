/**
 * Created by uditmehrotra on 24/12/14.
 */
public class QuickSelection {

    private int partition(Comparable[] arr, int low, int high)
    {
        int i = low+1, j = high;
        while(true)
        {
            while(less(arr[i],arr[low]))
            {
                i++;
                if(i == high) break;
            }

            while(less(arr[low],arr[j]))
            {
                j--;
                if(j == low) break;
            }

            if(i < j) exch(arr,i,j);
            else
                break;
        }

        exch(arr,low,j);
        return j;
    }

    private Comparable Selection(Comparable[] arr, int k)
    {
        int low = 0, high = arr.length -1;
        while(true)
        {
            int j = partition(arr,low,high);
            if(j > k) high = j - 1;
            else if(j < k) low = j + 1;
            else
                break;
        }

        return arr[k];
    }

    private boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private void exch(Comparable[] arr, int i, int j)
    {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[])
    {
        Integer arr[] = {100,50,200,36,89,23,66,134,13,456,789,987,235,234,34,36,34,56,11,19,80};

        QuickSelection qs = new QuickSelection();
        int k = 12;
        int num = (Integer) qs.Selection(arr,k);
        System.out.println(k + "th largest element is : " + num);

        Date dates[] = {
                new Date(1990, 10, 30),
                new Date(1988, 5, 23),
                new Date(1789, 10, 12),
                new Date(1990, 8, 20),
                new Date(1990, 10, 11),
                new Date(1988, 6, 17)
        };
        k = 5;
        Date date = (Date) qs.Selection(dates, k);
        System.out.println(k + "th largest date is : ");
        date.print();
    }
}
