const math = require('mathjs')

let removeMultiples = function(i,n) {
    let array = [];
    let x = true;
    let count = 0;
    while(x==true){
        let num = math.pow(i,2) + (count*i);
        if(num<n){
            array.push(num);
            count = count + 1;
        }
        else {
            x = false;
        };
    };
    return array;
};

let sieve = function(n) {
    if(n>1) {
        let a = {};
        for(let i = 2; i<n; i++){
            a[i] = true;
        };
        for(let j = 2; j<math.round(math.sqrt(n))+1;j++) {
            if(a[j] == true) {
                let arr = removeMultiples(j,n);
                for (let k = 0; k < arr.length; k++) {
                    a[arr[k]] = false;
                };
            };
        };
        return a;
    };
};

let nums = sieve(10);
let ans = [];
console.log(Object.keys(nums));
for (let v = 2; v < Object.keys(nums).length; v++) {
    if(nums[v] == true) {
        ans.push(v);
    };
};

console.log(
    ans.reduce((a, b) => a + b, 0)
)

console.log(nums);