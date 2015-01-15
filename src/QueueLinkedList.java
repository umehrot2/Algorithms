import java.util.Iterator;

/**
 * Created by uditmehrotra on 22/12/14.
 */
public class QueueLinkedList<Key> implements Iterable<Key>
{

    private Node first = null;
    private Node last = null;

    @Override
    public Iterator<Key> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Key>
    {
        private Node current = first;
        @Override
        public boolean hasNext() {
            if(current != null)
                return true;
            else
                return false;
        }

        @Override
        public Key next() {
            if(current == null) return null;

            Key k = current.item;
            current = current.next;
            return k;
        }

        @Override
        public void remove() {
            UnsupportedOperationException ex = new UnsupportedOperationException();
            throw ex;
        }
    }

    private class Node
    {
        Key item;
        Node next;
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    public void enqueue(Key item)
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

    private Key dequeue()
    {
        if(!isEmpty())
        {
            Key item = first.item;
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
        QueueLinkedList<String> queue = new QueueLinkedList<String>();
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
