
public class FixedCapacityStackOfStrings
{
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity)
    {
        s = new String[capacity];
    };

    public boolean isEmpty()
    {
        return N == 0;
    };

    public void push(String item)
    {
        s[N++] = item;
    };

    public String pop()
    {
        String item = s[--N];
        s[N] = null;
        return item;
    };

    public static void main(String[] args)
    {
        FixedCapacityStackOfStrings G = new FixedCapacityStackOfStrings(10);
        System.out.println(G.isEmpty());
        G.push("HELLO");
        System.out.println(G.isEmpty());
        System.out.println(G.pop());
    };
};
