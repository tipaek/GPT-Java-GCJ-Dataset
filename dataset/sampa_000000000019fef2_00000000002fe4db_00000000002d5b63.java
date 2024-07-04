import java.util.*;

public class Solution {

	private static int cnt = 0;
	private static boolean done = false;

	private static String read(Scanner s, long X, long Y) throws Exception {
		if (cnt > 300) {
			throw new Exception("Limit exceeded.");
		}

		cnt++;
		System.out.println(X + " " + Y);
		String str = s.next();

		if (str.equals("WRONG")) {
			throw new Exception("Failed.");
		}

		return str;
	}

	private static long solve(Scanner s, boolean isx, boolean lb, long o) throws Exception {
		long l = -1000000000, r = 1000000000;
		long ret = lb ? Long.MAX_VALUE : Long.MIN_VALUE;
		
		while (l <= r) {
			long m = l + (r - l)/2;
			String str = read(s, isx?m:o, isx?o:m);
			if (str.equals("CENTER")) {
				done = true;
				return m;
			} else if (str.equals("HIT")){
				if (lb) {
					r = m - 1;
					ret = Math.min(ret, m);
				} else {
					l = m + 1;
					ret = Math.max(ret, m);
				}
			} else {
				if (lb) {
					l = m + 1;
				} else {
					r = m - 1;
				}				
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		int A = s.nextInt();
		int B = s.nextInt();

		for(int i = 1; i <= T; i++) {
			cnt = 0;
			done = false;

			long xl = solve(s, true, true, 0);
			if (!done) {
				long xr = solve(s, true, false, 0);
				long X = (xl+xr)/2;

				if (!done) {
					long yb = solve(s, false, true, X);
					if (!done) {
						long yu = solve(s, false, false, X);
						if (!done) {
							read(s, X, (yb+yu)/2);
						}
					}
				}
			}
		}

		s.close();
	}
}