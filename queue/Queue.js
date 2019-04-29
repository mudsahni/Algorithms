class Node {
    constructor(item) {
        this.item = item;
        this.next = null;
    };
};

class Queue {
    constructor() {
        this.first = null;
        this.last = null;
    };

    isEmpty() {
        return this.first == null;
    };

    enqueue(node) {
        let old_last = this.last;
        this.last = node;
        this.last.next = null;
        
        if(this.isEmpty() == true) {
            this.first = this.last;
        }
        else {
            old_last.next = this.last;
        };
    };

    dequeue() {
        item = this.first.item;
        this.first = this.first.next;

        if(this.isEmpty() == true) {
            this.last = null;
        };

        return item;
    };
};

let X = new Node("X");
let Y = new Node("Y");

let Q = new Queue();
console.log(`Is Q empty?: ${Q.isEmpty()}`);
console.log("Append to Q");
Q.enqueue(X);
console.log(`Is Q empty?: ${Q.isEmpty()}`);
console.log("Append to Q");
Q.enqueue(Y);
console.log(`First Q Node: ${Q.first.item}`);
console.log(`Last Q Node: ${Q.last.item}`);
