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

	public static void main(String[] args) {
		int T = nint(); nline();
		for (int t=1; t<=T; t++) {
			sout.println("Case #" + t + ": " + String.valueOf(
					new Solution().doProblem()
			));
		}
	}

	
	static class P {
		int a, b;
		char c;
		P(int aa, int bb) {a=aa;b=bb;}
	}
	Object doProblem() {
		int N = nint();
		P[] ps = new P[N];
		for (int i=0;i<N;i++){
			ps[i] = new P(nint(), nint());
			nline();
		}
		P[] pss = ps.clone();
		Arrays.sort(pss, (o, p) -> o.a - p.a);
		
		P lastc = null, lastj = null;
		
		for (int i=0;i<N;i++){
			P p = pss[i];
			if (lastc == null || lastc.b <= p.a) {
				lastc = p;
				p.c = 'C';
			}
			else if (lastj == null || lastj.b <= p.a) {
				lastj = p;
				p.c = 'J';
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		char[] ans = new char[N];
		int i=0;
		for (P p : ps) {
			ans[i++] = p.c;
		}

		return String.valueOf(ans);
	}
}