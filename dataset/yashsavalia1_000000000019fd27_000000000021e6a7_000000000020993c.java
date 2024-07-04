import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCaseNo = Integer.parseInt(in.nextLine());
		String[] results = new String[testCaseNo];

		for (int i = 0; i < testCaseNo; i++) {
			int[][] inputMatrix = readMatrix(in);
			results[i] = processMatrix(inputMatrix);
		}
		in.close();
		printResults(results);

	}

	private static String processMatrix(int[][] matrix) {
		int trace = calculateTrace(matrix);
		int rowsRepeatCount = calculateRowsRepeateCount(matrix);
		int columnsRepeateCount = calculateColsRepeateCount(matrix);
		return trace + " " + rowsRepeatCount + " " + columnsRepeateCount;
	}

	private static int[][] readMatrix(Scanner in) {
		int matrixSize = Integer.parseInt(in.nextLine());
		int[][] inputMatrix = new int[matrixSize][matrixSize];
		for (int j = 0; j < matrixSize; j++) {
			String row = in.nextLine();
			String[] elements = row.split(" ");
			for (int k = 0; k < elements.length; k++) {
				inputMatrix[j][k] = Integer.parseInt(elements[k]);
			}
		}
		return inputMatrix;
	}

	private static void printResults(String[] results) {
		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
		}
	}

	private static int calculateColsRepeateCount(int[][] inputMatrix) {
		int result = 0;
		for (int i = 0; i < inputMatrix.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < inputMatrix.length; j++) {
				boolean added = set.add(inputMatrix[j][i]);
				if (!added) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	private static int calculateRowsRepeateCount(int[][] inputMatrix) {
		int result = 0;
		for (int i = 0; i < inputMatrix.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int value : inputMatrix[i]) {
				boolean added = set.add(value);
				if (!added) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	private static int calculateTrace(int[][] inputMatrix) {
		int trace = 0;
		for (int i = 0; i < inputMatrix.length; i++) {
			trace += inputMatrix[i][i];
		}
		return trace;
	}

}
