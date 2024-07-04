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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");

	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		long before = System.nanoTime();
// 		tests();
// 		System.err.println("Done testing");
// 		System.err.println("Took " + ((System.nanoTime() - before) / 1000000) + " ms");
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			String res = solve(scan);
			System.out.printf("Case #%d: %s\n", i, res);
			System.err.printf("Case #%d: %s\n", i, res);
		});
		scan.close();
	}

	private long sumOneToN(long n) {
		return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n + 1)).divide(BigInteger.valueOf(2)).longValue();
	}

	private long sumFromSToK(long s, long n) {
		BigInteger res = BigInteger.valueOf(n).multiply(BigInteger.valueOf(2 * s + 2 * (n - 1)))
				.divide(BigInteger.valueOf(2));
		if (res.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0)
			return Long.MAX_VALUE;
		return res.longValue();
	}

	private long estimatedN(long delta) {
		return (long) ((Math.sqrt(delta * 8 + 1) - 1) / 2);
	}

	private String solve(Scanner scan) {
		long l = scan.nextLong();
		long r = scan.nextLong();
		long max = l >= r ? l : r;
		// take from single pile first
		long delta = max - (l >= r ? r : l);
		long firstPileOnly = 0;
		if (delta > 0) {
			firstPileOnly = estimatedN(delta);
			if (l >= r) {
				l -= sumOneToN(firstPileOnly);
			} else {
				r -= sumOneToN(firstPileOnly);
			}

		}

		long s = firstPileOnly + 1;
		long n = 0;
		if (s <= l && s <= r) {
			n = binarySearch(s, Math.max(l, r), Math.min(l, r));
			if (l >= r) {
				l -= sumFromSToK(s, n);
				r -= sumFromSToK(s + 1, n);
			} else {
				r -= sumFromSToK(s, n);
				l -= sumFromSToK(s + 1, n);
			}
		}
		s += 2 * n;
		while (s <= Math.max(l, r)) {
			if (l >= r)
				l -= s;
			else
				r -= s;
			s++;
		}
		return (s - 1) + " " + l + " " + r;
	}

	private long binarySearch(long s, long biggerpile, long smallerpile) {
		long low = 1;
		long high = biggerpile;
		while (low <= high) {
			long med = (low + high) / 2;
			long pnacackebigger = sumFromSToK(s, med);
			long pnacackesmaller = sumFromSToK(s + 1, med);
			if (pnacackebigger <= biggerpile && pnacackesmaller <= smallerpile) {
				low = med + 1;
			} else {
				high = med - 1;
			}
		}
		return high;
	}

	private void tests() {
		singleTest("1 2", "1 1 1");
		singleTest("2 2", "2 1 0");
		singleTest("8 11", "5 0 4");
		singleTest("12233720368547758 12233720368547758", "221212298 171937557 61331408");
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
