import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
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
		String s1 = scanString(), s2 = scanString();
		int n1 = s1.length(), n2 = s2.length();
		int minDist[][] = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			minDist[i][0] = i;
		}
		for (int i = 1; i <= n2; i++) {
			minDist[0][i] = i;
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				int v = min(minDist[i - 1][j], minDist[i][j - 1]) + 1;
				v = min(v, minDist[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1));
				minDist[i][j] = v;
			}
		}
		int p1 = n1, p2 = n2;
		int d1 = minDist[n1][n2] / 2, d2 = minDist[n1][n2] - d1;
		char ans[] = new char[n1 + n2];
		int ansLen = 0;
		while (p1 != 0 || p2 != 0) {
			if (p1 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2] + 1) {
				--p1;
				if (d1 != 0) {
					--d1;
				} else {
					ans[ansLen++] = s1.charAt(p1);
					--d2;
				}
			} else if (p2 != 0 && minDist[p1][p2] == minDist[p1][p2 - 1] + 1) {
				--p2;
				if (d2 != 0) {
					--d2;
				} else {
					ans[ansLen++] = s2.charAt(p2);
					--d1;
				}
			} else {
				if (p1 != 0 && p2 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2 - 1] && s1.charAt(p1 - 1) == s2.charAt(p2 - 1)) {
					ans[ansLen++] = s1.charAt(p1 - 1);
				} else if (p1 != 0 && p2 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2 - 1] + 1) {
					if (d1 != 0) {
						--d1;
						ans[ansLen++] = s2.charAt(p2 - 1);
					} else {
						--d2;
						ans[ansLen++] = s1.charAt(p1 - 1);
					}
				} else {
					throw new AssertionError();
				}
				--p1;
				--p2;
			}
		}
		for (int i = 0, j = ansLen - 1; i < j; i++, j--) {
			char t = ans[i];
			ans[i] = ans[j];
			ans[j] = t;
		}
		printCase();
		out.write(ans, 0, ansLen);
		out.println();
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