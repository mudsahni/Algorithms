#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr 11 13:14:39 2019

@author: musahni
"""

'''
###########################
########UNION FIND#########
###########################
'''

def find(e1,e2,a):
    '''
    Check if two elements in an array 
    have the same ID.
    
    Arguments:
        e1: element 1
        e2: element 2
        a: array
    Output:
        returns true/false
        
    O(1)
    '''
    return a[e1] == a[e2]

def union(e1,e2,a):
    '''
    Changes the ID of the first element
    to the ID of the second element. 
    Also updates the IDs for all other 
    elements previously in union with
    the first element.
    
    Arguments:
        e1: element 1
        e2: element 2
        a: array
    Output:
        returns array a
        
    O(n)
    '''
    if not find(e1,e2,a):
        check = a[e1]
        a[e1] = a[e2]
        for i in range(len(a)):
            if a[i] == check:
                a[i] = a[e2]
    return a
        
#Tests
a = list(range(10))
print(f"3 == 5? {find(3,5,a)}")
print("Creating a union of 3 and 5.")
union(3,5,a)
print(f"3 == 5? {find(3,5,a)}")
print(f"2 == 5? {find(2,5,a)}")
print(f"2 == 3? {find(2,3,a)}")
print("Creating a union of 2 and 3")
union(2,3,a)
print(f"2 == 3? {find(2,3,a)}")
print(f"2 == 5? {find(2,5,a)}")
