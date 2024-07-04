import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	private void solve() {
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			long l = nextLong();
			long r = nextLong();
			boolean swap = false;
			if (l < r) {
				long t = r;
				r = l;
				l = t;
				swap = true;
			}
			long skip = fits(l - r);
			l -= skip * (skip + 1) / 2;
			if (l == r) {
				swap = false;
			}
			long moreLeft = maxFits(l, skip + 1);
			long moreRight = maxFits(r, skip + 2);
			if (moreLeft > moreRight + 1) {
				moreLeft = moreRight + 1;
			}
			if (moreRight > moreLeft) {
				moreRight = moreLeft;
			}
			long ans = skip + Math.max(2 * moreLeft - 1, 2 * moreRight);
			l -= (skip + 1) * moreLeft + moreLeft * (moreLeft - 1);
			r -= (skip + 2) * moreRight + moreRight * (moreRight - 1);
			if (swap) {
				long t = l;
				l = r;
				r = t;
			}
			out.println(ans + " " + l + " " + r);
		}
	}

	private long maxFits(long value, long start) {
		BigInteger left = BigInteger.ZERO;
		BigInteger right = BigInteger.valueOf(value + 1);
		while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
			BigInteger m = left.add(right).divide(BigInteger.TWO);
			BigInteger sum = m.multiply(BigInteger.valueOf(start)).add(m.multiply(m.subtract(BigInteger.ONE)));
			if (sum.compareTo(BigInteger.valueOf(value)) > 0) {
				right = m;
			} else {
				left = m;
			}
		}
		return left.longValue();
	}

	private long fits(long n) {
		BigInteger l = BigInteger.ZERO;
		BigInteger r = BigInteger.valueOf(n);
		while (r.subtract(l).compareTo(BigInteger.ONE) > 0) {
			BigInteger m = l.add(r).divide(BigInteger.TWO);
			BigInteger sum = m.multiply(m.add(BigInteger.ONE)).divide(BigInteger.TWO);
			if (sum.compareTo(BigInteger.valueOf(n)) > 0) {
				r = m;
			} else {
				l = m;
			}
		}
		return l.longValue();
	}
}
