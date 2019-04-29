public class ThreeSum
{

    public static int count(int[] a)
    {
        int N = a.length;
        int count = 0;
        int ans = 0;

        for(int i = 0; i<N; i++)
        {
            for(int j = i+1; j<N; j++)
            {
                for(int k = j+1; k<N; k++)
                {
                    if(a[i] + a[j] + a[k] == 0)
                    {
                        count++;
                        ans = a[i] + a[j] + a[k];
                        System.out.println(a[i]+" + "+a[j]+" + "+a[k]+" = "+ans+" == 0");
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] a = {30,-40,10,20,-20,100,80,-30,-10,50,60};
        int result = count(a);

        System.out.println(result);
    }

}
