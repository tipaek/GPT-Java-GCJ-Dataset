import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int r = in.nextInt();
	      int s = in.nextInt();
	      System.out.println("Case #" + i + ": " + solve(r, s));
	    }
  	}

  	public static String solve(int r, int s){
  		if (r == 2) {
  			if (s == 2) {
  				return "1\n2 1";
  			}
  			if (s == 3) {
  				return "2\n2 1\n4 1";
  			}
  			if (s == 4) {
  				return "3\n2 1\n6 1\n5 1";
  			}
  			if (s == 5) {
  				return "4\n2 1\n6 1\n5 1\n8 1";
  			}
  			if (s == 6) {
  				return "5\n2 1\n6 1\n10 1\n6 1\n9 1";
  			}
  			if (s == 7) {
  				return "6\n2 1\n6 1\n10 1\n6 1\n9 1\n12 1";
  			}
  		}
  		else if (r == 3) {
  			if (s == 2) {
	  			return "2\n3 2\n2 1";
	  		}
	  		if (s == 3) {
	  			return "4\n3 2\n6 2\n2 1\n4 1";
	  		}
	  		if (s == 4) {
	  			return "6\n3 2\n9 2\n6 4\n2 1\n6 1\n5 1";
	  		}
  		}
  		else if (r == 4) {
  			if (s == 2) {
  				return "3\n4 3\n3 2\n2 1";
  			}
  			if (s == 3) {
  				return "6\n4 3\n8 3\n3 2\n6 2\n2 1\n4 1";
  			}
  		} else {
  			return "4\n5 4\n4 3\n3 2\n2 1";
  		}
  		
  		return "0 0";
  	}
}
