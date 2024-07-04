import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/71545

	static void solve() throws Exception {
		int n = scanInt();
		int k = 0, r = 0, c = 0;
		boolean haveC[][] = new boolean[n][n];
		boolean haveR[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			fill(haveR, false);
			boolean gotR = false;
			for (int j = 0; j < n; j++) {
				int a = scanInt();
				if (i == j) {
					k += a;
				}
				--a;
				if (haveC[j] != null) {
					if (haveC[j][a]) {
						++c;
						haveC[j] = null;
					} else {
						haveC[j][a] = true;
					}
				}
				if (haveR[a]) {
					gotR = true;
				} else {
					haveR[a] = true;
				}
			}
			if (gotR) {
				++r;
			}
		}
		printCase();
		out.println(k + " " + r + " " + c);
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