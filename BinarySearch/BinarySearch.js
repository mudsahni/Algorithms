
let binary_search = function(a, key) {
    let low = 0;
    let high = a.length-1;
    let mid = 0;

    while(low <= high) {
        mid = low + (high - low)/2 >> 0;
        if(key<a[mid]){
            high = mid - 1;
        }
        else if(key > a[mid]){
            low = mid + 1;
        }
        else {
            return mid;
        };
    };
    return -1
};

let binary_search_recursive = function(a, low, high, key) {
    let mid = 0;

    if(high >= low){
        mid = low + (high - low)/2 >> 0;

        if(a[mid] > key) {
            return binary_search_recursive(a, low, mid-1, key);
        }
        else if(a[mid] < key){
            return binary_search_recursive(a, mid+1, high, key);
        }
        else{
            return mid;
        };
    }
    else{
        return -1;
    };

};

let a = [1,2,3,4,5,10,30,50,100,900,1000];
let ans1 = binary_search(a, 3);
let ans2 = binary_search(a, 10);
let ans3 = binary_search(a, 21);

console.log(`Is 3 in a: ${ans1}`);
console.log(`Is 10 in a: ${ans2}`);
console.log(`Is 21 in a: ${ans3}`);

let ans4 = binary_search_recursive(a, 0, a.length - 1, 3);
let ans5 = binary_search_recursive(a, 0, a.length - 1, 10);
let ans6 = binary_search_recursive(a, 0, a.length - 1, 21);

console.log(`Is 3 in a: ${ans4}`);
console.log(`Is 10 in a: ${ans5}`);
console.log(`Is 21 in a: ${ans6}`);
