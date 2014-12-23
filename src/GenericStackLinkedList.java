import java.util.Iterator;
/**
 * Created by uditmehrotra on 22/12/14.
 */
public class GenericStackLinkedList<Item> implements Iterable<Item>{

    private Node first = null;

    private class Node
    {
        Item item;
        Node next;
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    public void push(Item item)
    {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>
    {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
           UnsupportedOperationException ex = new UnsupportedOperationException();
           throw ex;
        }
    }

    public static void main(String[] args)
    {
        GenericStackLinkedList<Integer> stack = new GenericStackLinkedList<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(78);
        stack.push(45);
        stack.push(33);

        System.out.println("Iterating through the items : ");
        Iterator<Integer> i = stack.iterator();
        while(i.hasNext())
        {
            int num = i.next();
            System.out.println(num);
        }

        System.out.println("Popping the items : ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(85);
        stack.push(53);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
