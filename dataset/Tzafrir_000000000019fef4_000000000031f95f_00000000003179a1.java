import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
//		tests();
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
		int U = scan.nextInt();
		int[] lettersFirst = new int[26];
		int[] lettersSeen = new int[26];
		for (int i = 0; i < 10000; i++) {
			int ignored = scan.nextInt();
			String pattern = scan.nextLine().trim();
			lettersFirst[pattern.charAt(0) - 'A']++;
			for (int j = 0; j < pattern.length(); j++)
				lettersSeen[pattern.charAt(j) - 'A']++;
		}
		List<Character> letters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
//		System.err.println(Arrays.toString(lettersFirst));
//		System.err.println(Arrays.toString(lettersSeen));
//		Collections.sort(letters, (l1, l2) -> lettersFirst[l2 - 'A'] - lettersFirst[l1 - 'A']);
//		System.err.println(letters);
		Collections.sort(letters, (l1, l2) -> lettersSeen[l2 - 'A'] - lettersSeen[l1 - 'A']);
//		System.err.println(letters);
		StringBuilder sb = new StringBuilder();
		sb.append(letters.get(9));
		sb.append(letters.get(0));
		sb.append(letters.get(1));
		sb.append(letters.get(2));
		sb.append(letters.get(3));
		sb.append(letters.get(4));
		sb.append(letters.get(5));
		sb.append(letters.get(6));
		sb.append(letters.get(7));
		sb.append(letters.get(8));
		return sb.toString();
	}
	
	
	private void tests() {
		singleTest("","");
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
