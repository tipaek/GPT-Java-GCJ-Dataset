package com.alpha.samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			
			int v = in.nextInt();
			
			int array[][] = new int[v][v];
			int sum = 0;
			int row = 0;
			int column = 0;
			
			Set<Integer> rowSet = new HashSet<Integer>();
			Set<Integer> columnSet = new HashSet<Integer>();
			
			for (int j =0; j < v; j++) {
				for (int k =0; k < v; k++) {
					array[j][k] = in.nextInt();
					rowSet.add(array[j][k]);
					if(j == k) {
						sum += array[j][k];
					}
				}
				if(rowSet.size() != v) row++;
				rowSet.clear();
				
			}
			for (int j =0; j < v; j++) {
				for (int k =0; k < v; k++) {
					columnSet.add(array[k][j]);
				}
				if(columnSet.size() != v) column++;
				columnSet.clear();
			}
			
			System.out.println("Case #" + i + ": " + sum + " " + row + " " + column);
			
		}
		in.close();
	}
}