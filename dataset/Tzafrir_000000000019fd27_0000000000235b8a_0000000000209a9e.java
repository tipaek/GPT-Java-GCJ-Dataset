import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	private int B;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		B = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < T; i++) {
			String res = solve(scan);
			System.out.printf("%s\n", res);
			scan.nextLine();
			String valid = scan.nextLine();
			if (!"Y".equals(valid))
				return;
		}
//		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private String solve(Scanner scan) {
		int[] res = new int[B];

		// setup
		for (int i = 0; i < 5; i++) {
			res[i] = query(scan, i);
			res[B - i - 1] = query(scan, B - i - 1);
		}

		int index = 5;
		for (int cycle = 1; cycle < 15; cycle++) {
			quantomRestore(scan, res, index);
			int end = index + 4;
			for (; index < end; index++) {
				if (index == B / 2) {
					return String.join("",
							Arrays.stream(res).mapToObj(k -> String.valueOf(k)).collect(Collectors.joining("")));
				}
				res[index] = query(scan, index);
				res[B - index - 1] = query(scan, B - index - 1);
			}
		}
		return null;
	}

	private int query(Scanner scan, int i) {
		if (i < 0) {
			System.out.println(1);
//			System.err.println("read pos 1");
		} else {
			System.out.println(i + 1);
//			System.err.println("read pos " + (i + 1));
		}
		int res = scan.nextInt();
//		System.err.println("Read value " + res);
		return res;
	}

	private void quantomRestore(Scanner scan, int[] res, int numItemsReadFromStart) {
		int identicalPos = firstIdenticalIndex(res, numItemsReadFromStart);
		int identicalVal = query(scan, identicalPos);

		int differentPos = firstDifferentIndex(res, numItemsReadFromStart);
		int differentVal = query(scan, differentPos);

		boolean should_flip = false;
		if (identicalPos >= 0) {
			if (res[identicalPos] != identicalVal) { // identical value pair only change on flip
				should_flip = true;
			}
		}
		boolean should_reverse = false;
		if (differentPos >= 0) { // different value pair
			if (res[differentPos] != differentVal && !should_flip) {
				should_reverse = true;
			} else if (res[differentPos] == differentVal && should_flip) {
				should_reverse = true;
			}
		}
		if (should_flip)
			flip(res);
		if (should_reverse)
			reverse(res);
	}

	private void flip(int[] res) {
//		System.err.println("Flip before: " + Arrays.toString(res));
		for (int i = 0; i < res.length; i++)
			res[i] = res[i] == 0 ? 1 : 0;
//		System.err.println("Flip after: " + Arrays.toString(res));
	}

	private void reverse(int[] res) {
//		System.err.println("Reverse before: " + Arrays.toString(res));
		for (int i = 0; i < res.length / 2; i++) {
			int temp = res[i];
			res[i] = res[res.length - i - 1];
			res[res.length - i - 1] = temp;
		}
//		System.err.println("Reverse after: " + Arrays.toString(res));
	}

	private int firstIdenticalIndex(int[] res, int numItemsRead) {
		for (int i = 0; i < numItemsRead; i++) {
			if (res[i] == res[B - i - 1])
				return i;
		}
		return -1;
	}

	private int firstDifferentIndex(int[] res, int numItemsRead) {
		for (int i = 0; i < numItemsRead; i++) {
			if (res[i] != res[B - i - 1])
				return i;
		}
		return -1;
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
