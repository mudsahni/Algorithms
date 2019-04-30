#include <iostream>
#include <stdio.h>
#include "Queue.h"

using namespace std;

Node::Node() {
    item = "NULL";
};

Node::Node(string val) {
    item = val;
};

string Node::getItem() {
    return item;
}; 

Node Node::getNext() {
    return *next;
};

void Node::setItem(string val) {
    item = val;
};

void Node::setNext(Node node) {
    next = &node;
};

Queue::Queue() {
    *first = &null;
    first = NULL;

    *last = &null;
    last = NULL;
};

bool Queue::isEmpty() {
    return true;
};

// void Queue::enqueue(Node node) {
//     Node old = last;
//     last = node;
//     last.setNext()
// };
