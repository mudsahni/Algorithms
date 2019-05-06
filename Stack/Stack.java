public class Stack<Item>
{
    private Node first = null;

    private class Node
    {
        Item item;
        Node next;
    };

    public boolean isEmpty()
    {
        return first == null;
    };

    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    };

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    };

    public static void main(String[] args)
    {
        Stack<String> test = new Stack<String>();
        test.push("Hello World!");
        test.push("Crap bag");
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
        System.out.println(test.pop());
        System.out.println(test.isEmpty());
    };

}
