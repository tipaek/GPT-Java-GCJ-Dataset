import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q.
 * @author Albert Choi
 */
public class SolutionIT {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}
	
	static int F;
	public static void main(String[] args) {
		int T = nint(); F = nint(); nline();
		for (int t=1; t<=T; t++) {
			new SolutionIT().doProblem();
		}
	}

	char getrc() {
		char c = nline().charAt(0);
		if (c == 'N') System.exit(0);
		return c;
	}
	
	long getrl() {
		long r = nlong();
		if (r == -1) System.exit(0);
		return r;
	}
	
	void doProblem() {
	}
}