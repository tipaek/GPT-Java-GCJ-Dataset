import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
// 		tests();
// 		System.err.println("Tests pass");
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
		int D = scan.nextInt();
		BigInteger[] a = new BigInteger[N];
		for (int i = 0; i < N; i++)
			a[i] = scan.nextBigInteger();
		Map<BigInteger, Long> frequencyMap = Arrays.stream(a)
	            .collect(Collectors.groupingBy(
	                    Function.identity(),
	                    Collectors.counting())
	            );

		// if there is only one piece - there is no question
		if (N == 1)
			return D == 2 ? "1" : "2";
		
		// if three identical pieces - no need to cut
		for (BigInteger key : frequencyMap.keySet()) {
			if (frequencyMap.get(key)>=3)
				return "0";
		}
		// if two pieces and only 2 needed - no need to cut
		for (BigInteger pieceSize : frequencyMap.keySet()) {
			if (frequencyMap.get(pieceSize)>=2) {
				if (D == 2) 
					return "0";
				if (frequencyMap.keySet().stream().anyMatch(v -> v.compareTo(pieceSize) > 0))
					return "1";
			}
		}

		// can make 2 identical size from any one piece
		if (D == 2)
			return "1";

		// D = 3
		// Maybe we can get by with one cut alone
		BigInteger two = new BigInteger("2");
		for (BigInteger pieceSize : frequencyMap.keySet()) {
			if (frequencyMap.containsKey(pieceSize.multiply(two)))
				return "1";
		}

		return "2";
	}
	
	
	private void tests() {
		singleTest("1 3\n1", "2");
		singleTest("5 2\n10 5 359999999999 123456789 10", "0");
		singleTest("2 3\n8 4", "1");
		singleTest("3 2\n1 2 3", "1");
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
