/**
 * Created by uditmehrotra on 20/12/14.
 */
public class WeightedQuickUnion
{

    private int arr[];
    private int size[];
    public WeightedQuickUnion(int n)
    {
        arr = new int[n];
        size = new int[n];
        for(int loop = 0; loop < n; loop++)
        {
            arr[loop] = loop;
            size[loop] = 1;
        }
    }

    private int root(int x)
    {
        while(arr[x] != x)
        {
            x = arr[x];
        }

        return x;
    }

    public boolean connected(int p, int q)
    {
        if(root(p) == root(q))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void print()
    {
        System.out.println("Array : " );
        for(int loop = 0; loop < arr.length; loop++)
        {
            System.out.print(arr[loop] + " , ");
        }

        System.out.println("Sizes : " );
        for(int loop = 0; loop < size.length; loop++)
        {
            System.out.print(size[loop] + " , ");
        }
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);

        if(size[i] <= size[j])
        {
            arr[i] = j; //Change the root of the smaller tree to that of the larger tree
            size[j] = size[j] + size[i]; //Only the size of the root of the larger tree changes
        }
        else
        {
            arr[j] = i; //Change the root of the smaller tree to that of the larger tree
            size[i] = size[i] + size[j]; //Only the size of the root of the larger tree changes
        }
    }

    public static void main(String[] args)
    {
        int n;
        if(args.length != 0)
        {
            n = Integer.parseInt(args[0]);
            if(n < 10) n = 10;
        }
        else
        {
            n = 10;
        }

        WeightedQuickUnion uf = new WeightedQuickUnion(n);


        //List of unions on numbers less than 10
        uf.union(1,3);
        uf.union(1,5);
        uf.union(3,4);
        uf.union(5,7);
        uf.union(2,9);

        //Check for connected components
        System.out.println("Checking connected components : ");
        System.out.println(uf.connected(1,3));
        System.out.println(uf.connected(1,4));
        System.out.println(uf.connected(1,7));
        System.out.println(uf.connected(1,8));
        System.out.println(uf.connected(1,9));

        System.out.println("\nApplying union commands\n");
        uf.union(7,8);
        uf.union(8,9);

        System.out.println("Checking connected components after unions : ");
        System.out.println(uf.connected(1,8));
        System.out.println(uf.connected(1,9));
        System.out.println(uf.connected(2,1));
        System.out.println(uf.connected(6,9));
    }

}
