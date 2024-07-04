package codejam.qualification.nestingdepth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
		final Scanner in =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//new Scanner(new BufferedReader(new FileReader("res/q2.txt")));
		final int nTestCases = in.nextInt();
		for (int i = 0; i < nTestCases; i++) {
			// input
			final String s = in.next();
			// magic
			final int[] ints = toInts(s);
			final StringBuilder sb = new StringBuilder();
			int depth = 0;
			for (int digit : ints) {
				final int diff = digit - depth;
				if (diff > 0) {
					for (int j = 0; j < diff; j++) {
						sb.append('(');
					}
				} else if (diff < 0) {
					for (int j = 0; j > diff; j--) {
						sb.append(')');
					}
				}
				sb.append(digit);
				depth = digit;
			}
			for (int j = 0; j < depth; j++) {
				sb.append(')');
			}
			// print
			System.out.println(String.format("Case #%d: %s", i + 1, sb.toString()));
		}
	}

	private static int[] toInts(String s) {
		final int[] ints = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ints[i] = Integer.parseInt(s.substring(i, i + 1));
		}
		return ints;
	}

}
