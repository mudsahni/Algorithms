public class InsertionSort {

    public void sort(int[] A) {
        int key;
        int i;
        for(int j = 0; j<A.length; j++) {
            key = A[j];
            i = j - 1;
            while(i >= 0 && A[i] > key) {
                A[i+1] = A[i];
                i-= 1;
            }
            A[i+1] = key;
        }
    };

    public static void main (String args[]) {
        InsertionSort IS = new InsertionSort();
        int[] A = {5,7,4,2,3,0,6,9,1,8};
        IS.sort(A);
        for(int x = 0; x<A.length; x++) {
            System.out.println(A[x]);
        }

    };
}
