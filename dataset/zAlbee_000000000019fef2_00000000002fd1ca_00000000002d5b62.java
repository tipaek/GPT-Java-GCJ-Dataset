import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-R1B.
 * @author Albert Choi
 */
public class Solution {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}

	public static void main(String[] args) {
		int T = nint(); nline();
		for (int t=1; t<=T; t++) {
			sout.print("Case #" + t + ": ");
			new Solution().doProblem();
		}
	}

	int N;
	int X, Y;
	int Xa, Ya;
	
	void doProblem() {
		X = nint(); Y = nint(); nline();
		Xa = Math.abs(X);
		Ya = Math.abs(Y);
		nbit = new boolean [10];
		sbit = new boolean [10];
		ebit = new boolean [10];
		wbit = new boolean [10];

		if (bs(0)) {
			if (Ya != Y) {
				boolean[] tmp = nbit;
				nbit = sbit;
				sbit = tmp;
			}
			if (Xa != X) {
				boolean[] tmp = ebit;
				ebit = wbit;
				wbit = tmp;
			}
			for (int i=0; i<10; i++) {
				if (nbit[i]) sout.print('N');
				if (sbit[i]) sout.print('S');
				if (ebit[i]) sout.print('E');
				if (wbit[i]) sout.print('W');
			}
			sout.println();
		}
		else sout.println("IMPOSSIBLE");
	}

	int n, s, e, w;
	boolean[] nbit, sbit, ebit, wbit;
	boolean xowe, yowe;
	
	boolean bs(int i) {
		int xi = (Xa >> i) & 1;
		int yi = (Ya >> i) & 1;
		
		// desired 1 
		boolean xd = (xi == 1) ^ xowe;
		boolean yd = (yi == 1) ^ yowe;
		
		if (xd != yd) {
			if (xd) {
				nbit[i] = false;
				sbit[i] = false;
				// yowe = yowe;
				
				boolean oldxo = xowe;

				ebit[i] = true;
				wbit[i] = false;
				xowe = false;
				if (bs(i+1)) return true;

				ebit[i] = false;
				wbit[i] = true;
				xowe = true;
				if (bs(i+1)) return true;
				
				// backtrack
				xowe = oldxo;
			} else {
				ebit[i] = false;
				wbit[i] = false;
				// xowe = xowe

				boolean oldyo = yowe;
				nbit[i] = true;
				sbit[i] = false;
				yowe = false;
				if (bs(i+1)) return true;

				nbit[i] = false;
				sbit[i] = true;
				yowe = true;
				if (bs(i+1)) return true;

				// backtrack
				yowe = oldyo;
			}
			return false;
		}
		
		else if (xd) { // both desire 1
			return false;// impossible
		}
		
		else { // both desire 0
			if (!xowe && !yowe) {
				if (Xa >> i == 0 && Ya >> i == 0) return true;
			}
			return false; 
		}
		
	}
}