class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> prev;

    public Node(Item val) {
        item = val;
        next = null;
        prev = null;
    }

    ;

    public Item getItem() {
        return item;
    }

    ;

    public void setItem(Item val) {
        item = val;
    }

    ;

    public Node<Item> getNext() {
        return next;
    }

    ;

    public void setNext(Node<Item> node) {
        next = node;
    }

    ;

    public Node<Item> getPrev() {
        return prev;
    }

    ;

    public void setPrev(Node<Item> node) {
        prev = node;
    }

    ;
};

public class Deque<Item> {
    private Node<Item> first;
    private Node<Item> last;

    public boolean isEmpty() {
        return first == null || last == null;
    }

    ;

    public int size() {
        if (isEmpty() == true) {
            return 0;
        } else {
            int counter = 0;
            Node<Item> temp = first;
            while (true) {
                if (temp != null) {
                    counter = counter + 1;
                    temp = temp.getNext();
                } else {
                    break;
                }
                ;
            }
            ;
            return counter;
        }
    }

    ;

    public void addLast(Node<Item> node) {
        Node<Item> old_last = last;
        last = node;
        if (first == null) {
            first = last;
        } else {
            old_last.setNext(last);
            last.setPrev(old_last);
        }
    }

    ;

    public void addFirst(Node<Item> node) {
        Node<Item> old_first = first;
        first = node;
        if (last == null) {
            last = first;
        } else {
            first.setNext(old_first);
            old_first.setPrev(first);
        }

    }

    ;

    public Item removeFirst() {
        Item item = first.getItem();
        first = first.getNext();
        first.setPrev(null);
        return item;
    }

    ;

    public Item removeLast() {
        Item item = last.getItem();
        last = last.getPrev();
        last.setNext(null);
        return item;
    }

    ;

    public static void main(String[] args) {
        Node<String> X = new Node<String>("X");
        Node<String> Y = new Node<String>("Y");
        Node<String> Z = new Node<String>("Z");
        Deque<String> D = new Deque<String>();
        System.out.println("Is D empty: " + D.isEmpty());
        D.addLast(X);
        D.addFirst(Y);
        D.addLast(Z);
        System.out.println("Is D empty: " + D.isEmpty());
        System.out.println("D size: " + D.size());
        System.out.println("First element of D: " + D.first.getItem());
        System.out.println("Last element of D: " + D.last.getItem());
        System.out.println("Second element of D: " + D.first.getNext().getItem());
        System.out.println("Second to last element of D: " + D.last.getPrev().getItem());

        String removed_first = D.removeFirst();
        System.out.println("First removed element: " + removed_first);
        String removed_last = D.removeLast();
        System.out.println("Last removed element: " + removed_last);
        System.out.println("D size: " + D.size());

    }

    ;
};
