class Node {
    constructor(value){
        this.value = value;
        this.parent = this;
    };

    change_parent(parent) {
        this.parent = parent;
    };

};

const union = function(e1,e2) {
    e1.change_parent(e2);
};

const get_root = function(e1) {
    let p = e1.parent;
    let gp = e1.parent.parent;

    while(p.value != gp.value) {
        p = gp;
        gp = gp.parent;
    };
    return gp.value;
};

const connected = function(e1,e2) {
    return get_root(e1) == get_root(e2);
}

let One = new Node(1);
let Two = new Node(2);
let Three = new Node(3);
let Four = new Node(4);
let Five = new Node(5);
let Six = new Node(6);
let Seven = new Node(7);
let Eight = new Node(8);
let Nine = new Node(9);
let Ten = new Node(10);

console.log("Creating union between Nine and Seven");
union(Nine, Seven);
console.log("Creating union between Seven and Five");
union(Seven, Five);
console.log("Creating union between Five and Three");
union(Five, Three);
console.log("Creating union between Three and One");
union(Three, One);

console.log(`Root parent for Nine: ${get_root(Nine)}`);
console.log("Creating union between Nine and One");
union(Nine, One);
console.log(`Root parent for Nine: ${get_root(Nine)}`);
console.log(`Root parent for Two: ${get_root(Two)}`);
union(Two, Three);
console.log(`Root parent for Two: ${get_root(Two)}`);