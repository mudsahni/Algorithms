//
//  quick_union.cpp
//  matrix
//
//  Created by Mudit Sahni on 12/04/19.
//  Copyright © 2019 Mudit Sahni. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

vector <int> id = {0,1,2,3,4,5,6,7,8,9,10};

int root(int i) {
    while(i!=id[i]){
        i = id[i];
    };
    return i;
};

bool connected(int p, int q) {
    return root(p) == root(q);
};

void union_(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
};

int main() {
    cout<<"2==3? "<<connected(2,3)<<endl;
    cout<<"Creating a union between 2 and 3."<<endl;
    union_(2,3);
    cout<<"2==3? "<<connected(2,3)<<endl;
    cout<<"3==7? "<<connected(3,7)<<endl;
    cout<<"2==7? "<<connected(2,7)<<endl;
    cout<<"Creating a union between 3 and 7."<<endl;
    union_(7,3);
    cout<<"3==7? "<<connected(3,7)<<endl;
    cout<<"2==7? "<<connected(2,7)<<endl;
    return 0;
}

