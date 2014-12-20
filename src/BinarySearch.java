import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Created by uditmehrotra on 21/12/14.
 */
public class BinarySearch {

    private int[] arr;

    public BinarySearch(int size)
    {
        arr = new int[size];
    }

    private void insert(int index, int num)
    {
        arr[index] = num;
    }

    private void sort()
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int low = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[low] > arr[j])
                {
                    low = j;
                }
            }

            if(low != i) {
                arr[low] = arr[low] + arr[i];
                arr[i] = arr[low] - arr[i];
                arr[low] = arr[low] - arr[i];
            }
        }
    }

    private boolean search(int num)
    {
        int low = 0, high = arr.length - 1;
        int mid;
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if(num < arr[mid])
            {
                high = mid - 1;
            }
            else if(num > arr[mid])
            {
                low = mid + 1;
            }
            else
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
      int size;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter Size of Array : ");
      size = Integer.parseInt(br.readLine());

      BinarySearch bs = new BinarySearch(size);
      System.out.println(bs.arr.length);
      for(int loop = 0; loop < size; loop++)
      {
          System.out.print("\nEnter a number : ");
          bs.insert(loop, Integer.parseInt(br.readLine()));
      }

      bs.sort();
      int num;
      System.out.println("Enter a number to search : ");
      num = Integer.parseInt(br.readLine());
      System.out.println(bs.search(num));

      System.out.println("Enter a number to search : ");
      num = Integer.parseInt(br.readLine());
      System.out.println(bs.search(num));

      System.out.println("Enter a number to search : ");
      num = Integer.parseInt(br.readLine());
      System.out.println(bs.search(num));

      System.out.println("Enter a number to search : ");
      num = Integer.parseInt(br.readLine());
      System.out.println(bs.search(num));

    }
}
