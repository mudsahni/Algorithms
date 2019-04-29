#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 18:12:54 2019

@author: musahni
"""

class Node(object):
    def __init__(self, item):
        self.item = item
        self.next = None
        
class Queue(object):
    def __init__(self):
        self.first = None
        self.last = None
        
    def isEmpty(self):
        return self.first == None
    
    def enqueue(self, node):
        old_last = self.last
        self.last = node
        self.last.next = None
        if(self.isEmpty() == True):
            self.first = self.last
        else:
            old_last.next = self.last
            
    def dequeue(self):
        item = self.first.item
        self.first = self.first.next
        
        if(self.isEmpty() == True):
            self.last = None
        
        return item
    
    
X = Node("X")
Y = Node("Y")

Q = Queue()

print(Q.isEmpty())
Q.enqueue(X)
Q.enqueue(Y)
print(Q.isEmpty())
print(Q.first.item)
print(Q.last.item)
