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

int main(){
    vector <int> a = {30,-40,10,20,-20,100,80,-30,-10,50,60};
    int result = count(a);
    cout<<result<<endl;
};