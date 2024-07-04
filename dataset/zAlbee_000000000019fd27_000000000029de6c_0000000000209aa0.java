import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q. Indicium (brute force solution, for small set only)
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

	static class Pair {
		int a, b;
		Pair(int aa, int bb) {a=aa;b=bb;}
	}

	Object doProblem() {
		N = nint();
		K = nint(); nline();
		used = new boolean[N];
		perm = new int[N];
		rowOrder = new int[N];
		rowUsed = new boolean[N];

		boolean found = permute(0);

		String s = (found ? "":"IM") + "POSSIBLE";
		
		if (found) {
			for (int i=0;i<N;i++) {
				int shift = rowOrder[i];
				s += "\n";
				for (int j=0;j<N;j++){
					s += perm[Math.floorMod(j-shift, N)] + " ";
				}
			}
		}
		return s;
	}
	
	int[] perm;
	int N;
	int K;
	boolean[] used;
	
	boolean permute(int i) {
		if (i == N) {
			rowOrder[0] = 0;
			return (permuteRows(1));
		}
		
		for (int j=0; j<N; j++) {
			if (!used[j]) {
				used[j] = true;
				perm[i] = j+1;

				if (permute(i+1)) {
					return true;
				}

				used[j] = false;
			}
		}
		return false;
	}

	int[] rowOrder;
	boolean[] rowUsed;

	boolean permuteRows(int i) {
		if (i == N) {
			//add
			int sum = 0;
			int ri = 0;
			for (int r : rowOrder) {
				// shift = r - ri
				sum += perm[ Math.floorMod( r-ri, N) ];
				ri++;
			}
			if (sum == K) return true;
		}
		for (int j=1;j<N;j++){
			if (!rowUsed[j]) {
				rowUsed[j] = true;
				rowOrder[i] = j;

				if (permuteRows(i+1)) {
					return true;
				}
				rowUsed[j] = false;
			}
		}
		return false;
	}
}