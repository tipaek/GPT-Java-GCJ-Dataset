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
			System.out.printf("Case #%d: %s", i, res);
			System.err.printf("Case #%d: %s", i, res);
		});
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private String solve(Scanner scan) {
		int R = scan.nextInt();
		int S = scan.nextInt();
		int rank = R;
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int num_rounds = R - 1; num_rounds > 0; num_rounds--) {
			for (int i = 0; i < S - 1; i++) {
				int a = rank * (S - 1) - i;
				sb.append(a + " " + num_rounds + "\n");
				count++;
			}
			rank--;
		}
		return count + "\n" + sb.toString();
	}
	
	
	private void tests() {
		singleTest("2 2", "1\n2 1\n");
		singleTest("3 2", "2\n3 2\n2 1\n");
		singleTest("2 3", "2\n4 1\n3 1\n");
		singleTest("3 3", "4\n" + "6 2\n" + "5 2\n" + "4 1\n" + "3 1\n");
		singleTest("3 5", "4\n" + "6 2\n" + "5 2\n" + "4 1\n" + "3 1\n");
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
