#ifndef LinkedList_h
#define LinkedList_h

#include <string>
using namespace std;

class Node
{   
    private:
        Node* first;
        string item;
        Node* next;
    public:
        //constructors
        Node();

        //isEmpty
        bool isEmpty();

        //push
        // void push(string);

        // //pop
        // string pop();

};

#endif /* LinkedList_h */
