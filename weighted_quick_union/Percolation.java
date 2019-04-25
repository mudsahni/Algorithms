
import java.util.Random;


public class Percolation {

    private int size;
    private int[] id;
    private int[] depth;
    private int[][] grid;
    private boolean[][] isOpen;

    public void genArrays(int n, int prob) {
        size = n;
        id = new int[n];
        depth = new int[n];
        grid =  new int[n][n];
        isOpen = new boolean[n][n];

        int rn = 0;

        //id and depth
        for(int i =0;i<n;i++){
            id[i] = i;
            depth[i] = 1;
        }

        //grid
        int[] temp;
        for(int row=0;row<n;row++){
            temp = new int[n];
            for(int col=0;col<n;col++){
                int rn = new Random().nextInt(2);
                if(rn>prob){
                    rn = 0;
                }
                else {
                    rn = 1;
                }
                temp[col] = rn;
            }
            grid[row] = temp;
        }

        //isOpen
        for(int row =0;row<n;row++){
            temp = new int[n];
            for(int col =0; col<n; col++){
                if(grid[row][col] == 1){
                    temp[col] = true;
                }
                else{
                    temp[col] = false;
                }
            }
            isOpen[row][col] = temp;
        }


    }

    public int find(int p) {
        while (p!= id[p]){
            p = id[p];
        }
        return p;

    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) {
            return;
        }

        if(depth[rootP] < depth[rootQ]){
            id[rootP] = rootQ;
            depth[rootQ] += depth[rootP];
        }

        else {
            id[rootQ] = rootP;
            depth[rootP] += rootQ;
        }

    }

    public void _flow(int[] isFull, int i, int j) {
        if(i < 0 || i >= size) return;
        if(j < 0 || j >= size) return;
        if(isOpen[i][j] == false) return;
        if(isFull[i][j] != 0) return;

        isFull[i][j] = 1;

        _flow(isFull, i+1, j);
        _flow(isFull, i-1, j);
        _flow(isFull, i, j+1);
        _flow(isFull, i, j-1);
    }

    public int[][] flow() {
        int[][] isFull;

        for(int x = 0; x<size; x++){
            for(int y = 0; y<size; y++){
                isFull[x][y] = 0;
            }
        }

        for(int j=0;j<size;j++){
            _flow(isFull, 0, j);
        }

        return isFull;
    }

    public boolean percolates() {
        int[][] isFull = flow();

        for(int j = 0;j<size;j++){
            if(isFull[size-1][j] == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Percolation pf = new Percolation();
        pf.genArrays(100, 0.3);
        boolean result = pf.percolates();
        StdOut.println(result);
    }


}
