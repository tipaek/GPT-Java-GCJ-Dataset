package codejam.qualification.vestigium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
		final Scanner in = // new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				new Scanner(new BufferedReader(new FileReader("res/q1.txt")));
		final int nTestCases = in.nextInt();
		final ExecutorService pool = Executors.newFixedThreadPool(nTestCases);
		final ArrayList<Future<String>> futures = new ArrayList<>();
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
			final int nCase = i+1;
			Callable<String> task = () -> {
				final int trace = trace(matrix);
				final int cols = cols(matrix);
				final int rows = rows(matrix);
				return String.format("Case #%d: %d %d %d", nCase, trace, rows, cols);
			};
			futures.add(pool.submit(task));
		}
		// print
		futures.stream().map(f -> {
			try {
				return f.get();
			} catch (InterruptedException | ExecutionException e) {
				throw new IllegalStateException(e);
			}
		}).forEach(System.out::println);
		pool.shutdown();
	}

	private static int trace(int[][] matrix) {
		int trace = 0;
		for (int j = 0; j < matrix.length; j++) {
			trace += matrix[j][j];
		}
		return trace;
	}

	private static int rows(int[][] matrix) {
		int repeated = 0;
		for (int[] row : matrix) {
			repeated += checkDistinctness(row); // mutiert matrix!
		}
		return repeated;
	}

	private static int cols(int[][] matrix) {
		int repeated = 0;
		final int[] col = new int[matrix.length];
		for (int j = 0; j < matrix.length; j++) {
			copyColumn(matrix, col, j);
			repeated += checkDistinctness(col);
		}
		return repeated;
	}

	private static void copyColumn(int[][] matrix, int[] col, int j) {
		for (int i = 0; i < matrix.length; i++) {
			col[i] = matrix[i][j];
		}
	}

	private static int checkDistinctness(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return 1;
			}
		}
		return 0;
	}

}
