#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 26 15:29:25 2019

@author: musahni
"""


def binary_search(a, b):
    lo, hi = 0, len(a)-1
    while lo<=hi:
        mid = lo + (hi - lo)//2
        if b < a[mid]:
            hi = mid-1
        elif b > a[mid]:
            lo = mid+1
        else:
            return mid
    return -1
    
binary_search(list(range(1000)),100)


def binary_search_recursive(arr,low, high, key):
    if low <= high:
        mid = low + (high - low)//2
        
        if arr[mid] == key:
            return mid
        
        elif arr[mid] > key:
            return binary_search_recursive(arr, low, mid-1, key)
        else:
            return binary_search_recursive(arr, mid+1, high,key)
    else:
        return -1
        
    
    
binary_search_recursive([2,3,4,10,40],0,4,10)