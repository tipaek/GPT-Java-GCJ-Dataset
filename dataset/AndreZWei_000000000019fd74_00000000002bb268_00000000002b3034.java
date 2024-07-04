import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int d = in.nextInt();
	      String[] arr = new String[d];
	      for (int cnt = 0; cnt < d; cnt++) arr[cnt] = in.next();
	      System.out.println("Case #" + i + ": " + solve(arr));
	    }
  	}

  	public static String solve(String[] arr){
  		String head = null;
  		String tail = null;
  		for (String s: arr) {
  			String[] tokens = s.split("\\*");
  			if (s.charAt(0) != '*') {
  				String h = tokens[0];
  				// System.out.println("h = " + h);
  				if (head == null) {
  					head = h;
  				} else if (h.length() > head.length() && h.substring(0, head.length()).equals(head)) {
  					head = h;
  				} else if (!(h.length() <= head.length() && head.substring(0, h.length()).equals(h))) {
  					return "*";
  				}
  			}

  			if (s.charAt(s.length()-1) != '*') {
  				String t = tokens[tokens.length-1];
  				// System.out.println("t = " + t);
  				if (tail == null) {
  					tail = t;
  				} else if (t.length() > tail.length() && t.substring(t.length()-tail.length(), t.length()).equals(tail)) {
  					tail = t;
  				} else if (!(t.length() <= tail.length() && tail.substring(tail.length()-t.length(), tail.length()).equals(t))) {
  					return "*";
  				}
  			}
  			// System.out.println();
  		}
  		// System.out.println("head = " + head + " tail = " + tail);

  		StringBuilder sb = new StringBuilder();
  		if (head != null) sb.append(head);
  		for (String s: arr) {
  			String[] tokens = s.split("\\*");
  			int start = s.charAt(0) == '*' ? 0 : 1;
  			int end = s.charAt(s.length()-1) == '*' ? tokens.length-1 : tokens.length-2;
  			for (int i = start; i <= end; i++) {
  				sb.append(tokens[i]);
  			}
  		}
  		if (tail != null) sb.append(tail);
  		return sb.toString();
  	}
}
