import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.arraycopy;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/

	static void solve() throws Exception {
		int r = scanInt(), s = scanInt();
		int a1[] = new int[r * s], a2[] = new int[r * s];
		for (int i = 0; i < r * s; i++) {
			a1[i] = i % r;
		}
		printCase();
		out.println((r * (s - 1) + 1) / 2);
		for (int i = (r * (s - 1) + 1) / 2 - 1; i >= 0; i--) {
			int p1, p2;
			if (i == 0 && (r * (s - 1) & 1) != 0) {
				int j = 0;
				for (; a1[j] != 0; j++) { }
				p1 = j;
				p2 = r * s;
			} else {
				int j = 0;
				for (int k = 0; k < 2; k++) {
					for (++j; a1[j] == a1[j - 1]; j++) { }
				}
				p1 = j;
				for (int k = 0; k < r - 1; k++) {
					for (++j; a1[j] == a1[j - 1]; j++) { }
				}
				p2 = j;
			}
			out.println(p1 + " " + (p2 - p1));
			arraycopy(a1, 0, a2, p2 - p1, p1);
			arraycopy(a1, p1, a2, 0, p2 - p1);
			arraycopy(a1, p2, a2, p2, r * s - p2);
			int t[] = a1;
			a1 = a2;
			a2 = t;
		}
		for (int i = 0; i < r * s; i++) {
			if (a1[i] != i / s) {
				throw new AssertionError();
			}
		}
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