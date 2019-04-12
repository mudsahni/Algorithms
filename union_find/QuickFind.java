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

public class QuickFind {
    private int[] id;

    public void genArray(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String args[]) {
        QuickFind ob = new QuickFind();
        ob.genArray(10);
        System.out.println("2==3?" + ob.connected(2, 3));
        System.out.println("Creating a union of 2 and 3.");
        ob.union(2, 3);
        System.out.println("2==3?" + ob.connected(2, 3));
        System.out.println("3==5?" + ob.connected(3, 5));
        System.out.println("2==5?" + ob.connected(2, 5));
        System.out.println("Creating a union of 2 and 5.");
        ob.union(2, 5);
        System.out.println("2==5?" + ob.connected(2, 5));
        System.out.println("3==5?" + ob.connected(3, 5));
        
    }

}

