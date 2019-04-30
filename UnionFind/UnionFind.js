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
