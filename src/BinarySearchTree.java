import java.util.Queue;
import java.util.Iterator;
/**
 * Created by uditmehrotra on 27/12/14.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>
{

    private Node root = null;

    private class Node
    {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value value)
        {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    private void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value)
    {
        if(node == null)
        {
            return new Node(key, value);
        }
        else if(key.compareTo(node.key) < 0)
        {
            node.left = put(node.left, key, value);
        }
        else if(key.compareTo(node.key) > 0)
        {
            node.right = put(node.right, key, value);
        }
        else if(key.compareTo(node.key) == 0)
        {
            node.value = value;
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Value get(Key key)
    {

        Node node = root;
        while(node != null)
        {
            if(node.key.compareTo(key) == 0)
            {
                return node.value;
            }
            else if(key.compareTo(node.key) < 0)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }

        return null;

    }

    private Node floor(Node node, Key key)
    {
        if(node == null) return null;

        if(node.key.compareTo(key) == 0)
            return node;

        if(key.compareTo(node.key) < 0)
            return floor(node.left, key);

        Node temp = floor(node.right, key);
        if(temp != null) return temp;
        return node;
    }

    private Key floor(Key key)
    {
       Node x = floor(root, key);

       if(x == null) return null;

       return x.key;
    }

    private Node ceiling(Node node, Key key)
    {
        if(node == null) return null;

        if(node.key.compareTo(key) == 0)
            return node;

        if(key.compareTo(node.key) > 0)
            return ceiling(node.right, key);

        Node temp = ceiling(node.left, key);
        if(temp != null) return temp;
        return node;
    }

    private Key ceiling(Key key)
    {
        Node x = ceiling(root, key);

        if(x == null) return null;

        return x.key;
    }

    private int size(Node node)
    {
        if(node == null) return 0;

        return node.count;
    }

    private int size()
    {
        return size(root);
    }

    private int rank(Node node, Key key)
    {
        if(node == null) return 0;

        if(key.compareTo(node.key) == 0)
            return size(node.left);

        if(key.compareTo(node.key) < 0)
            return rank(node.left, key);

        return 1 + size(node.left) + rank(node.right, key);
    }

    private int rank(Key key)
    {
        return rank(root, key);
    }

    private void preorder(Node node)
    {
        if(node != null)
        {
            System.out.print(node.key + "," + node.value + "   ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    private Iterable<Key> keys()
    {
        QueueLinkedList<Key> q = new QueueLinkedList<Key>();
        inorder(q, root);
        return q;
    }

    private void inorder(QueueLinkedList<Key> q, Node node)
    {
        if(node == null) return;
        inorder(q, node.left);
        q.enqueue(node.key);
        inorder(q, node.right);
    }

    private void delete_max()
    {
        root = delete_max(root);
    }

    private Node delete_max(Node node)
    {
        if(node.right == null) return node.left;

        node.right = delete_max(node.right);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private void delete_min()
    {
        root = delete_min(root);
    }

    private Node delete_min(Node node)
    {
        if(node.left == null) return node.right;

        node.left = delete_min(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private void delete(Key key)
    {
       root = delete(root, key);
    }

    private Key min()
    {
       return min(root).key;
    }

    private Node min(Node node)
    {
        if(node == null) return null;
        if(node.left == null) return node;

        return min(node.left);
    }

    private Node delete(Node node, Key key)
    {
        if(node == null) return null;

        if(key.compareTo(node.key) < 0)
            node.left = delete(node.left, key);

        else if(key.compareTo(node.key) > 0)
            node.right = delete(node.right, key);

        else if(key.compareTo(node.key) == 0)
        {
            if(node.right == null) return node.left;

            Node temp = node;
            node = min(node.right);
            node.right = delete_min(temp.right);
            node.left = temp.left;
        }

        node.count = 1 + size(node.right) + size(node.left);
        return node;
    }


    public static void main(String[] args)
    {
        BinarySearchTree<String,Integer> bst = new BinarySearchTree<String, Integer>();
        bst.put("udit", 10);
        bst.put("jaya", 80);
        bst.put("neeraj", 56);
        bst.put("ujjwal", 67);
        bst.put("suchitra", 45);
        bst.put("ankit", 34);
        bst.put("akshat", 99);
        bst.put("shikha", 56);
        bst.put("neeraj", 156);
        bst.put("ujjwal", 267);
        bst.preorder(bst.root);

        System.out.println("\nGot : " + bst.get("udit"));
        System.out.println("Got : " + bst.get("ankit"));
        System.out.println("Got : " + bst.get("neeraj"));
        System.out.println("Got : " + bst.get("suchitra"));

        System.out.println("Floor : " + bst.floor("ud"));
        System.out.println("Floor : " + bst.floor("anki"));
        System.out.println("Floor : " + bst.floor("neeraja"));
        System.out.println("Floor : " + bst.floor("suchitrahhh"));
        System.out.println("Floor : " + bst.floor("zafar"));
        System.out.println("Floor : " + bst.floor("aa"));

        System.out.println("Ceiling : " + bst.ceiling("ud"));
        System.out.println("Ceiling : " + bst.ceiling("anki"));
        System.out.println("Ceiling : " + bst.ceiling("neeraja"));
        System.out.println("Ceiling : " + bst.ceiling("suchitrahhh"));
        System.out.println("Ceiling : " + bst.ceiling("zafar"));

        System.out.println("Size : " + bst.size());

        System.out.println("\nRank : " + bst.rank("udit"));
        System.out.println("Rank : " + bst.rank("ankit"));
        System.out.println("Rank : " + bst.rank("neeraj"));
        System.out.println("Rank : " + bst.rank("suchitra"));
        System.out.println("Rank : " + bst.rank("shyam"));
        System.out.println("Rank : " + bst.rank("zafar"));

        System.out.println("Keys Iterator : ");
        Iterator<String> it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }


        bst.delete_max();
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        bst.delete_max();
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        System.out.println("\nMinimum : " + bst.min());

        bst.delete_min();
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        System.out.println("\nMinimum : " + bst.min());

        bst.delete_min();
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        System.out.println("\nMinimum : " + bst.min());

        bst.delete("shikha");
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        bst.delete("jaya");
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        bst.delete("suchitra");
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }

        bst.delete("neeraj");
        System.out.println("\nKeys Iterator : ");
        it = bst.keys().iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + "   ");
        }




    }
}
