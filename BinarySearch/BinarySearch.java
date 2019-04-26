public class BinarySearch
{
    public static int search(int[] a, int key)
    {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while(low<=high)
        {
            mid = low + (high - low)/2;
            if(key < a[mid])
            {
                high = mid - 1;
            }
            else if(key > a[mid])
            {
                low = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int recursive(int[] a, int low, int high, int key)
    {
        int mid = 0;

        if(high>=low)
        {
            mid = low + (high - low)/2;

            if(a[mid] > key)
            {
                return recursive(a, low, mid-1, key);
            }
            else if(a[mid] < key)
            {
                return recursive(a, mid+1, high, key);
            }
            else
            {
                return mid;
            }

        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int ans1 = recursive(a, 0, a.length-1, 3);
        int ans2 = recursive(a, 0, a.length-1, 10);
        int ans3 = recursive(a, 0, a.length-1, 21);

        System.out.println("Is 3 in array a: "+ans1);
        System.out.println("Is 10 in array a: "+ans2);
        System.out.println("Is 21 in array a: "+ans3);

    }
}
