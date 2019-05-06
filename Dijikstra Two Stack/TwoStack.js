let twoStack = function(stringInput)
{
    let array = stringInput.split("");
    let functions = ["%","+","*","/","-"];
    let operators = [];
    let values = [];
    
    for(let i = 0; i<array.length;i++)
    {   
        let s = array[i];
        if(s=="(") {}
        else if(functions.includes(s) == true)
        {
            operators.push(s);
        }
        else if(s==")")
        {
            let op = operators.pop();
            if(op == "+") {values.push(values.pop() + values.pop())}
            else if(op == "*") {values.push(values.pop() * values.pop())}
            else if(op == "-") {values.push(values.pop() - values.pop())}
            else if(op == "/") {values.push(values.pop() / values.pop())}
            else if(op == "%") {values.push(values.pop() % values.pop())}
        }
        else
        {
            values.push(parseFloat(s));
        };

    };
    return values.pop();
};


let stringInput = "(1+((2+3)*(4*5)))";
let result = twoStack(stringInput);
console.log(result);

