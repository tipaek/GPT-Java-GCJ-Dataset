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
	
	static int A, B;
	public static void main(String[] args) {
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
			sout.println("DIE");
			getrc();
		}
		else {
			
			sout.println("DIE");
			getrc();
		}
	}
}