import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q. Vestigium
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
			sout.println("Case #" + t + ": " + String.valueOf(
					new Solution().doProblem()
			));
		}
	}

	Object doProblem() {
		int N = nint(); nline();
		int r = 0;
		int c = 0;
		int[][] grid = new int[N][N];
		int diag = 0;
		for (int i=0; i<N; i++) {
			boolean[] row = new boolean[N];
			int add = 0;
			for (int j=0; j<N; j++) {
				int v = grid[i][j] = nint();
				if (i==j) diag += v;
				if (row[v-1]) add = 1;
				else row[v-1] = true;
			}
			r += add;
			nline();
		}
		for (int i=0; i<N; i++) {
			boolean[] col = new boolean[N];
			int add = 0;
			for (int j=0; j<N; j++) {
				int v = grid[j][i];
				if (col[v-1]) add = 1;
				else col[v-1] = true;
			}
			c += add;
		}
		return diag + " " + r + " " + c;
	}
}