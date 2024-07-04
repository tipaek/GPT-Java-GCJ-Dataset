
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Submit without package declaration!
 */
public class Solution {

	private static Scanner getScanner(final String fileName) {
		try {
			return new Scanner(new BufferedReader(new FileReader(fileName)));
		} catch (FileNotFoundException e) {
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		}
	}

	public static void main(String[] args)  {
		Scanner in = getScanner("res/q1.txt");
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
			// print
			System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace(matrix), rows(matrix), cols(matrix)));
		}
	}

	private static long trace(int[][] matrix) {
		return IntStream.range(0, matrix.length).mapToLong(j -> matrix[j][j]).sum();
	}

	private static long rows(int[][] matrix) {
		return Arrays.stream(matrix).mapToLong(
				row -> Arrays.stream(row)
						.distinct()
						.count())
				.filter(distinctCount -> distinctCount < matrix.length)
				.count();
	}

	private static long cols(int[][] matrix) {
		return IntStream.range(0, matrix.length).mapToLong(
				i -> Arrays.stream(matrix)
						.mapToLong(row -> row[i])
						.distinct()
						.count())
				.filter(distinctCount -> distinctCount < matrix.length)
				.count();
	}

}
