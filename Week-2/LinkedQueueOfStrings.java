public class LinkedQueueOfStrings
{
    private class Node
    {
        String item;
        Node next;
    }

    private Node first, last;

    public void enqueue(String item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
    }

    String dequeue()
    {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;

    }

    boolean isEmpty()
    { return first == null; }

    int size()
    {
        int num = 0;
        for(Node i = first; i != last; i = first.next)
            num++;
        return num + 1;
    }

    public static void main(String[] argv)
    {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        queue.enqueue("huangyi");
        queue.enqueue("jiahai");
        System.out.println(queue.dequeue());
    }
}