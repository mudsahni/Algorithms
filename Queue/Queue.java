class Node<Item>
{
    private Item item;
    private Node next = null;

    public Node(Item val) {
        item = val;
    };

    public Item getItem()
    {
      return item;
    };

    public void setItem(Item val)
    {
      item = val;
    };

    public Node getNext()
    {
        return next;
    };

    public void setNext(Node node)
    {
      next = node;
    };
};


public class Queue<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    private Node<Item> old;
    private Item item;

    public Queue()
    {
        first = null;
        last = null;

    };

    public boolean isEmpty()
    {
        return first == null;
    };

    public void enqueue(Node node)
    {
        old = last;
        last = node;
        last.setNext(null);

        if(isEmpty() == true)
        {
            first = last;
        }
        else
        {
            old.setNext(last);
        };

    };

    public Item dequeue()
    {
        item = first.getItem();
        first = first.getNext();

        if(isEmpty() == true)
        {
            last = null;
        };

        return item;

    };

    public static void main(String[] args)
    {
      Node<String> X = new Node<String>("X");
      Node<String> Y = new Node<String>("Y");
      Queue<String> Q = new Queue<String>();

      System.out.println("Is Q empty: " + Q.isEmpty());
      System.out.println("Adding to Q");
      Q.enqueue(X);
      System.out.println("Is Q empty: " + Q.isEmpty());
      Q.enqueue(Y);
      System.out.println("First Q node: " + Q.first.getItem());
      System.out.println("Last Q node: " + Q.last.getItem());
      System.out.println("Addin `å  1       g to Q");

      Node<String> Z = new Node<String>("Z");
      Q.enqueue(Z);

//      Item<String> OUT = Q.dequeue();
      System.out.println("Removed item: " + Q.dequeue());

      System.out.println("Last Q node: " + Q.last.getItem());
      System.out.println("First Q node: " + Q.first.getItem());

    };

};
