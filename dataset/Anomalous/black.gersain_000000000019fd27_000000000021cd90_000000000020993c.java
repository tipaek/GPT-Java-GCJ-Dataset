package vestigium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			for (int testCase = 1; testCase <= testCases; testCase++) {
				int matrixSize = scanner.nextInt();
				int[][] matrix = new int[matrixSize][matrixSize];
				int[][] transposedMatrix = new int[matrixSize][matrixSize];
				
				for (int row = 0; row < matrixSize; row++) {
					for (int col = 0; col < matrixSize; col++) {
						matrix[row][col] = scanner.nextInt();
						transposedMatrix[col][row] = matrix[row][col];
					}
				}
				
				int traceValue = calculateTrace(matrix);
				int repeatedRows = countRepeatedNumbersInRows(matrix);
				int repeatedCols = countRepeatedNumbersInRows(transposedMatrix);
				
				System.out.printf("Case #%d: %d %d %d%n", testCase, traceValue, repeatedRows, repeatedCols);
			}
		}
	}
	
	private static int calculateTrace(int[][] matrix) {
		int trace = 0;
		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
		return trace;
	}

	private static int countRepeatedNumbersInRows(int[][] matrix) {
		int repeatedCount = 0;
		for (int[] row : matrix) {
			Set<Integer> uniqueNumbers = new HashSet<>();
			for (int num : row) {
				if (!uniqueNumbers.add(num)) {
					repeatedCount++;
					break;
				}
			}
		}
		return repeatedCount;
	}
}