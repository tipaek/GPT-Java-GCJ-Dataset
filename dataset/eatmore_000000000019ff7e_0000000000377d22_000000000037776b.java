import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/78458

	static void solve() throws Exception {
		int k = scanInt(), n = scanInt();
		int x[] = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = scanInt();
		}
		for (int i = 0; i < n; i++) {
			scanInt();
		}
		int ans = n;
		long l = x[n - 1] - k, r = x[0];
		for (int i = 0; i < n; i++) {
			if (2L * x[i] - r >= (i == n - 1 ? x[0] + k : x[i + 1])) {
				++ans;
				l = i == 0 ? x[n - 1] - k : x[i - 1];
				r = x[i];
			}
			long nl = 2L * x[i] - r, nr = 2L * x[i] - l;
			l = max(nl, x[i]);
			r = min(nr, i == n - 1 ? x[0] + k : x[i + 1]);
		}
		if (ans == n) {
			if (n % 2 == 0) {
				long s0 = 0, s1 = 0;
				for (int i = 0; i < n; i += 2) {
					s0 += x[i];
					s1 += x[i + 1];
				}
				if (2 * (s1 - s0) != k) {
					++ans;
				}
			} else {
				long pp = 0;
				for (int i = 0; i < n - 1; i += 2) {
					pp += x[i];
					pp -= x[i + 1];
				}
				pp = 2 * (pp + x[n - 1]) + k;
				if (pp <= 2L * l || pp >= 2L * r) {
					++ans;
				}
			}
		}
		printCase();
		out.println(ans);
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