public class LinkedStackOfStrings
{
    //initializing an empty instance of Node class
    private Node first = null;

    private class Node
    {
        //constructor properties of Node class
        //item is the String value for the instance of Node class
        String item;
        //next is the instance of node class linked for this instance
        Node next;
    }

    //if there are any node instances
    public boolean isEmpty()
    {
        return first == null;
    }


    //append node instance to linkedlist (lifo)
    public void push(String item)
    {
        //first node instance becomes second
        Node oldfirst = first;
        //initialize new empty node instance
        first = new Node();
        //add value for new first node instance
        first.item = item;
        //link new first node instance to second (old first)
        //node instance
        first.next = oldfirst;
    }

    //remove last node instance (lifo)
    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }


    public static void main(String[] args)
    {
        LinkedStackOfStrings test = new LinkedStackOfStrings();
        test.push("Hello World!");
        test.push("Crap bag");
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
    }


}
