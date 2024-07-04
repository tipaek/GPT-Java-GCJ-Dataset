import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q.
 * @author Albert Choi
 */
public class Solution {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}
	
	static long A, B;
	static final long MAX_R = 1_000_000_000;
	static final long R2 = MAX_R - 50;
	static final long D = 70710674;
	
	public static void main(String[] args) {
		/*
		// 999_999_950
		long R50 = MAX_R - 50; 
		
		sout.println((MAX_R - 50) * (MAX_R - 50));  // 999_999_900_000_002_500
		// max diag
		double d = Math.sqrt( R50 * R50 / 2.0); // 7.071067458312085E8
		sout.println((long)d); // 707106745
		
		*/
		int T = nint(); A = nint(); B = nint(); nline(); 
		for (int t=1; t<=T; t++) {
			new Solution().doProblem();
		}
	}

	char getrc() {
		char c = nline().charAt(0);
		if (c == 'W') System.exit(0);
		return c;
	}

	char getrc(long x, long y) {
		sout.println(x +" "+y);
		return getrc();
	}
	
	void doProblem() {
		if (A == B && A == 1_000_000_000 - 5) {
			for (int i=-5; i<=5; i++) {
				for (int j=-5; j<=5; j++) {
					sout.println(i + " " + j);
					if (getrc() == 'C') return;
				}
			}
			
		}
		if (A == B && A == 1_000_000_000 - 50) {
			long a = bs(true, true);
			long b = bs(false, false);

			long c = bs(true, false);
			long d = bs(false, true);
			
			long m = (a-b)/2; // (m, m)
			
			//long n = c+d/2;
			
			long n = (c-d)/2;
			//long ny = (-c+d)/2;
			
			long x = (m-n)/2;
			long y = m-x;
			
			for (int i=-2; i<=2; i++) {
				for (int j=-2; j<=2; j++) {
					sout.println((x+i) + " " + (y+j));
					if (getrc() == 'C') return;
				}
			}
		}
		else {
			sout.println("DIE");
			getrc();
		}
	}
	
	long bs(boolean xp, boolean yp) {
		long xl = D - 50; // closer to center
		long xr = D + 51;
		
		while (xl < xr) {
			long xmid = (xl + xr / 2);
			long y = xmid * (yp? 1 : -1);
			
			char r = getrc(xmid * (xp? 1 : -1), y);
			if (r == 'H') {
				xl = xmid + 1;
			} else {// if (r == 'M') {
				xr = xmid;
			}
		}
		// xl >= xr
		return xl;
	}
	
}