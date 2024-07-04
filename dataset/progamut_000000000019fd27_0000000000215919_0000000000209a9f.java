import java.util.*;
import java.io.*;

public class Solution {
	
	private static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		for (int i = 0; i < s.length(); i++) {
			int d = s.charAt(i) - '0';
			while (d > depth) {
				sb.append('(');
				depth++;
			}
			while (d < depth) {
				sb.append(')');
				depth--;
			}
			sb.append(s.charAt(i));
		}
		while (depth > 0) {
			depth--;
			sb.append(')');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			//System.out.println(s);
			System.out.println("Case #" + i + ": " + solution(s));
		}
	}
}