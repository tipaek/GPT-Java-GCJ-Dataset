import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");

	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		//tests();
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			String res = solve(scan);
			System.out.printf("Case #%d: %s\n", i, res);
			System.err.printf("Case #%d: %s\n", i, res);
		});
		System.err.println("Took " + ((System.nanoTime() - before) / 1000000) + " ms");
		scan.close();
	}

	private String solve(Scanner scan) {
		int N = scan.nextInt();
		int[][] matrix = new int[N][N];
		int trace = 0;
		// calc trace
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				matrix[row][col] = scan.nextInt();
				if (row == col)
					trace += matrix[row][col];
			}
		}

		// calc sum rows
		int bad_rows = 0;
		for (int row = 0; row < N; row++) {
			int[] seen = new int[N + 1];
			for (int col = 0; col < N; col++) {
				if (seen[matrix[row][col]] != 0) {
					bad_rows++;
					break;
				}
				seen[matrix[row][col]] = 1;
			}
		}

//		calc sum cols
		int bad_cols = 0;
		for (int col = 0; col < N; col++) {
			int[] seen = new int[N + 1];
			for (int row = 0; row < N; row++) {
				if (seen[matrix[row][col]] != 0) {
					bad_cols++;
					break;
				}
				seen[matrix[row][col]] = 1;
			}
		}

		return trace + " " + bad_rows + " " + bad_cols;
	}

	private void tests() {
		singleTest("4\n" + "1 2 3 4\n" + "2 1 4 3\n" + "3 4 1 2\n" + "4 3 2 1", "4 0 0");
		singleTest("4\n" + "2 2 2 2\n" + 
				"2 3 2 3\n" + 
				"2 2 2 3\n" + 
				"2 2 2 2", "9 4 4");
		singleTest("3\n 2 1 3\n" + "1 3 2\n" + "1 2 3", "8 0 2");
	}

	private void singleTest(String input, String expected) {
		String result = solve(new Scanner(new StringReader(input)));
		if (result.equals(expected))
			return;
		System.err.println("Wrong answer for:\n" + input);
		System.err.println("Got: " + result);
		System.err.println("Expected: " + expected);
		System.exit(1);
	}
// =================================================
	// Below are generic utility methods

	BigDecimal choose(final int N, final int K) {
		BigDecimal ret = BigDecimal.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigDecimal.valueOf(N - k)).divide(BigDecimal.valueOf(k + 1));
		}
		return ret;
	}
}
