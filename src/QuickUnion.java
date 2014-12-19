/**
 * Created by uditmehrotra on 20/12/14.
 */
public class QuickUnion {

    private int arr[];

    public QuickUnion(int n)
    {
        arr = new int[n];
        for(int loop = 0; loop < n; loop++)
        {
            arr[loop] = loop;
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

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);

        arr[i] = j;
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

        QuickUnion uf = new QuickUnion(n);


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
