import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      long l = in.nextLong();
	      long r = in.nextLong();
	      System.out.println("Case #" + i + ": " + solve(l, r));
	    }
  	}

  	public static String solve(long l, long r){
  		long diff = Math.abs(r-l);
  		long[] res = binSearchForSum(diff);

  		long[] solL = new long[2], solR = new long[2];
  		long lRest = l, rRest = r;
  		if (l > r) {
  			rRest = r;
  			lRest = l - res[1];
  			solL = binSearchForPartSum(res[0]+1, lRest);
  			solR = binSearchForPartSum(res[0]+2, rRest);
  		} else {
  			lRest = l;
  			rRest = r -res[1];
  			if (lRest == rRest) {
  				solL = binSearchForPartSum(res[0]+1, lRest);
  				solR = binSearchForPartSum(res[0]+2, rRest);
  			} else {
  				solL = binSearchForPartSum(res[0]+2, lRest);
  				solR = binSearchForPartSum(res[0]+1, rRest);
  			}
  		}
  		long count = res[0]+solL[0]+solR[0];
  		return count + " " + (lRest-solL[1]) + " " + (rRest-solR[1]);
  	}

  	private static long[] binSearchForSum(long target) {
  		long l = 0, r = (long) 1e10;
  		while (l < r) {
  			long mid = r-(r-l)/2;
  			long sum = (1+mid)*mid/2;
  			if (sum <= target) {
  				l = mid;
  			} else {
  				r = mid-1;
  			}
  		}
  		return new long[]{l, (1+l)*l/2};
  	}

  	private static long[] binSearchForPartSum(long start, long target) {
  		long l = 0, r = (long) 1e10;
  		while (l < r) {
  			long mid = r-(r-l)/2;
  			long sum = (start + mid - 1) * mid;
  			if (sum > target) {
  				r = mid-1;
  			} else {
  				l = mid;
  			}
  		}
  		return new long[]{l, (start+l-1) * l};
  	}
}
