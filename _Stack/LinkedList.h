#ifndef LinkedList_h
#define LinkedList_h

#include <string>
using namespace std;

class Node
{   
    private:
        string item;
    public:
        //constructors
        Node();

        //return item
        string showItem();

        //isEmpty
        bool isEmpty();

        //push
        void push(string);

        // //pop
        // string pop();

};

#endif /* LinkedList_h */
