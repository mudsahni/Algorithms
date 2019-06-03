#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri May  3 19:15:11 2019

@author: musahni
"""
    
    

def twoStack(stringInput):
    stringList = list(stringInput)
    functions = list("*/+-%")
    operators = []
    values = []
    for s in stringList:
        if s == "(":
            pass
        elif s in functions:
            operators.append(s)
        elif s == ")":
            op = operators.pop()
            if op == "+":
                values.append(values.pop() + values.pop())
            elif op == "*":
                values.append(values.pop() * values.pop())
            elif op == "-":
                values.append(values.pop() - values.pop())
            elif op == "/":
                values.append(values.pop() / values.pop())
            elif op == "%":
                values.append(values.pop() % values.pop())
        else:
            values.append(float(s))
    return values.pop()
            
g = twoStack("(1+((2+3)*(4*5)))")


