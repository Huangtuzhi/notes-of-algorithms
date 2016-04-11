import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
    public Iterator<Item> iterator() 
    {
        return new ListIterator();    
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node
    {
        Item item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] argv)
    {
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("huangyi");
        stringStack.push("jiahai");
        System.out.println(stringStack.pop());

        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(22);
        intStack.push(33);
        intStack.push(44);
        intStack.push(55);

        // Iterator<Integer> iter = intStack.iterator();
        // while (iter.hasNext())
        // {
        //     Integer num = iter.next();
        //     System.out.println(num);
        // }

        for(Integer i: intStack)
            System.out.println(i);
    }
}