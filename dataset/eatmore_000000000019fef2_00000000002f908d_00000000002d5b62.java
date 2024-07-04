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

	// Discuss this round on Codeforces: https://codeforces.com/

	static void solve() throws Exception {
		long x = scanInt(), y = scanInt();
		if (((x ^ y) & 1) == 0) {
			printCase();
			out.println("IMPOSSIBLE");
			return;
		}
		char ans[] = new char[32];
		int cnt = 0;
		while (x != 0 || y != 0) {
			if ((x & (1L << cnt)) != 0) {
				if (((x ^ y) & (1L << (cnt + 1))) == 0 ^ (y == 0 && abs(x) == 1L << cnt)) {
					ans[cnt] = 'W';
					x += 1L << cnt;
				} else {
					ans[cnt] = 'E';
					x -= 1L << cnt;
				}
			} else {
				if (((x ^ y) & (1L << (cnt + 1))) == 0 ^ (x == 0 && abs(y) == 1L << cnt)) {
					ans[cnt] = 'S';
					y += 1L << cnt;
				} else {
					ans[cnt] = 'N';
					y -= 1L << cnt;
				}
			}
			++cnt;
		}
		printCase();
		out.write(ans, 0, cnt);
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