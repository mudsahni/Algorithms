#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 19 16:14:11 2019

@author: musahni
"""

import numpy as np

A = np.random.randint(0,1000,50)
def insertion_sort(A):
    for i in range(len(A)):
        key = A[i]
        j = i-1
        while j>=0 and A[j] > key:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key
        
print(A)
insertion_sort(A)
print(A)