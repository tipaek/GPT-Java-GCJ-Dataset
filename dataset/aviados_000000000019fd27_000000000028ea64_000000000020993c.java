package com.googlecodejam.vestigium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read input
		int numOfCases = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        try {
        	numOfCases = Integer.parseInt(br.readLine());
        	
        	for (int i=0; i<numOfCases; i++) {
	        	int size = Integer.parseInt(br.readLine());
	        	
	        	checkMatrix(i+1, size, br);
	    		
        	}
        } catch(NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void checkMatrix(int caseNum, int size, BufferedReader br) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();		
		try {
			
			for (int i=0; i<size; i++) {
				String s = br.readLine();
				ArrayList<Integer> line = new ArrayList<Integer>();
				String[] numberStrs = s.split(" ");
				for (int j=0; j<size; j++) {
					line.add(Integer.parseInt(numberStrs[j]));
				}
				matrix.add(line);
			}
			
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		int[][]matrixEfficient = new int[size][size];
		// fill the matrix
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				matrixEfficient[i][j]=matrix.get(i).get(j);
			}
		}
		// calculate trace
		int trace = 0;
		for (int i=0; i<size; i++) {
			trace+=matrixEfficient[i][i];
		}
		// duplicates in rows
		int dupRowCount = 0;
		for (int i=0; i<size; i++) {
			final Set<Integer> set1 = new HashSet<>();
			boolean duplicateFound = false;
			for (int j=0; j<size && !duplicateFound; j++) {
				if(!set1.add(matrixEfficient[i][j])) {
					dupRowCount++;
					duplicateFound = true;
				}
			}
		}
		// duplicates in columns
		int dupColCount = 0;
		for (int i=0; i<size; i++) {
			final Set<Integer> set1 = new HashSet<>();
			boolean duplicateFound = false;
			for (int j=0; j<size && !duplicateFound; j++) {
				if(!set1.add(matrixEfficient[j][i])) {
					dupColCount++;
					duplicateFound = true;
				}
			}
		}
		
		//print results
		System.out.println("Case #"+caseNum+": "+trace+" "+dupRowCount+" "+dupColCount );
	}

}
