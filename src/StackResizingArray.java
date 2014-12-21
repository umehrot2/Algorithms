/**
 * Created by uditmehrotra on 21/12/14.
 */
public class StackResizingArray {

    private int stack[];
    private int top;

    public StackResizingArray()
    {
        stack = new int[1];
        top = 0;
    }

    private boolean isEmpty()
    {
        if(top == 0)
            return true;

        return false;
    }

    private void push(int item)
    {
        if(top == stack.length)
            resize(2 * stack.length);

        stack[top++] = item;
    }

    private int pop()
    {
        if(!isEmpty()) {
            int item = stack[--top];
            stack[top] = -999;
            if (top > 0 && top == stack.length / 4)
                resize(stack.length / 2);

            return item;
        }
        else
        {
            return -9999;
        }
    }

    private void resize(int capacity)
    {
        int[] arr = new int[capacity];

        for(int i = 0; i < top; i++)
            arr[i] = stack[i];

        stack = arr;
    }

    public static void main(String args[])
    {
        StackResizingArray stack = new StackResizingArray();
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
        System.out.println(stack.pop());
    }


}
