#include <iostream>
#include <stdio.h>
#include "LinkedList.h"

using namespace std;

Node::Node() {
    item = NULL;
};

bool Node::isEmpty() {
    return first == NULL;
};