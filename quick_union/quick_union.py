#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 12 01:21:55 2019

@author: musahni
"""

'''
###########################
########QUICK UNION#########
###########################
'''

class Node(object):
    '''
    Node class
    '''
    def __init__(self, value):
        self.value = value
        self.parent = self
        self.children = {}
        
    def add_child(self, child):
        '''
        Adds a child.
        
        Arguments:
            child: child of class Node
        '''
        self.children[child.value] = child
        
    def change_parent(self, parent):
        '''
        Updates the parent.
        
        Arguments:
            parent: parent of class Node
        '''
        self.parent = parent
        

def union(e1,e2):
    '''
    Makes e2 the parent for e1.
    Adds e1 as child for e2.
    
    Arguments:
        e1: element 1
        e2: element 2
    Output:
        void
    '''
    e1.change_parent(e2)
    e2.add_child(e1)
    
def get_root(e1):
    '''
    Goes from one nodal parent to another till
    the parent is the node itself.
    
    Arguments:
        e1: element 1
    Output:
        root parent value
    '''
    p = e1.parent
    gp = e1.parent.parent
    while p.value != gp.value:
        p = gp
        gp = gp.parent
    return gp.value

def connected(e1,e2):
    return get_root(e1) == get_root(e2)

One = Node(1)
Two = Node(2)
Three = Node(3)
Four = Node(4)
Five = Node(5)
Six = Node(6)
Seven = Node(7)
Eight = Node(8)
Nine = Node(9)
Ten = Node(10)

print("Creating union between Nine and Seven")
union(Nine, Seven)
print("Creating union between Seven and Five")
union(Seven, Five)
print("Creating union between Five and Three")
union(Five, Three)
print("Creating union between Three and One")
union(Three, One)

print(f"Root parent for Nine: {get_root(Nine)}")

print("Creating union between Nine and One")
union(Nine,One)
print(f"Root parent for Nine: {get_root(Nine)}")