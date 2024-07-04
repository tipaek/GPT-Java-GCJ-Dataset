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
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private String solve(Scanner scan) {
		int N = scan.nextInt();
		scan.nextLine();
		List<String> words = new ArrayList<String>(N);
		for (int i = 0; i < N; i++) {
			words.add(scan.nextLine().substring(1));
		}
		String longest = words.stream().max((s1, s2) -> s1.length() - s2.length()).get();
		if (words.stream().allMatch(s -> longest.endsWith(s)))
			return longest;
		return "*";
	}
	
	
	private void tests() {
		singleTest("5\n" + "*CONUTS\n" + "*COCONUTS\n" + "*OCONUTS\n" + "*CONUTS\n" + "*S", "COCONUTS");
		singleTest("2\n" + "*XZ\n" + "*XYZ", "*");
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
