import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SieveOfEratosthenes {

    public ArrayList<Integer> removeMultiples(int i, int n) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        boolean X = true;
        int count = 0;
        while (X == true) {
            int num = i * i + (count * i);
            if (num < n) {
                array.add(num);
                count = count + 1;
            } else {
                X = false;
            }
            ;
        }
        ;


        return array;
    }

    ;

    public Map<Integer, Boolean> sieve(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Map<Integer, Boolean> a = new HashMap<Integer, Boolean>();

        if (n > 1) {

            for (int x = 2; x < n; x++) {
                a.put(x, true);
            }
            ;

            for (int i = 2; i < Math.round(Math.sqrt(n)) + 1; i++) {
                if (a.get(i) == true) {
                    arr = removeMultiples(i, n);
                    for (int j : arr) {
                        a.put(j, false);
                    }
                    ;
                }
                ;
            }
            ;
            return a;
        }
        ;
        return a;
    }

    ;

    public static void main(String[] args) {

        SieveOfEratosthenes SOE = new SieveOfEratosthenes();
        Map<Integer, Boolean> ans = SOE.sieve(10);
        System.out.println(ans);
    }

    ;

};
