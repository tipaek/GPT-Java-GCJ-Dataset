import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      String s = in.next();
	      System.out.println("Case #" + i + ": " + solve(s));
	    }
  	}

  	public static String solve(String s){
  		StringBuilder sb = new StringBuilder();
  		int prev = 0;
  		for (char c: s.toCharArray()) {
  			int cur = (int) (c - '0');
  			if (cur > prev) {
  				for (int i = prev; i < cur; i++) sb.append('(');
  			} else if (cur < prev) {
  				for (int i = cur; i < prev; i++) sb.append(')');
  			}
  			sb.append(c);
  			prev = cur;
  		}
  		for (int i = prev; i > 0; i--) sb.append(')');
  		return sb.toString();
  	}	
}
