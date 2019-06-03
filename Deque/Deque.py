#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jun  2 19:29:29 2019

@author: musahni
"""

class Node(object):
    def __init__(self, item):
        self.item = item
        self.next = None
        self.prev = None
        
class Deque(object):
    def __init__(self):
        self.first = None
        self.last = None
        
    def isEmpty(self):
        return self.first == None and self.last == None
    
    def size(self):
        if self.isEmpty():
            return 0
        else:
            counter = 0
            temp = self.first
            while True:
                if temp:
                    counter += 1
                    temp = temp.next
                else:
                    break
                
            return counter
    
    def addLast(self, node):
        old_last = self.last
        self.last = node
        self.last.next = None
        if(self.first == None):
            self.first = self.last
        else:
            old_last.next = self.last
            self.last.prev = old_last
            
    def addFirst(self, node):
        old_first = self.first
        self.first = node
        self.first.prev = None
        if(self.last == None):
            self.last = self.first
        else:
            self.first.next = old_first
            old_first.prev = self.first
        
    def removeFirst(self):
        item = self.first.item
        self.first = self.first.next
        self.first.prev = None
        
        return item
    
    def removeLast(self):
        item = self.last.item
        self.last = self.last.prev
        self.last.next = None
        
        return item
    


X = Node("X")
Y = Node("Y")
D = Deque()
print(f"Size of D: {D.size()}")
D.addFirst(X)
print(f"Size of D: {D.size()}")
print(f"First node: {D.first.item}")
D.addFirst(Y)
print(f"Size of D: {D.size()}")
print(f"First node: {D.first.item}")
print(f"Last node: {D.last.item}")
Z = Node("Z")
D.addLast(Z)
print(f"Size of D: {D.size()}")
print(f"First node: {D.first.item}")
print(f"Last node: {D.last.item}")

print(f"Next for first: {D.first.next.item}")
print(f"Previous for last: {D.last.prev.item}")

last_item = D.removeLast()
print(f"Last node removed: {last_item}")
print(f"New last node: {D.last.item}")
first_item = D.removeFirst()
print(f"First node removed: {first_item}")
print(f"New first node: {D.first.item}")