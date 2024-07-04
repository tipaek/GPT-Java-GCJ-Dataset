import java.util.HashSet;
import java.util.Scanner;

class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();

		int matrixSize = 0;

		StringBuilder output = new StringBuilder();

		for (int testCase = 0; testCase < testCases; testCase++) {
			matrixSize = sc.nextInt();
			int matrix[][] = new int[matrixSize][matrixSize];
			readMatrix(matrixSize, matrix);
			output.append(calculateVestigium(testCase, matrixSize, matrix));
		}

		System.out.println(output);
	}

	private static void readMatrix(int matrixSize, int[][] matrix) {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < matrixSize; j++) {
			for (int j2 = 0; j2 < matrixSize; j2++) {
				matrix[j][j2] = sc.nextInt();
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
