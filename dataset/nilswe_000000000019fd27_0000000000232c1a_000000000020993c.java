package codejam.qualification.vestigium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final Scanner in = new Scanner(new BufferedReader(new FileReader("res/q1.txt")));
		final int nTestCases = in.nextInt();
		for (int i = 0; i < nTestCases; i++) {
			// input
			final int n = in.nextInt();
			final long[][] matrix = new long[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = in.nextLong();
				}
			}
			// magic
			final long trace = trace(matrix);
			final int cols = cols(matrix);
			final int rows = rows(matrix);
			// print
			System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, rows, cols));
		}
	}

	private static long trace(long[][] matrix) {
		long trace = 0;
		for (int j = 0; j < matrix.length; j++) {
			trace += matrix[j][j];
		}
		return trace;
	}

	private static int rows(long[][] matrix) {
		int repeated = 0;
		for (long[] row : matrix) {
			Arrays.sort(row);
			for (int i = 0; i < row.length - 1; i++) {
				if (row[i] == row[i + 1]) {
					repeated++;
					break;
				}
			}
		}
		return repeated;
	}

	private static int cols(long[][] matrix) {
		int repeated = 0;
		final long[] col = new long[matrix.length];
		for (long[] longs : matrix) {
			System.arraycopy(longs, 0, col, 0, matrix.length);
			Arrays.sort(col);
			for (int i = 0; i < col.length - 1; i++) {
				if (col[i] == col[i + 1]) {
					repeated++;
					break;
				}
			}
		}
		return repeated;
	}

}
