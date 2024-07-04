import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/

	static boolean done;
	static boolean query(int x, int y) throws IOException {
		if (done) {
			return true;
		}
		out.println(x + " " + y);
		out.flush();
		switch (scanString()) {
		case "CENTER":
			done = true;
			return true;
		case "HIT":
			return true;
		case "MISS":
			return false;
		default:
			exit(0);
			return false;
		}
	}

	static void solve() throws Exception {
		done = false;
		int x, y;
		x: for (x = -500000000;; x += 500000000) {
			for (y = -500000000; y <= 500000000; y += 500000000) {
				if (query(x, y)) {
					break x;
				}
			}
			if (x == 500000000) {
				throw new AssertionError();
			}
		}
		int x1, x2, y1, y2;
		{
			int l = x, r = 1000000000;
			while (l < r) {
				int m = (l + r + 1) >> 1;
				if (query(m, y)) {
					l = m;
				} else {
					r = m - 1;
				}
			}
			x1 = l;
		}
		{
			int l = -1000000000, r = x;
			while (l < r) {
				int m = (l + r) >> 1;
				if (query(m, y)) {
					r = m;
				} else {
					l = m + 1;
				}
			}
			x2 = r;
		}
		{
			int l = y, r = 1000000000;
			while (l < r) {
				int m = (l + r + 1) >> 1;
				if (query(x, m)) {
					l = m;
				} else {
					r = m - 1;
				}
			}
			y1 = l;
		}
		{
			int l = -1000000000, r = y;
			while (l < r) {
				int m = (l + r) >> 1;
				if (query(x, m)) {
					r = m;
				} else {
					l = m + 1;
				}
			}
			y2 = r;
		}
		query((x1 + x2) >> 1, (y1 + y2) >> 1);
		if (!done) {
			throw new AssertionError();
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
			scanInt();
			scanInt();
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