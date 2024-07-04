import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int testCases = in.nextInt();

		int matrixSize = 0;

		StringBuilder output = new StringBuilder();

		for (int testCase = 0; testCase < testCases; testCase++) {
			matrixSize = in.nextInt();
			int matrix[][] = new int[matrixSize][matrixSize];
			readMatrix(in, matrixSize, matrix);
			output.append(calculateVestigium(testCase, matrixSize, matrix));
		}

		System.out.println(output);
		System.exit(0);
	}

	private static void readMatrix(Scanner in, int matrixSize, int[][] matrix) {
		for (int j = 0; j < matrixSize; j++) {
			for (int j2 = 0; j2 < matrixSize; j2++) {
				matrix[j][j2] = in.nextInt();
			}
		}
	}

	public static boolean findSetContainsDuplicate(HashSet rowSet, int matrixSize) {
		return rowSet.size() != matrixSize;
	}

	private static String calculateVestigium(int testCase, int matrixSize, int[][] matrix) {
		HashSet<Integer> rowSet = new HashSet<>();
		HashSet<Integer> columnSet = new HashSet<>();
		int diagonalSum = 0;
		int rowCount = 0;
		int columnCount = 0;

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				rowSet.add(matrix[i][j]);
				columnSet.add(matrix[j][i]);
				if (i == j) {
					diagonalSum = diagonalSum + matrix[i][j];
				}
			}

			if (findSetContainsDuplicate(rowSet, matrixSize)) {
				rowCount++;
			}

			if (findSetContainsDuplicate(columnSet, matrixSize)) {
				columnCount++;
			}

			rowSet.clear();
			columnSet.clear();
		}
		return "Case #" + (testCase + 1) + ": " + diagonalSum + " " + rowCount + " " + columnCount + "\n";
	}

}
