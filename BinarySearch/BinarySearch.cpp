#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int binary_search(vector <int> a, int key)
{
    int low = 0;
    int high = a.size()-1;
    int mid = 0;

    while(low<=high)
    {
        mid = low + (high-low)/2;
        if(key<a[mid])
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
        };
    };
    return -1;
};

int binary_search_recursive(vector <int> arr, int low, int high, int key)
{
    int mid = 0;

    if(high >= low)
    {
        mid = low + (high - low)/2;

        if(arr[mid] > key)
        {
            return binary_search_recursive(arr, low, mid-1, key);
        }
        else if(arr[mid] < key)
        {
            return binary_search_recursive(arr, mid+1, high, key);
        }
        else
        {
            return mid;
        };
    }
    else
    {
        return -1;
    };
    
};


int main()
{
    vector <int> a = {1,2,3,4,10,30,50,100,900};
    int ans1 = binary_search(a, 3);
    int ans2 = binary_search(a, 10);
    int ans3 = binary_search(a, 21);

    cout << "Is 3 in a: " << ans1 << endl;
    cout << "Is 10 in a: " << ans2 << endl;
    cout << "Is 21 in a: " << ans3 << endl;

    int ans4 = binary_search_recursive(a, 0, a.size()-1, 3);
    int ans5 = binary_search_recursive(a, 0, a.size()-1, 10);
    int ans6 = binary_search_recursive(a, 0, a.size()-1, 21);

    cout << "Is 3 in a: " << ans4 << endl;
    cout << "Is 10 in a: " << ans5 << endl;
    cout << "Is 21 in a: " << ans6 << endl;
};