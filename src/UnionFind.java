/**
 * Created by uditmehrotra on 20/12/14.
 */
public class UnionFind {

    int arr[];

    private UnionFind(int n)
    {
        arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = i;
        }
    }

    public boolean connected(int p, int q)
    {
        if(arr[p] == arr[q])
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        int n;

        if(args[0] != null)
        {
            n = Integer.parseInt(args[0]);
        }
        else
        {
            n = 10;
        }

        UnionFind uf = new UnionFind(n);

    }
}
