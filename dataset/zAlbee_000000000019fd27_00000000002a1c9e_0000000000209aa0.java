import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q. (actual brute force)
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
		N = nint();
		K = nint(); nline();
		grid = new int[N][N];
		ru = new boolean[N][N];
		cu = new boolean[N][N];

		boolean found = solve(0, 0);

		String s = (found ? "":"IM") + "POSSIBLE";
		
		if (found) {
			for (int i=0;i<N;i++) {
				s += "\n";
				for (int j=0;j<N;j++){
					s += (j==0 ? "":" ") + grid[i][j];
				}
			}
		}
		return s;
	}
	
	int[][] grid;
	int N;
	int K;
	boolean[][] ru, cu;
	
	boolean solve(int r, int c) {
		if (r == N && c == 0) {
			int sum = 0;
			for (int i=0;i<N;i++){
				sum += grid[i][i];
			}
			//serr.println(sum);
			return sum == K;
		}
		
		for (int j=0; j<N; j++) {
			if (!ru[r][j] && !cu[c][j]) {
				ru[r][j] = cu[c][j] = true;
				grid[r][c] = j+1;

				if (c == N-1) {
					if (solve(r+1, 0)) return true;
				}
				else {
					if (solve(r, c+1)) return true;
				}
				ru[r][j] = cu[c][j] = false;
			}
		}
		return false;
	}
}