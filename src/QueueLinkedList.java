/**
 * Created by uditmehrotra on 22/12/14.
 */
public class QueueLinkedList {

    private Node first = null;
    private Node last = null;

    private class Node
    {
        String item;
        Node next;
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    private void enqueue(String item)
    {
        Node old_last = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty())
        {
           first = last;
        }
        else
        {
            old_last.next = last;
        }
    }

    private String dequeue()
    {
        if(!isEmpty())
        {
            String item = first.item;
            first = first.next;
            if(isEmpty())
                last = null;

            return item;
        }
        else
        {
            return null;
        }

    }

    public static void main(String[] args)
    {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue("Udit UIUC");
        queue.enqueue("Ujjwal");
        queue.enqueue("Neeraj");
        queue.enqueue("Jaya");
        queue.enqueue("Suchitra");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue("Neeraj");
        queue.enqueue("Jaya");
        queue.enqueue("Suchitra");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
