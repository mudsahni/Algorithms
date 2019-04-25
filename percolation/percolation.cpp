#include <iostream>
#include "percolation.h"
using namespace std;

UnionFind::UnionFind() {
    int n = 10;
    size = n;
}

UnionFind::UnionFind(int n) {
    size = n;
    // for(int i=0;i<size;i++){
    //     id[i] = i;
    // };
    // for(int i=0;i<size;i++){
    //     depth[i] = 1;
    // };
};