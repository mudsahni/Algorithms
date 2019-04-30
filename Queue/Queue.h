#ifndef Queue_h
#define Queue_h

#include <string>
using namespace std;

class Node
{   
    private:
        string item;
        Node *next;
    public:
        //constructors
        Node();
        Node(string);

        //return item
        string getItem();

        //set item
        void setItem(string);

        //get next
        Node getNext();

        //set next
        void setNext(Node);

};

class Queue
{
    private:
        Node first;
        Node last;
        Node null;
    public:
        //constructors
        Queue();

        //check if there are items
        bool isEmpty();

        //add to queue
        // void enqueue(Node);

        //remove from queue
        // string dequeue();
};

#endif /* Queue_h */
