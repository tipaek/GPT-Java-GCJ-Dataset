import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static final char OPEN_BRACKET = '(';
	public static final char CLOSE_BRACKET = ')';

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			int open_brackets = 0;
			for(int j = 0 ; j < s.length() ; j++) {
				int current = Integer.parseInt(String.valueOf(s.charAt(j)));
				
				if(open_brackets <= current) {
					update((current-open_brackets), 0, s.charAt(j), sb);
				} else {
					update(0, (open_brackets - current), s.charAt(j), sb);
				}
				open_brackets = current;
				
				if(j == s.length() - 1) {
					update(open_brackets, sb);
				}
			}
			System.out.println("Case #" + i + ": " + sb.toString());
		}
		sc.close();
	}
	
	public static void update(int open, int close, char c, StringBuilder sb) {
		for (int i = 0; i < open; i++) {
			sb.append(Solution.OPEN_BRACKET);
		}

		for (int i = 0; i < close; i++) {
			sb.append(Solution.CLOSE_BRACKET);
		}
		
		sb.append(c);
	}
	
	public static void update(int close, StringBuilder sb) {
		for (int i = 0; i < close; i++) {
			sb.append(Solution.CLOSE_BRACKET);
		}
	}
}