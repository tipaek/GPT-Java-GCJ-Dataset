import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int x = in.nextInt();
	      int y = in.nextInt();
	      System.out.println("Case #" + i + ": " + solve(x, y));
	    }
  	}

  	public static String solve(int a, int b){
  		boolean signX = a >= 0, signY = b >= 0;
  		int x = Math.abs(a), y = Math.abs(b);

  		int max = Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length());
  		// System.err.println(max);
  		boolean flag = true;
  		int reverseX = 0, reverseY = 0;
  		for (int i = 0; i < max; i++) {
  			int bx = (x >> i) & 1, by = (y >> i) & 1;
  			if (bx == by) {
  				// System.err.println(i);
  				if (i == 0) return "IMPOSSIBLE";
  				if (((x >>(i-1)) & 1) == 1) {
  					// System.err.println(i);
  					reverseX += (1<<(i-1));
  					x += (1<<(i-1));
  				}
  				if (((y>>(i-1)) & 1) == 1) {
  					reverseY += (1<<(i-1));
  					y += (1<<(i-1));
  				}
  			}
  			max = Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length());
  		}

  		StringBuilder sb = new StringBuilder();
  		if (!signX) {
  			int tmp = x;
  			x = reverseX;
  			reverseX = tmp;
  		}
  		if (!signY) {
  			int tmp = y;
  			y = reverseY;
  			reverseY = tmp;
  		}
  		// System.err.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(reverseX));
  		// System.err.println(Integer.toBinaryString(y) + " " + Integer.toBinaryString(reverseY));
  		for (int i = 0; i < max; i++) {
  			if (((x >> i) & 1) == 1) {
  				sb.append('E');
  			} else if (((reverseX >> i) & 1) == 1) {
  				sb.append('W');
  			} else if (((y >> i) & 1) == 1) {
  				sb.append('N');
  			} else if (((reverseY >> i) & 1) == 1) {
  				sb.append('S');
  			}
  		}  		
  		return sb.toString();
  	}
}
