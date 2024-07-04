import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/77471

	static void sortBy(int a[], int n, int v[]) {
		if (n == 0) {
			return;
		}
		for (int i = 1; i < n; i++) {
			int j = i;
			int ca = a[i];
			int cv = v[ca];
			do {
				int nj = (j - 1) >> 1;
				int na = a[nj];
				if (cv <= v[na]) {
					break;
				}
				a[j] = na;
				j = nj;
			} while (j != 0);
			a[j] = ca;
		}
		int ca = a[0];
		for (int i = n - 1; i > 0; i--) {
			int j = 0;
			while ((j << 1) + 2 + Integer.MIN_VALUE < i + Integer.MIN_VALUE) {
				j <<= 1;
				j += (v[a[j + 2]] > v[a[j + 1]]) ? 2 : 1;
			}
			if ((j << 1) + 2 == i) {
				j = (j << 1) + 1;
			}
			int na = a[i];
			a[i] = ca;
			ca = na;
			int cv = v[ca];
			while (j != 0 && v[a[j]] < cv) {
				j = (j - 1) >> 1;
			}
			while (j != 0) {
				na = a[j];
				a[j] = ca;
				ca = na;
				j = (j - 1) >> 1;
			}
		}
		a[0] = ca;
	}

	static void solve() throws Exception {
		int c = scanInt(), d = scanInt();
		int x[] = new int[c];
		int idx[] = new int[c];
		for (int i = 1; i < c; i++) {
			x[i] = scanInt();
			idx[i] = i;
		}
		sortBy(idx, c, x);
		int u[] = new int[d], v[] = new int[d];
		for (int i = 0; i < d; i++) {
			u[i] = scanInt() - 1;
			v[i] = scanInt() - 1;
		}
		int p1;
		for (p1 = 0; idx[p1] != 0; p1++) { }
		int p2 = p1, p = 1, t = 0;
		while (p < c) {
			if (p1 > 0 && x[idx[p1 - 1]] == -p) {
				++t;
				for (--p1; p1 >= 0 && x[idx[p1]] == -p; p1--) {
					x[idx[p1]] = t;
				}
				++p1;
			} else {
				t = x[idx[p2 + 1]];
				for (++p2; p2 < c && x[idx[p2]] == t; p2++) { }
				--p2;
			}
			p = p2 - p1 + 1;
		}
		printCase();
		for (int i = 0; i < d; i++) {
			out.print(max(abs(x[u[i]] - x[v[i]]), 1) + " ");
		}
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