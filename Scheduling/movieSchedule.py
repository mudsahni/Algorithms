#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jul 30 13:42:31 2019

@author: musahni
"""

"""
Problem Statement: Imagine you are a highly-indemand
actor, who has been presented with offers to star in n different movie
projects under development. Each offer comes specified with the first and last 
day of filming. To take the job, you must commit to being available throughout 
this entire period. Thus you cannot simultaneously accept two jobs whose 
intervals overlap.

Criteria: you want to make as much money as possible. Because each of these 
films pays the same fee per film, this implies you seek the largest possible 
set of jobs (intervals) such that no two of them conflict with each other.
"""

import numpy as np
import random
import datetime
from collections import namedtuple
import calendar

np.random.seed(314)
Range = namedtuple("Range", ["start", "end"])

"""
##### TEST SET CREATION
"""
def make_datetime_object(day,month,year):
    return datetime.datetime.strptime(f"{year}-{month}-{day}", "%Y-%m-%d")
    
def get_random_date(start):
    """
    Generates a random datetime object between two other datetime objects.
    """
    MAX_DAYS = 30
    MIN_DAYS = 3
    number_of_days = np.random.randint(MIN_DAYS, MAX_DAYS)
    return start + datetime.timedelta(days=number_of_days)
    
def get_date(spread, year):
    month = np.random.randint(1,spread)
    day = np.random.randint(1,calendar.monthrange(year,month)[1])

    return make_datetime_object(day,month,year)

def generate_jobs(n,MAX_DAYS,MIN_DAYS,spread,year):
    date_ranges=[]
    for i in range(n):
        start = get_date(spread, year)
        end = get_random_date(start)
        date_range = DateRange(Range(start=start, end=end))
        date_ranges.append(date_range)
    return date_ranges

"""
EVALUATION
"""

class DateRange(object):
    def __init__(self, date_range):
        self.range = date_range
        
    def get_start_date(self):
        return self.range.start
    
    def get_end_date(self):
        return self.range.end
    
    def get_start_string(self):
        return self.range.start.strftime("%Y-%m-%d")
    
    def get_end_string(self):
        return self.range.end.strftime("%Y-%m-%d")
    
    def __str__(self):
        return f"{self.get_start_string()} ====> {self.get_end_string()}"
        
    def __lt__(self, r2):
        return self.range < r2
    
    def __le__(self, r2):
        return self.range <= r2
    
    def __eq__(self, r2):
        return self.range == r2
    
    def __gt__(self, r2):
        return self.range > r2
    
    def __ge__(self, r2):
        return self.range >= r2
    
    def get_overlap(self, r2):
        latest_start = max(self.start, r2.start)
        earliest_end = min(self.end, r2.end)
        delta = (earliest_end - latest_start).days + 1
        return max(0, delta)
    
    def is_overlap(self, r2):
        return self.get_overlap(r2) != 0
        
    

def get_overlap_matrix(starts, ends):
    """
    Creates overlap matrix.
    """
    overlaps = np.zeros((len(starts),len(ends)))
    for first in range(len(starts)):
        r1 = Range(start=starts[first], end=ends[first])
        for second in range(len(ends)):
            r2 = Range(start=starts[second], end=ends[second])
            overlap = calculate_overlap(r1, r2)
            overlaps[first, second] = overlap
    return overlaps
    
def get_overlaps(starts,ends):
    overlaps = calculate_overlaps(starts, ends)
    overlaps = overlaps > 0
    return overlaps

date_ranges = generate_jobs(10,3,30,3,2019)
overlaps = calculate_overlaps(starts, ends)

randomDate = starts[0]
isOverlap = get_overlaps([randomDate],)

def earliest_job_first(date_ranges):
    earliest_date = min(date_ranges)
    
    