#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int count(vector <int> a){
    int n = a.size();
    int result = 0;
    for(int i = 0; i<n; i++){
        for(int j = i+1; j<n; j++){
            for(int k = j+1; k<n; k++){
                if(a[i] + a[j] + a[k] == 0){
                    result += 1;
                };
            };
        };
    };
    return result;

};

int binary_search_recursive(vector<int> arr, int low, int high, int key)
{
    int mid = 0;

    if (high >= low)
    {
        mid = low + (high - low) / 2;

        if (arr[mid] > key)
        {
            return binary_search_recursive(arr, low, mid - 1, key);
        }
        else if (arr[mid] < key)
        {
            return binary_search_recursive(arr, mid + 1, high, key);
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
int smart_count(vector <int> a){
    int n = a.size();
    int ans;
    int result = 0;
    for(int i =0; i < n; i++){
        ans = binary_search_recursive(a, 0, n-1, -a[i]);
        cout<<"opposite of "<<a[i]<<": "<<ans<<endl;
        if(ans != -1){
            result += 1;
        }
    }
    return result;

}

int main(){
    vector <int> a = {30,-40,10,20,-20,100,80,-30,-10,50,60};
    int result = count(a);
    cout<<result<<endl;

    vector <int> b = {-40,-30,-20,-10,10,20,30,50,60,80,100};
    int ans = smart_count(b);
    cout<<ans<<endl;
};