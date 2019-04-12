
const connected = function(e1,e2,a) { 

    return a[e1] == a[e2];

};

const union = function(e1,e2,a) {
    if(connected(e1,e2,a) == false) {
        let check = a[e1];
        a[e1] = a[e2];
        for(let i=0; i<a.length;i++) {
            if(a[i] == check){
                a[i] = a[e2];
            }
        };
    };
};

let a  = [0,1,2,3,4,5,6,7,8,9,10];
console.log(`2==5? ${connected(2,5,a)}`);
console.log('Creating a union between 2 and 5.')
union(2,5,a);
console.log(`2==5? ${connected(2,5,a)}`);
console.log(`3==5? ${connected(3,5,a)}`);
console.log(`2==3? ${connected(2,3,a)}`);
console.log('Creating a union between 2 and 3.')
union(2,3,a);
console.log(`2==3? ${connected(2,3,a)}`);
console.log(`3==5? ${connected(3,5,a)}`);
