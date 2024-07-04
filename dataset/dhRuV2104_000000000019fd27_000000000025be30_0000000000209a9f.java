import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			
		    String ans = getParentheses(s);
			
			System.out.println("Case #" + i + ": " + ans);

		}

	}

	private static String getParentheses(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		int c = s.charAt(0) - '0';
		char curr = s.charAt(0); 
		
		for(int i = 0;i<c;i++)
			sb.append("(");
		
	//	sb.append(curr);
		
		for(int i= 0;i<n;i++) {
			if(s.charAt(i) == curr) {
				sb.append(curr);
				continue;
			}
			
			int prev = curr - '0';
			curr = s.charAt(i);
			c = curr - '0';
			int diff = 0;
			if(prev > c) {
				diff = prev - c;
				for(int j = 0;j<diff;j++)
					sb.append(")");
			}
			else {
				diff = c - prev;
				for(int j = 0;j<diff;j++)
					sb.append("(");
			}
			sb.append(curr);
			
		}
		
		c = s.charAt(s.length() - 1) - '0';
		
		for(int i = 0;i<c;i++)
			sb.append(")");
		
		return sb.toString();
	}
}