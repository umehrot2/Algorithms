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

    public void union(int p, int q)
    {
        int i = arr[p];
        int j = arr[q];

        for(int loop = 0; loop < arr.length; loop++)
        {
            if(arr[loop] == i)
            {
                arr[loop] = j;
            }
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

        UnionFind uf = new UnionFind(n);


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
