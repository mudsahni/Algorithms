class Node<T>
{
    //instance fields
    private T item;
    private Node<T> next;

    //constructor
    public Node(T value)
    {
        item = value;
        next = null;
    }

    //methods
    public T getItem()
    {
        return item;
    }

    public void setItem(T item)
    {
        item = item;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public void setNext(Node<T> node)
    {
        next = node;
    }

}

class Stack<T>
{
    //instance fields
    private Node<T> first;

    //constructor
    public Stack()
    {
        first = null;
    }

    //methods
    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(T item)
    {
        Node<T> oldFirst = first;
        first = new Node<T>(item);
//        first.setItem(item);
        first.setNext(oldFirst);
    }

    public T pop()
    {
        T item = first.getItem();
        first = first.getNext();
        return item;
    }
}

public class TwoStack<T> {

    public static void main(String[] args) {
        //declaring the two stacks
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        String s;
        String op;
        double ans;
        double p;

        String example = "(1+((2+3)*(4*5)))";
        String[] ex = example.split("");

        for (int i = 0; i < ex.length; i++) {
            s = ex[i];
            if (s.equals("("))
            {

            }

            else if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%"))
            {
                operators.push(s);
            }

            else if(s.equals(")"))
            {
             op = operators.pop();
             if(op.equals("+"))
             {
                 values.push(values.pop() + values.pop());
             }
             else if(op.equals("*"))
             {
                 values.push(values.pop() * values.pop());
             }
            }

            else
            {
                values.push(Double.parseDouble(s));
            }
        }

        ans = values.pop();

        System.out.println(ans);

    }
}
