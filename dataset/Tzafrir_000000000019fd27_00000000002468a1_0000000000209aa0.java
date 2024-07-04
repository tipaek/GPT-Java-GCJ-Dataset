import java.io.FileNotFoundException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	private int N;
	private int expectedDiagSum;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		long before = System.nanoTime();
//		tests();
		System.err.println("Took " + ((System.nanoTime() - before) / 1000000) + " ms");
		before = System.nanoTime();
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
		N = scan.nextInt();
		expectedDiagSum = scan.nextInt();
		int[][] mat = new int[N][N];
		boolean[][] colValues = new boolean[N][N + 1];
		boolean[][] rowValues = new boolean[N][N + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				colValues[i][j] = true;
				rowValues[i][j] = true;
			}
		}
		boolean solved = solve(mat, 0, colValues, rowValues, 0);
		if (!solved)
			return "IMPOSSIBLE";
		StringBuffer res = new StringBuffer();
		res.append("POSSIBLE\n");
		for (int row = 0; row < N; row++) {
			res.append(mat[row][0]);
			for (int col = 1; col < N; col++) {
				res.append(" ");
				res.append(mat[row][col]);
			}
			res.append("\n");
		}
		return res.toString();
	}
	
	
	private boolean solve(int[][] mat, int combinedPos, boolean[][] colValues, boolean[][] rowValues,
			int diagSum) {
		int row = getRow(combinedPos);
		int col = getCol(combinedPos);
		if (combinedPos == N * N)
			return diagSum == expectedDiagSum;
		for (int val = 1; val <= N; val++) {
			if (!colValues[col][val] || !rowValues[row][val])
				continue;
			mat[row][col] = val;
			if (row == col) {
				int sumDiagLeft = expectedDiagSum - (diagSum + val);
				if (sumDiagLeft < (N - row - 1))
					continue;
				if (sumDiagLeft > N * (N - row - 1))
					continue;
			}
//			System.err.println("mat[" + row + "][" + col + "]=" + mat[row][col] + " diagSum = " + diagSum);
			colValues[col][val] = false;
			rowValues[row][val] = false;
			if (solve(mat, combinedPos + 1, colValues, rowValues, row == col ? diagSum + val : diagSum))
				return true;
			colValues[col][val] = true;
			rowValues[row][val] = true;
		}
		return false;
	}

	private int getCol(int combinedPos) {
		return combinedPos % N;
	}

	private int getRow(int combinedPos) {
		return combinedPos / N;
	}

	private void tests() {
		singleTest("3 6", "POSSIBLE\n" + "1 2 3\n" + "2 3 1\n" + "3 1 2\n");
		singleTest("2 3", "IMPOSSIBLE");
		singleTest("5 5", "POSSIBLE\n" + "1 2 3 4 5\n" + "2 1 4 5 3\n" + "3 5 1 2 4\n" + "4 3 5 1 2\n" + "5 4 2 3 1\n");
		singleTest("5 6", "IMPOSSIBLE");
		singleTest("50 50", "IMPOSSIBLE");
	}
	
	private void singleTest(String input, String expected) {
		String result = solve(new Scanner(new StringReader(input))); 
		if (result.equals(expected))
			return;
		System.err.println("Wrong answer for:\n"+input);
		System.err.println("Got: "+result);
		System.err.println("Expected: "+expected);
		System.exit(1);
	}
// =================================================
	// Below are generic utility methods
	
	BigDecimal choose(final int N, final int K) {
		BigDecimal ret = BigDecimal.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigDecimal.valueOf(N-k))
	                 .divide(BigDecimal.valueOf(k+1));
	    }
	    return ret;
	}
}
