let count = function(a){
    let N = a.length;
    let result = 0;
    for(let i = 0; i<N; i++){
        for(let j = i+1; j<N; j++){
            for(let k = j+1; k<N; k++){
                if(a[i] + a[j] + a[k] == 0){
                    result = result+1;
                    console.log(`${a[i]} + ${a[j]} + ${a[k]} = ${a[i] + a[j] + a[k]} == 0`);
                }
            }
        }
    }
    return result;
    
}

let a = [30, -40, 10, 20, -20, 100, 80, -30, -10, 50, 60];
let result = count(a);
console.log(result);