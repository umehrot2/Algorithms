/**
 * Created by uditmehrotra on 21/12/14.
 */
public class StackLinkedList
{

    private Node first = null;

    private class Node
    {
        int item;
        Node next;
    }

    private boolean isEmpty()
    {
        if(first == null)
            return true;

        return false;
    }

    private void push(int item)
    {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
    }

    private int pop()
    {
        if(!isEmpty())
        {
            int item = first.item;
            first = first.next;
            return item;
        }

        return -9999;
    }

    public static void main(String[] args)
    {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(78);
        stack.push(45);
        stack.push(33);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
