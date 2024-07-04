import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.abs;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/77471

	static void solve() throws Exception {
		long l = scanLong(), r = scanLong();
		long d = abs(l - r);
		long a = 0, b = 3000000000L;
		while (a < b) {
			long m = (a + b + 1) / 2;
			if (m * (m + 1) / 2 > d) {
				b = m - 1;
			} else {
				a = m;
			}
		}
		long n = a;
		if (l >= r) {
			l -= n * (n + 1) / 2;
		} else {
			r -= n * (n + 1) / 2;
		}
		a = n;
		b = 3000000000L;
		while (a < b) {
			long m = (a + b + 1) / 2;
			long m1 = (m - n) % 2 == 0 ? m - 1 : m;
			long m2 = (m - n) % 2 == 0 ? m : m - 1;
			long c1 = (n + 1 + m1) * ((m1 - n - 1) / 2 + 1) / 2;
			long c2 = (n + 2 + m2) * ((m2 - n - 2) / 2 + 1) / 2;
			if (l >= r ? l >= c1 && r >= c2 : r >= c1 && l >= c2) {
				a = m;
			} else {
				b = m - 1;
			}
		}
		long nn = a;
		long m1 = (nn - n) % 2 == 0 ? nn - 1 : nn;
		long m2 = (nn - n) % 2 == 0 ? nn : nn - 1;
		long c1 = (n + 1 + m1) * ((m1 - n - 1) / 2 + 1) / 2;
		long c2 = (n + 2 + m2) * ((m2 - n - 2) / 2 + 1) / 2;
		if (l >= r) {
			l -= c1;
			r -= c2;
		} else {
			r -= c1;
			l -= c2;
		}
		printCase();
		out.println(nn + " " + l + " " + r);
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static long scanLong() throws IOException {
		return parseLong(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	static void printCase() {
		out.print("Case #" + test + ": ");
	}

	static void printlnCase() {
		out.println("Case #" + test + ":");
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static int test;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			int tests = scanInt();
			for (test = 1; test <= tests; test++) {
				solve();
			}
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}