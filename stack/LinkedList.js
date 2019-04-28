
class Node{
    constructor() {
        this.first = null;
        this.item = null;
        this.next = null;
    };

    isEmpty(){
        return this.first == null;
    };

    push(item){
        this.old_first = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = this.old_first;
    };

    pop(){
        this.item = this.first.item;
        this.first = this.first.next;
        return this.item;
    };
};

let F = new Node();
console.log(`Is F empty: ${F.isEmpty()}`);
console.log("Pushing something to F.");
F.push("Hello World!");
console.log(`Is F empty: ${F.isEmpty()}`);
let popped_item = F.pop();
console.log(`Popped item: ${popped_item}`);
console.log("Pushing something to F.");
F.push("Bye World!");
console.log(`Is F empty: ${F.isEmpty()}`);
popped_item = F.pop();
console.log(`Popped item: ${popped_item}`);
console.log(`Is F empty: ${F.isEmpty()}`);
