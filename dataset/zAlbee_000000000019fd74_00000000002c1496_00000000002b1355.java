import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-R1.
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

	int R, C;
	int skill[][];

	Object doProblem() {
		R=nint(); C=nint(); nline();
		skill = new int[R][C];
		for (int i=0;i<R;i++){
			for (int j=0;j<C;j++){
				skill[i][j] = nint();
			}
			nline();
		}

		long total = 0;

		while(true) {
			int elims = 0;
			int[][] count = new int[R][C];
			int[][] csum = new int[R][C];

			// by row
			for (int i=0;i<R;i++){
				int last = 0; // value
				int lastj = -1;
				
				for (int j=0;j<C;j++){
					int cur = skill[i][j]; 

					if (cur > 0) {
						if (lastj >= 0) {
							csum[i][j] += last;
							count[i][j] ++;
							csum[i][lastj] += cur;
							count[i][lastj] ++;
						}
						last = cur;
						lastj = j;
					}
				}
			}
			// by col
			for (int j=0;j<C;j++){
				int last = 0;
				int lasti = -1;
	
				for (int i=0;i<R;i++){
					int cur = skill[i][j]; 

					if (cur > 0) {
						if ( lasti >= 0) {
							csum[i][j] += last;
							count[i][j] ++;
							csum[lasti][j] += cur;
							count[lasti][j] ++;
						}
						last = cur;
						lasti = i;
					}
				}
			}

			for (int i=0;i<R;i++){
				for (int j=0;j<C;j++){
					int cur = skill[i][j]; 
					total += cur; // INTEREST

					if (cur > 0) {
						int thresh = cur * count[i][j];
						if (csum[i][j] > thresh) {
							elims++;
							skill[i][j] = 0;
						}
					}
				}
			}

			if (elims == 0) break;
		}
		return total;
	}
}