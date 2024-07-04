import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int d = in.nextInt();
	      System.out.println("Case #" + i + ": \n" + solve(d));
	    }
  	}

  	public static String solve(int d){
  		if (d == 1) return "1 1";
  		if (d == 2) return "1 1\n2 2";
  		if (d == 3) return "1 1\n2 2\n2 1";
  		int c = 0, sum = 0;
  		while (sum <= d) {
  			c++;
  			sum += c;
  		}

  		int diff = d-(sum-c);
  		StringBuilder sb = new StringBuilder();
  		sb.append("1 1\n");
  		for (int i = 1; i < c; i++) {
  			sb.append(i+1);
  			sb.append(' ');
  			sb.append(2);
  			sb.append('\n');
  		}

  		for (int i = 0; i < diff-1; i++) {
  			sb.append(c-i);
  			sb.append(' ');
  			sb.append(1);
  			sb.append('\n');
  		}

  		return sb.toString().substring(0, sb.length()-1);
  	}
}
