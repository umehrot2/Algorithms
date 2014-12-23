import java.util.Iterator;
/**
 * Created by uditmehrotra on 22/12/14.
 */
public class GenericStackArray<Item> implements Iterable<Item>{

    private Item stack[];
    private int top;

    public GenericStackArray()
    {
        stack = (Item[]) new Object[1];
        top = 0;
    }

    private boolean isEmpty()
    {
        if(top == 0)
            return true;

        return false;
    }

    private void push(Item item)
    {
        if(top == stack.length)
            resize(2 * stack.length);

        stack[top++] = item;
    }

    private Item pop()
    {
            Item item = stack[--top];
            stack[top] = null;

            if (top > 0 && top == stack.length / 4)
                resize(stack.length / 2);

            return item;
    }

    private void resize(int capacity)
    {
        Item[] arr = (Item[]) new Object[capacity];

        for(int i = 0; i < top; i++)
            arr[i] = stack[i];

        stack = arr;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>
    {
        private int i = top;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {
            UnsupportedOperationException ex = new UnsupportedOperationException();
            throw ex;
        }
    }

    public static void main(String args[])
    {
        GenericStackArray<Integer> stack = new GenericStackArray<Integer>();
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
