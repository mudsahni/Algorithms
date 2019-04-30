#include <iostream>
#include <stdio.h>
#include "LinkedList.h"

using namespace std;

Node::Node() {
    item = "";
    Node first = NULL;;
    Node next = NULL;;
};

string Node::showItem() { 
    return item;
};

bool Node::isEmpty() {
    return first == NULL;
};

// void Node::push(string item) {
//     Node* old_first = first;
//     first.item = item;
//     first.next -> old_first;
// };