import java.util.*;
import java.io.*;
import java.lang.Math;

// java Solution < input.txt > output.txt
// java Solution < input.txt > output.txt; cat output.txt
// https://code.google.com/codejam/resources/quickstart-guide
// https://code.google.com/codejam/resources/faq

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int tt = in.nextInt();
			// in.next();
			in.nextLine();

			// Each Problem
			String longestRightPattern = "";
			boolean impossible = false;
			for (int j = 0; j < tt; j++) {
				String pattern = in.nextLine();
				String rightPattern = pattern.substring(1);

				// Algo 1: Get longest string, match shorter strings to that longer string
				if (rightPattern.length() > longestRightPattern.length()) {
					if (rightPattern.contains(longestRightPattern)) {
						longestRightPattern = rightPattern;
					} else {
						impossible = true;
					}
				}
				if (longestRightPattern.contains(rightPattern)) {
					// Yes, short string within long string
				} else {
					impossible = true;
				}

				if (debug) {
					System.out.println("Pattern: " + pattern + ". Longest: " + longestRightPattern + ". Right Pattern: " + rightPattern);
					// System.out.println("Impossible: " + impossible);
				}
			}
			String answer = longestRightPattern;
			if (impossible) { answer = "*"; }
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
