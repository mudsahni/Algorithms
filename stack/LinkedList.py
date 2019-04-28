#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Apr 28 14:51:11 2019

@author: musahni
"""

class Node(object):
    def __init__(self):
        self.first = None
        self.item = None
        self.node = None
        
    def isEmpty(self):
        return self.first == None
    
    def push(self, item):
        self.old_first = self.first
        self.first = Node()
        self.first.item = item
        self.first.node = self.old_first
        
    def pop(self):
        self.item = self.first.item
        self.first = self.first.node
        return self.item
    
    
