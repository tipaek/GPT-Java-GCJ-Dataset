import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			String res = process(s);
			System.out.println("Case #" + i + ": " + res);
		}
	}

	private static String process(String s) {
		StringBuilder sb = new StringBuilder();
		int curDepth = 0;
		for (char c : s.toCharArray()) {
			int i = Character.getNumericValue(c);
			if (curDepth != i) {
				sb.append(delta(i - curDepth));
				curDepth = i;
			}
			sb.append(i);
		}
		sb.append(delta(-curDepth));
		return sb.toString();
	}

	private static String delta(int d) {
		if (d == 0) {
			return "";
		} else if (d > 0) {
			return String.join("", Collections.nCopies(d, "("));
		} else {
			return String.join("", Collections.nCopies(-d, ")"));
		}
	}
}
