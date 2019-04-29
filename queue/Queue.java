class Node
{
    private String item;
    private Node next = null;

    public Node(String val) {
        item = val;
    };

    public String getItem()
    {
      return item;
    };

    public void setItem(String val)
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


public class Queue
{
    private Node first;
    private Node last;
    private Node old;
    private String item;

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

    public String dequeue()
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
      Node X = new Node("X");
      Node Y = new Node("Y");
      Queue Q = new Queue();

      System.out.println("Is Q empty: " + Q.isEmpty());
      System.out.println("Adding to Q");
      Q.enqueue(X);
      System.out.println("Is Q empty: " + Q.isEmpty());
      Q.enqueue(Y);
      System.out.println("First Q node: " + Q.first.getItem());
      System.out.println("Last Q node: " + Q.last.getItem());

    };

};
