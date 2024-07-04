import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testCasesNumber = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCasesNumber; i++) {
			System.out.println("Matrix size: ");
			int matrixSize = in.nextInt();
			int matrix[][] = new int[matrixSize][matrixSize];

			for (int r = 0; r < matrixSize; r++) {
				for (int c = 0; c < matrixSize; c++) {
					matrix[r][c] = in.nextInt();
				}
			}
			printSolution(matrix, i);
		}
	}

	private static void printSolution(int[][] matrix, int i) {
		int trace = calculateTrace(matrix);
		int repeatedRows = findRepeated(matrix)[0];
		int repeatedCols = findRepeated(matrix)[1];
		System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedCols);
	}

	private static int[] findRepeated(int[][] matrix) {

		int[] repeated = new int[2];

		int repeatedRows = 0;
		int repeatedColumns = 0;
		for (int i = 0; i < matrix.length; i++) {

			if (hasRepeatedElements(matrix[i])) {
				System.out.println("Row " + i + ": " + hasRepeatedElements(matrix[i]));
				repeatedRows++;
			}

			int[] column = new int[matrix[i].length];
			for (int j = 0; j < matrix.length; j++) {
				column[j] = matrix[j][i];
			}

			if (hasRepeatedElements(column)) {
				repeatedColumns++;
			}
		}
		repeated[0] = repeatedRows;
		repeated[1] = repeatedColumns;

		return repeated;
	}

	private static int calculateTrace(int[][] matrix) {
		int trace = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix.length; c++) {
				if (r == c) {
					trace += matrix[r][c];
				}
			}
		}
		return trace;
	}

	public static boolean hasRepeatedElements(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
