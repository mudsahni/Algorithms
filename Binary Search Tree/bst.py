#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Aug 15 15:25:10 2019

@author: musahni
"""

class Tree(object):
    def __init__(self, item, parent, left, right):
        self.item = item
        self.parent = parent
        self.left = left
        self.right = right
        
    def get_parent(self):
        if self.parent:
            return self.parent.item
        else:
            return None
    
    def get_left(self):
        if self.left:
            return self.left.item
        else:
            return None
    
    def get_right(self):
        if self.right:
            return self.right.item
        else:
            return None
                    
    def __str__(self):
        return (f"Parent: {self.get_parent()} | Item: {self.item} | \n "
                f"Left: {self.get_left()} | Right: {self.get_right()}")

Five = Tree(5, None, None, None)
Three = Tree(3, None, None, None)
Four = Tree(4, None, None, None)
Two = Tree(2, None, None, None)
One = Tree(1, None, None, None)
Six = Tree(6, None, None, None)
Seven = Tree(7, None, None, None)

Five.left = Three
Five.right = Seven

Three.parent = Five
Three.left = One
Three.right = Four

Four.parent = Three

One.right = Two
One.parent = Three

Two.parent = One

Seven.parent = Five
Seven.left = Six

Six.parent = Seven

def search_tree(tree, item):
    if (tree.item == None):
        return None
    elif tree.item == item:
        return tree
    elif item < tree.item:
        return search_tree(tree.left, item)
    else:
        return search_tree(tree.right, item)
        
def find_minimum(tree):
    if tree.item == None:
        return None
    else:   
        minimum = tree
        while minimum.left != None:
            minimum = minimum.left 
    return minimum
    

def find_maximum(tree):
    if tree.item == None:
        return None
    else:
        maximum = tree
        while maximum.right != None:
            maximum = maximum.right
    return maximum

def find_root(tree):
    if tree.parent == None:
        return None
    else:
        root = tree
        while root.parent != None:
            root = root.parent
    return root

def traverse_tree(tree, lambd):
    if tree != None:
        traverse_tree(tree.left)
        lambd(tree.item)
        traverse_tree(tree.right)
        
def insert(tree, P, parent):
    if (tree == None):
        if parent.item > P.item and parent.left == None:
            parent.left = P
        else:
            parent.right = P
        P.parent = parent
    elif (P.item < tree.item):
        insert(tree.left, P, tree)
    else:
        insert(tree.right, P, tree)

Ten = Tree(10, None, None, None)
Nine = Tree(9, None, None, None)
Eight = Tree(8, None, None, None)
        
insert(Five, Ten, Seven)
insert(Five, Nine, Ten)
insert(Five, Eight, Nine)

