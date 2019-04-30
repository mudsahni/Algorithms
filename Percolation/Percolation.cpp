#include <iostream>
#include <stdio.h>
#include <vector>
#include <cstdlib>
#include <tuple>

using namespace std;

vector < vector <int> > genArrays(int size, int prob){
    vector < vector <int> > grid (size, vector <int> (size, 0)); 

    int rn = 0;
    for(int row = 0; row<size; row++){
        for(int col= 0; col<size; col++){
            rn = rand()%100;
            if(rn > prob){
                grid[row][col] = 0;
            }
            else {
                grid[row][col] = 1;
            };
        };
    };
    return grid;
};

void _flow(vector < vector <int> > isFull, vector < vector <int> > isOpen, int i, int j, int size){
    if(i<0 || i>=size) {return;};
    if(j<0 || j>=size) {return;};
    if(isOpen[i][j] == 0) {return;};
    if(isFull[i][j] != 0) {return;};

    isFull[i][j] = 1;
    _flow(isFull, isOpen, i+1, j, size);
    _flow(isFull, isOpen, i, j+1, size);
    _flow(isFull, isOpen, i, j-1, size);
    _flow(isFull, isOpen, i-1, j, size);
    
}

vector < vector <int> > flow(vector < vector <int> > isFull, vector < vector <int> > isOpen, int size){
    for(int j = 0; j<size; j++){
        _flow(isFull, isOpen, 0, j, size);
    };
    return isFull;
};

bool percolates(vector < vector <int> > isOpen, int size) {
    //create isFull array - initialize it with zeros
    vector < vector <int> > isFull (size, vector <int> (size, 0));
    for(int row = 0; row < size; row++){
        for(int col =0; col < size; col++){
            isFull[row][col] = 0;
        };
    };

    isFull = flow(isFull, isOpen, size);
    for(int j=0; j<size; j++){
        if(isFull[size-1][j]==1){
            return 1;
        };
    };
    return 0;

};


int main(){
    int size = 10;
    int prob = 80;
    vector < vector <int> > g = genArrays(size, prob);
    vector < vector <int> > isOpen = g;
    
    //print the grid
    for(int i = 0; i<10; i++){
        for(int j =0; j<10; j++){
            cout<<g[i][j]<<" ";
        };
        cout<<endl;
    };

    int ans = percolates(isOpen, size);
    cout<<ans<<endl;
};