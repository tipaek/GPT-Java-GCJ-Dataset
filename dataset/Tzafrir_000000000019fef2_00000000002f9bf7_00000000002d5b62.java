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
	private int Y;
	private int X;
	
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
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private String solve(Scanner scan) {
		X = scan.nextInt();
		Y = scan.nextInt();

		for (int length = 1; length <= 8; length++) {
			String path = checkPath(0, 0, length, 1);
			if (path != null)
				return path;
		}
		return "IMPOSSIBLE";
	}
	
	
	private String checkPath(int x, int y, int stepsLeft, int currentValue) {
		if (x == X && y == Y)
			return "";
		if (stepsLeft == 0)
			return null;
		String north = checkPath(x, y + currentValue, stepsLeft - 1, currentValue * 2);
		if (north != null)
			return "N" + north;
		String south = checkPath(x, y - currentValue, stepsLeft - 1, currentValue * 2);
		if (south != null)
			return "S" + south;
		String east = checkPath(x + currentValue, y, stepsLeft - 1, currentValue * 2);
		if (east != null)
			return "E" + east;
		String west = checkPath(x - currentValue, y, stepsLeft - 1, currentValue * 2);
		if (west != null)
			return "W" + west;
		return null;
	}

	private void tests() {
		singleTest("2 3", "SEN");
		singleTest("-2 -3", "NWS");
		singleTest("-1 1", "IMPOSSIBLE");
		singleTest("3 0", "EE");
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
