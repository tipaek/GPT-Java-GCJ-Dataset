package codejam.qualification.vestigium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// final Scanner in = new Scanner(new BufferedReader(new FileReader("res/q1.txt")));
		final int nTestCases = in.nextInt();
		for (int i = 0; i < nTestCases; i++) {
			// input
			final int n = in.nextInt();
			final int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			// magic
			// print
			System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace(matrix), rows(matrix), cols(matrix)));
		}
	}

	private static long trace(int[][] matrix) {
		long trace = 0;
		for (int j = 0; j < matrix.length; j++) {
			trace += matrix[j][j];
		}
		return trace;
	}

    private static long rows(int[][] matrix) {
        int repeated = 0;
        for (int[] row : matrix) {
            final long distinctCount = Arrays.stream(row)
                    .distinct()
                    .count();
            if (distinctCount < matrix.length)
                repeated++;
        }
        return repeated;
    }

    private static long cols(int[][] matrix) {
        int repeated = 0;
        for (int j = 0; j < matrix.length; j++) {
            final int k = j;
            final long distinctCount = Arrays.stream(matrix)
                    .mapToInt(row -> row[k])
                    .distinct()
                    .count();
            if (distinctCount < matrix.length)
                repeated++;
        }
        return repeated;
    }

}
