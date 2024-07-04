import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int t = 1; t <= T; ++t) {
			String S = in.next();
			String answer = nestedString(S, 0);
			
			
			System.out.println("Case #" + t + ": " + answer);

		}
	}

	private static String nestedString(String s, int deduction) {
		if (s.length() == 0)
			return s;
		
		int min = min(s);
		
		int prev = 0;
		String ans = "";
		for (int curr = 0; curr < s.length(); curr++) {
			if (s.charAt(curr) - '0' == min) {
				ans = ans + nestedString(s.substring(prev, curr), min) + min;
				prev = curr + 1;
			}
		}
		ans = ans + nestedString(s.substring(prev, s.length()), min);
		StringBuilder sb = new StringBuilder();
		
		int noOfParentheses = min - deduction;
		for (int i = 0; i < noOfParentheses; i++) {
			sb.append('(');
		}
		sb.append(ans);
		for (int i = 0; i < noOfParentheses; i++) {
			sb.append(')');
		}
		return sb.toString();
	}

	private static int min(String s) {
		if (s == null || s.length() == 0)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			min = Math.min(min,  s.charAt(i) - '0');
		}
		return min;
	}
}