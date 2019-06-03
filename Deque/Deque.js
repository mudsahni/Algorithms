class Node {
    constructor(item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    };
};

class Deque {
    constructor() {
        this.first = null;
        this.last = null;
    };

    isEmpty() {
        return this.first == null && this.last == null;
    };

    size() {
        if(this.isEmpty() == true) {
            return 0;
        }
        else {
            let counter = 0;
            let temp = this.first;
            while(true){
                if(temp != null) {
                    counter = counter + 1;
                    temp = temp.next;
                }
                else {
                    break
                }
            }
            return counter;
        }
    };

    addFirst(node) {
        let old_first = this.first;
        this.first = node;
        this.first.prev = null;
        if(this.last == null) {
            this.last = this.first;
        }
        else {
            this.first.next = old_first;
            old_first.prev = this.first;
        }
    };

    addLast(node) {
        let old_last = this.last;
        this.last = node;
        this.last.next = null;
        if(this.first == null) {
            this.first = this.last;
        }
        else {
            old_last.next = this.last;
            this.last.prev = old_last;
        }
    };

    removeFirst() {
        let item = this.first.item;
        this.first = this.first.next;
        this.first.prev = null;
        return item;
    };

    removeLast() {
        let item = this.last.item;
        this.last = this.last.prev;
        this.last.next = null;
        return item;
    };
}

let X = new Node("X");
let Y = new Node("Y");
let Z = new Node("Z");
let D = new Deque();
console.log(`Size of D: ${D.size()}`);
D.addFirst(X);
console.log(`Size of D: ${D.size()}`);
console.log(`First node of D: ${D.first.item}`);
D.addFirst(Y);
console.log(`Size of D: ${D.size()}`);
console.log(`First node of D: ${D.first.item}`);
console.log(`Last node of D: ${D.last.item}`);
D.addLast(Z);
console.log(`Size of D: ${D.size()}`);
console.log(`First node of D: ${D.first.item}`);
console.log(`Last node of D: ${D.last.item}`);

console.log(`Next for first: ${D.first.next.item}`);
console.log(`Previous for last: ${D.last.prev.item}`);

let last_item = D.removeLast();
console.log(`Last node removed: ${last_item}`);
console.log(`New last node: ${D.last.item}`);

let first_item = D.removeFirst();
console.log(`First node removed: ${first_item}`);
console.log(`New first node: ${D.first.item}`);
