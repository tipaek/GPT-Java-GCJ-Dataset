import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q. PPR
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

	static class Pair implements Comparable<Pair> {
		int start;
		int end;
		char ans;
		Pair(int s, int e) {
			start = s;
			end = e;
		}
		public int compareTo(Pair o) {
			return start - o.start;
		}
	}


	Object doProblem() {
		int N = nint(); nline();
		Pair[] times = new Pair[N];

		for (int i=0; i<N; i++){
			times[i] = new Pair(nint(), nint());
			nline();
		}
		Pair[] sorted = times.clone();
		Arrays.sort(sorted);

		Pair lastc = null, lastj = null;

		for (int i=0; i<N; i++) { //(Pair time : sorted) {
			Pair time = sorted[i];
			if (lastc == null || lastc.end <= time.start) {
				// no conflict
				lastc = time;
				time.ans = 'C';
			}
			else if (lastj == null || lastj.end <= time.start) {
				lastj = time;
				time.ans = 'J';
			}
			else return "IMPOSSIBLE";
		}
		
		char[] ans = new char[N];
		for (int i=0; i<N; i++) {
			ans[i] = times[i].ans;
		}

		return String.valueOf(ans);
	}
}