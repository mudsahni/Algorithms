/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class QuickUnion {
    private int[] id;

    public void genArray(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String args[]) {
        QuickUnion ob = new QuickUnion();
        ob.genArray(10);
        System.out.println("2==3?" + ob.connected(2, 3));
        System.out.println("Creating a union between 2 and 3.");
        ob.union(2, 3);
        System.out.println("2==3?" + ob.connected(2, 3));
        System.out.println("3==7?" + ob.connected(3, 7));
        System.out.println("2==7?" + ob.connected(2, 7));
        System.out.println("Creating a union between 2 and 7.");
        ob.union(2, 7);
        System.out.println("2==7?" + ob.connected(2, 7));
        System.out.println("3==7?" + ob.connected(3, 7));

    }
}

