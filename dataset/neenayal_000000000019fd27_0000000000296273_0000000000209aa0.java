import java.util.*;
import java.io.*;

public class Solution {

	private static int[][] getMatrix(int n) {
		int[][] matrix = new int[n][n];
		for (int row = 0; row < n; row++) {
			int count = 1;
			int start = row;
			for (int col = 0; col < n; col++) {
				matrix[row][start % n] = count++;
				start++;
			}
		}
		return matrix;
	}

	private static int[] getValues(int n) {
		int[] vals = new int[n];
		for (int idx = 0; idx < n; idx++) {
			vals[idx] = idx;
		}
		return vals;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = in.nextInt();
		for (int test = 1; test <= tc; ++test) {
			int num = in.nextInt();
			int trace = in.nextInt();
			boolean resultFound = false;
			for (int idx = 1; idx <= num; idx++) {
				if (idx * num == trace) {
					resultFound = true;
				}
			}

			if (resultFound) {
				heapPermutation(test, trace, getValues(num), getMatrix(num), num, num);
			} else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}

	private static void printMatrix(int vals[], int[][] matrix, int num) {
		for (int idx = 0; idx < num; idx++) {
			int row = vals[idx];
			StringBuilder builder = new StringBuilder();
			for (int col = 0; col < num; col++) {
				builder.append(matrix[row][col]).append(" ");
			}
			System.out.println(builder.toString().trim());
		}
	}
	
	private static void printColMatrix(int vals[], int[][] matrix, int num) {
		for (int idx = 0; idx < num; idx++) {
			int col = vals[idx];
			StringBuilder builder = new StringBuilder();
			for (int row = 0; row < num; row++) {
				builder.append(matrix[row][col]).append(" ");
			}
			System.out.println(builder.toString().trim());
		}
	}

	private static boolean calculateAndPrintTrace(int test, int trace, int vals[], int[][] matrix, int num) {
		int currentTrace = 0;
		for (int idx = 0; idx < num; idx++) {
			currentTrace += matrix[vals[idx]][idx];
		}

		if (currentTrace == trace) {
			System.out.println("Case #" + test + ": POSSIBLE");
			printMatrix(vals, matrix, num);
			return true;
		} else {
			currentTrace = 0;
			for (int idx = 0; idx < num; idx++) {
				currentTrace += matrix[idx][vals[idx]];
			}
			if (currentTrace == trace) {
				System.out.println("Case #" + test + ": POSSIBLE");
				printColMatrix(vals, matrix, num);
				return true;
			}
		}
		return false;
	}

	private static boolean heapPermutation(int test, int trace, int vals[], int[][] matrix, int size, int num) {
		if (size == 1) {
			return calculateAndPrintTrace(test, trace, vals, matrix, num);
		}

		boolean result = false;
		for (int i = 0; i < size; i++) {
			result = heapPermutation(test, trace, vals, matrix, size - 1, num);
			if (result) {
				break;
			}
			if (size % 2 == 1) {
				int temp = vals[0];
				vals[0] = vals[size - 1];
				vals[size - 1] = temp;
			} else {
				int temp = vals[i];
				vals[i] = vals[size - 1];
				vals[size - 1] = temp;
			}
		}
		return result;
	}

}