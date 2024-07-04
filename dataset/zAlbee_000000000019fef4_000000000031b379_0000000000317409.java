import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-R1C.
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

	static class Pair {
		int a, b;
		Pair(int aa, int bb) {a=aa;b=bb;}
	}

	int X, Y, N;
	Pair[] path;
	int[] dists;
	void doProblem() {
		X = nint();
		Y = nint();
		String M = nline().trim();
		N = M.length();
		path = new Pair[N+1];
		dists = new int[N+1];
		
		path[0] = new Pair(X, Y);
		dists[0] = dist(path[0]);

		for (int i=0;i<N;i++){
			Pair last = path[i];
			int x, y;
			switch (M.charAt(i)) {
			case 'N':
				x = last.a;
				y = last.b + 1;
				break;
			case 'S':
				x = last.a;
				y = last.b - 1;
				break;
			case 'E':
				x = last.a + 1;
				y = last.b;
				break;
			case 'W':
				x = last.a - 1;
				y = last.b;
				break;
			default: throw new RuntimeException();
			}
			Pair p = path[i+1] = new Pair(x, y);
			int d = dists[i+1] = dist(p);
			
			if (d <= i+1) {
				sout.println(i+1);
				return;
			}
		}
		sout.println("IMPOSSIBLE");
	}
	
	int dist(Pair p) {
		return Math.abs(p.a) + Math.abs(p.b);
	}
}