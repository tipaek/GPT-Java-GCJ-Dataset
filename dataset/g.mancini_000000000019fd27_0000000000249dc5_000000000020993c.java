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
			long trace = 0;
			StringBuilder solutionOutput = new StringBuilder();

			Map.Entry<Integer, Integer[][]> input = matrixs.get(i);
			int size = input.getKey();
			Integer[][] matrix = input.getValue();
			long rowsWithDuplicate = 0;
			long columnsWithDuplicate = 0;
			Map<Integer, Set<Integer>> columnsValues = new HashMap<>();

			for (int r = 0; r < size; r++) {
				solutionOutput = new StringBuilder();
				Set<Integer> rowValues = new HashSet<>();
				for (int c = 0; c < size; c++) {
					rowValues.add(matrix[r][c]);
					Set<Integer> columnValues = columnsValues.get(c);
					if (columnValues == null) {
						columnValues = new HashSet<>();
						columnsValues.put(c, columnValues);
					}
					columnValues.add(matrix[r][c]);
					if(c == r) {
						trace += matrix[r][c];
					}
				}
				if (rowValues.size() != size) {
					rowsWithDuplicate++;
				}
				
			}
			for (Set<Integer> columnValues : columnsValues.values()) {
				if (columnValues.size() != size) {
					columnsWithDuplicate++;
				}
			}
			solutionOutput.append(trace).append(" ").append(rowsWithDuplicate).append(" ").append(columnsWithDuplicate);
			System.out.println("Case #" + i + 1 + ": " + solutionOutput.toString());
		}
		
		System.exit(0);
	}
}
