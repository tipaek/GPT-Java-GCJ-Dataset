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
			vals[idx] = idx + 1;
		}
		return vals;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = in.nextInt();
		for (int test = 1; test <= tc; ++test) {
			int num = in.nextInt();
			int trace = in.nextInt();

			int[][] matrix = getMatrix(num);

			boolean resultFound = heapPermutation(test, trace, getValues(num), matrix, num, num);
			if (!resultFound) {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}

	private static void printMatrix(int vals[], int[][] matrix, int num) {
		for (int idx = 0; idx < num; idx++) {
			int row = vals[idx]-1;
			for (int col = 0; col < num; col++) {
				System.out.print(matrix[row][col]);
				if(col != num-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static boolean calculateAndPrintTrace(int test, int trace, int vals[], int[][] matrix, int num) {
		int currentTrace = 0;
		for (int idx = 0; idx < num; idx++) {
			currentTrace += matrix[vals[idx]-1][idx];
		}

		if (currentTrace == trace) {
			System.out.println("Case #" + test + ": POSSIBLE");
			printMatrix(vals, matrix, num);
			return true;
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