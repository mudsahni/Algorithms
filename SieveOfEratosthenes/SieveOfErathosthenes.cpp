#include <iostream>
#include <stdio.h>
#include <vector>
#include <cmath>
#include <map>

using namespace std;

vector <int> removeMultiples(int i, int n) {
    vector <int> arr;
    bool x = true;
    int count = 0;
    int num;

    while(x==true){
        num = i*i + (count*i);
        if(num<n){
            arr.push_back(num);
            count += 1;
        }
        else {
            x = false;
        };
    };
    return arr;
};

map<int,bool> sieve(int n) {
    map<int, bool> a;
    vector<int> arr;
    if(n>1) {
        for(int i=2; i<n; i++){
            a.insert(pair<int,bool> (i,true));
        };

        for(int j=0;j<round(sqrt(n))+1;j++){
            if(a[j] == true) {
                arr = removeMultiples(j,n);
                for(int k=0;k<arr.size();k++){
                    a[arr[k]] = false;
                };
            };
        };
    };
    return a;
};

int main() {
    map<int,bool> ans = sieve(2000000);
    for(int i = 0; i<ans.size(); i++){
        cout<<i<<" = "<<ans[i]<<endl;
    };

    return 0;
};
