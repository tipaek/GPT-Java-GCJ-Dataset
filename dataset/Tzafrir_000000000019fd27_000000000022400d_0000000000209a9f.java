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
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private String solve(Scanner scan) {
		String s = scan.nextLine();
		return getMinimalWrap(s, 0);
	}
	
	
	private String getMinimalWrap(String s, int nestingLevel) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int d = digitAtIndex(s, i);
			if (d == nestingLevel)
				result.append(d);
			else if (d > nestingLevel) {
				result.append("(");
				int start = i;
				while (i + 1 < s.length() && digitAtIndex(s, i + 1) > nestingLevel)
					i++;
				result.append(getMinimalWrap(s.substring(start, i + 1), nestingLevel + 1));
				result.append(")");
			} else if (d < nestingLevel) {
				throw new RuntimeException("Invalid!!");
			}
		}
		return result.toString();
	}

	private int digitAtIndex(String s, int i) {
		int d = s.charAt(i) - '0';
		return d;
	}

	private void tests() {
		singleTest("0000", "0000");
		singleTest("101", "(1)0(1)");
		singleTest("111000", "(111)000");
		singleTest("1", "(1)");
		singleTest("021", "0((2)1)");
		singleTest("312", "(((3))1(2))");
		singleTest("4", "((((4))))");
		singleTest("221", "((22)1)");
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
