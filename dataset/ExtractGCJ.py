# -*- coding: utf-8 -*-
"""
Created on Thu Jun 20 09:44:26 2024

@author: l-tipaek
"""

import csv
import tarfile
import os

import chardet


import pandas as pd

path = r"C:\Users\l-tipaek\Desktop\Research\NestedBigramsResearch\Data\GCJ\gcj2020.csv.tar.bz2"
path_csv = r"C:\Users\l-tipaek\Desktop\Research\NestedBigramsResearch\Data\GCJ\gcj2020_extracted.csv"

def make_csv_file(path):
    with tarfile.open(path, 'r:bz2') as tar:
        csv_file = tar.extractfile('gcj2020.csv')
    
        df = pd.read_csv(csv_file)
    
        df.to_csv('gcj2020_extracted.csv', index=False)
    
    print("The contents of gcj2020.csv.tar.bz2 have been successfully extracted to gcj2020_extracted.csv")


def detect_encoding(file_path):
    with open(file_path, 'rb') as f:
        result = chardet.detect(f.read())
    return result['encoding']

def csv_to_files(path):
    encoding = detect_encoding(path)

    with open(path, 'r', encoding=encoding, errors='ignore') as csv_file:
        # Create a csv reader
        reader = csv.DictReader(csv_file)
    
        # Iterate over each row in the csv file
        for row in reader:
            # Check if the file is a java file
            try:
                if row['full_path'].endswith('.JAVA'):
                    # Create a file name from the username, round, solution, and task
                    file_name = f"{row['username']}_{row['round']}_{row['solution']}_{row['task']}.java"
                    
                    # Create a new .java file and write the source code to it
                    with open(file_name, 'w') as f:
                        f.write(row['flines'])
            except Exception as e:
                print(f"Skipping row due to error: {e}")
                
    print("finished turning csv to files")


#make_csv_file(path)
csv_to_files(path_csv)