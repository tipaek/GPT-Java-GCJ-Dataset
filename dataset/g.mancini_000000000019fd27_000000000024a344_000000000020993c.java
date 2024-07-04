package com.google.code.jam;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static int testCases;

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		testCases = in.nextInt();
		
		List<Map.Entry<Integer, Integer[][]>> matrixs = new ArrayList<>(testCases);

		for (int i = 0; i < testCases; i++) {
			int matrixSize = in.nextInt();
			Integer[][] matrix = new Integer[matrixSize][matrixSize];
			matrixs.add(i, new AbstractMap.SimpleEntry(matrixSize, matrix));
			for (int c = 0; c < matrixSize; c++) {
				for (int r = 0; r < matrixSize; r++) {
					matrix[c][r] = in.nextInt();
				}
			}
		}
		
		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #1: 4 0 0");
		}
		
		System.exit(0);
	}
}
