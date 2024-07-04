import java.util.*;
import java.io.*;
import java.lang.Math;

// java Solution < input.txt > output.txt
// java Solution < input.txt > output.txt; cat output.txt
// https://code.google.com/codejam/resources/quickstart-guide
// https://code.google.com/codejam/resources/faq
// https://github.com/ellengz/CodeJam/tree/master/src/y2018/qualification/A

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
			if (debug) {
				System.out.println("test");
			}
		}
	}
}