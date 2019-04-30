#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Apr 13 16:30:18 2019

@author: musahni
"""

import numpy as np
import matplotlib.pyplot as plt

class UnionFind(object):
    def __init__(self, size):
        self.size = size
        self.id = list(range(size))
        self.depth = [1]*self.size
        

    def find(self, p):
        while p != self.id[p]:
            p = self.id[p]
        
        return p
    
    def connected(self, p, q):
        return self.find(p) == self.find(q)
    
    def union(self, p, q):
        rootp = self.find(p)
        rootq = self.find(q)
        
        if rootp == rootq:
            pass
        
        if self.depth[rootp] < self.depth[rootq]:
            self.id[rootp] = rootq
            self.depth[rootq] += self.depth[rootp]
            
        else:
            self.id[rootq] = rootp
            self.depth[rootp] += rootq
                
class Grid(object):
    def __init__(self, size, prob):
        self.size = size
        self.prob = prob
        self.elements = UnionFind(self.size)
        self.grid = np.random.choice([1,0], size=(self.size,self.size),
                                     p=[self.prob,1-self.prob])
        self.isOpen = self.grid==1
        
    def __str__(self):
        plt.imshow(self.grid, cmap="gray")
        return 'Grid'

    def _flow(self, isFull, i, j):
        if (i<0) or (i>=self.size):
            return
        if (j<0) or (j>=self.size):
            return
        if not self.isOpen[i][j]:
            return
        if isFull[i][j]:
            return
                
        
        isFull[i][j] = True
        self._flow(isFull, i+1, j)#Down
        self._flow(isFull, i, j+1)#Right
        self._flow(isFull, i, j-1)#Left
        self._flow(isFull, i-1, j)#Up
        

    def flow(self):
        isFull = np.zeros((self.size,self.size))
        for j in range(self.size):
            self._flow(isFull, 0, j)
        return isFull
    
    def percolates(self):
        isFull = self.flow()
        
        n = len(isFull)
        for j in range(n):
            if isFull[n-1][j]:
                return True
        return False
        

G = Grid(10,0.9)
G.percolates()
print(G)    