#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 12 19:13:16 2019

@author: musahni
"""

'''
###################################
########WEIGHTED QUICK UNION#######
###################################
'''
class WeightedQuickUnion(object):
    def __init__(self, arr):
        self.parent = arr
        self.size = [1 for i in range(10)]
        self.count = len(arr)
        

    def find(self, p):
        while p != self.parent[p]:
            p = self.parent[p]
        
        return p
    
    def connected(self, p, q):
        return self.find(p) == self.find(q)
    
    def union(self, p, q):
        rootp = self.find(p)
        rootq = self.find(q)
        
        if rootp == rootq:
            pass
        
        if self.size[rootp] < self.size[rootq]:
            self.parent[rootp] = rootq
            self.size[rootq] += self.size[rootp]
            
        else:
            self.parent[rootq] = rootp
            self.size[rootp] += rootq
        
        self.count -= 1
    


#Test Cases
import random

WQU = WeightedQuickUnion(arr)

def random_test(n, wqu):
    arr = list(range(n))
    for i in range(n//2):
        j = random.randint(0,n)
        k = random.randint(0,n)
        wqu.union(j,k)
        

random_test(100, WQU)
    
