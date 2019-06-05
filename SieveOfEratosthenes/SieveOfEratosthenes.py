#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jan 29 13:26:26 2019

@author: musahni
"""
import math
def remove_multiples(i,n):
    array = []
    x = True
    count = 0
    while x:
        num = i**2 + (count*i)
        if num < n:
            array.append(num)
            count += 1
        else:
            x = False
    return array

def sieve(n):
    if n > 1:
        a = dict(zip(range(2,n),[True]*(n)))
        for i in range(2,int(math.sqrt(n))+1):
            if a[i] == True:
                array = remove_multiples(i,n)
                for j in array:
                    a[j] = False
    return a



primes = sieve(100)