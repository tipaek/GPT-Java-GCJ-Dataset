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
// 		tests();
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
		int x = scan.nextInt();
		int y = scan.nextInt();
		String m = scan.nextLine().trim();
		int turn = 0;
		for (int i=0;i<m.length();i++) {
			turn++;
			char c = m.charAt(i);
			switch (c) {
			case 'S':
				y--;
				break;
			case 'N':
				y++;
				break;
			case 'W':
				x--;
				break;
			case 'E':
				x++;
				break;
			default:
				throw new RuntimeException("WTF");
			}
			int dist = Math.abs(x) + Math.abs(y);
			if (dist <= turn)
				return String.valueOf(turn);
		}
			
		return "IMPOSSIBLE";
	}

	private void tests() {
		singleTest("4 4 SSSS", "4");
		singleTest("3 0 SNSS", "IMPOSSIBLE");
		singleTest("2 10 NSNNSN", "IMPOSSIBLE");
		singleTest("0 1 S", "1");
		singleTest("2 7 SSSSSSSS", "5");
		singleTest("3 2 SSSW", "4");
		singleTest("4 0 NESW", "4");
		System.err.println("Tests pass");
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
