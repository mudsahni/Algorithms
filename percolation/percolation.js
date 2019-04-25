
class UnionFind {
    constructor(size) {
        this.size = size;
        this.id = [];
        for(let i =0; i<this.size;i++){
            this.id.push(i);
        };
        this.depth = [];
        for(let j=0;j<this.size;j++){
            this.depth.push(1);
        };
    };

    root(p) {
        while(p!=this.id[p]){
            p = this.id[p];
        };
        return p;
    };

    connected(p, q) {
        return this.root(p) == this.root(q);
    };

    union(p, q) {
        rootP = this.root(p);
        rootQ = this.root(q);

        if(rootP == rootQ) {
            return;
        };

        if(this.depth[rootP] < this.depth[rootQ]) {
            this.id[rootP] = rootQ;
            this.depth[rootQ] += this.depth[rootP];
        }

        else {
            this.id[rootQ] = rootP;
            this.depth[rootP] += rootQ;
        };

    };
};


class Grid {
    constructor(size, prob) {
        this.size = size;
        this.prob = prob;
        this.elements = new UnionFind(this.size);
        this.grid = [];
        let temp = [];
        for(let row=0; row<this.size;row++) {
            temp = [];
            for(let col=0;col<this.size;col++) {
                let rn = Math.random();
                if(rn > this.prob) {
                    rn = 0;
                }
                else {
                    rn = 1;
                };
                temp.push(rn);
            };
            this.grid.push(temp);
        };

        this.isOpen = [];
        for(let row=0; row<this.size;row++) {
            temp=[];
            for(let col=0; col<this.size; col++){
                if(this.grid[row][col] == 1){
                    temp.push(true);
                }
                else{
                    temp.push(false);
                };
            };
            this.isOpen.push(temp);
        };
    };

    _flow(isFull, i, j) {
        if(i<0 || i>=this.size) {
            return;
        };
        if(j<0 || j>=this.size) {
            return;
        };
        if(this.isOpen[i][j] == 0){
            return;
        };
        if(isFull[i][j]) {
            return;
        };

        isFull[i][j] = true;
        this._flow(isFull, i+1, j) //Down
        this._flow(isFull, i-1, j) //Up
        this._flow(isFull, i, j+1) //Right
        this._flow(isFull, i, j-1) //Left
    };

    flow(){
        let isFull = [];
        let temp = [];
        for(let row=0;row<this.size;row++){
            temp = [];
            for(let col = 0; col<this.size;col++){
                temp.push(0);
            };
            isFull.push(temp);
        };

        for(let j =0;j<this.size;j++){
            this._flow(isFull, 0, j);
        };

        return isFull;
    };

    percolates(){
        let isFull = this.flow();

        for(let j = 0;j<this.size;j++){
            if(isFull[this.size-1][j] == 1){
                return true;
            };
        };
        return false;
    }
};

let G = new Grid(10,0.9);


const renderGrid = function (grid_value) {
    const G_grid = new Grid(5,grid_value);
    
    document.querySelector('#notes').innerHTML = ''
    const percolates = document.createElement('p');
    percolates.textContent = G_grid.percolates();
    const show_grid = document.createElement('p');
    show_grid.textContent = G_grid.grid;
    document.querySelector('#notes').appendChild(percolates);
    document.querySelector('#notes').appendChild(show_grid);
    console.log(G_grid.grid);
};

document.querySelector('#select_grid_value').addEventListener('input', function (e) {
    renderGrid(e.target.value);
    console.log(`hello: ${e.target.value}`);

});

let canvas = document.querySelector('canvas');
let ctx = canvas.getContext("2d");
let imgData = ctx.createImageData(120, 120);

ctx.putImageData(G.grid, 0, 0);
