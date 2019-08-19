let insertionSort = function(A) {
    for(let j = 2; j < A.length; j++) {
        let key = A[j];
        let i = j - 1;
        while(i >= 0 && A[i] > key) {
            A[i+1] = A[i];
            i -= 1;
        }
        A[i+1] = key;
    }
};

let A = [5,7,4,2,3,0,6,9,1,8];
console.log(A);
insertionSort(A);
console.log(A);
