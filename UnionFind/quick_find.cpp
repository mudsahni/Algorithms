//
//  quick_union.cpp
//  matrix
//
//  Created by Mudit Sahni on 11/04/19.
//  Copyright © 2019 Mudit Sahni. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

bool find(int e1, int e2, vector <int> a) {
    return a[e1] == a[e2];
};

vector <int> union_(int e1, int e2, vector <int> a) {
    bool match = find(e1,e2,a);
    if (match == 0){
        int check = a[e1];
        a[e1] = a[e2];
        for(int i =0;i<a.size();i++){
            if(a[i] == check) {
                a[i] = a[e2];
            }
        }
    }
    return a;
};

int main() {
    vector <int> c = {0,1,2,3,4,5};
    bool t1 = find(2,3,c);
    cout<<"2==3?"<<t1<<endl;
    cout<<"Creating a union of 2 and 3."<<endl;
    vector <int> g = union_(2,3,c);
    t1 = find(2,3,g);
    cout<<"2==3?"<<t1<<endl;
    bool t2 = find(3,5,g);
    cout<<"3==5?"<<t2<<endl;
    t2 = find(2,5,g);
    cout<<"2==5?"<<t2<<endl;
    cout<<"Creating a union of 2 and 5."<<endl;
    vector <int> h = union_(2,5,g);
    bool t3 = find(2,5,h);
    cout<<"2==5?"<<t3<<endl;
    t2 = find(3,5,h);
    cout<<"3==5?"<<t2<<endl;

};
