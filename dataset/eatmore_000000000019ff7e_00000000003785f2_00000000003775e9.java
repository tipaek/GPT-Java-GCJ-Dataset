import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/78458

	static class Shift {
		final long x, y;

		Shift(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (x ^ (x >>> 32));
			result = prime * result + (int) (y ^ (y >>> 32));
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Shift other = (Shift) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static void solve() throws Exception {
		int n = scanInt();
		long d = scanLong();
		long x[] = new long[n], y[] = new long[n];
		for (int i = 0; i < n; i++) {
			long xx = scanLong(), yy = scanLong();
			x[i] = xx + yy;
			y[i] = xx - yy;
		}
		TreeSet<Long> xs = new TreeSet<>(), ys = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					xs.add(x[i] + x[j] - x[k] - d);
					xs.add(x[i] + x[j] - x[k] + d);
					ys.add(y[i] + y[j] - y[k] - d);
					ys.add(y[i] + y[j] - y[k] + d);
				}
			}
		}
		int xn = xs.size();
		long xss[] = new long[xn];
		{
			Iterator<Long> it = xs.iterator();
			for (int i = 0; i < xn; i++) {
				xss[i] = it.next();
			}
		}
		int yn = ys.size();
		long yss[] = new long[yn];
		{
			Iterator<Long> it = ys.iterator();
			for (int i = 0; i < yn; i++) {
				yss[i] = it.next();
			}
		}
		long total = 0;
		long dist = 0;
		for (int xi = 0; xi < xn - 1; xi++) {
			yi: for (int yi = 0; yi < yn - 1; yi++) {
				long cx = xss[xi], cy = yss[yi];
				HashSet<Shift> shifts = new HashSet<>();
				int p1 = -1;
				for (int i = 0; i < n; i++) {
					if (x[i] > cx - d && x[i] <= cx + d && y[i] > cy - d && y[i] <= cy + d) {
						shifts.add(new Shift(x[i] - cx, y[i] - cy));
						p1 = i;
					}
				}
				if (p1 < 0) {
					continue;
				}
				long area = (xss[xi + 1] - xss[xi]) * (yss[yi + 1] - yss[yi]);
				total += area;
				int nShifts = shifts.size();
				p2: for (int p2 = 0; p2 < n; p2++) {
					if (p2 == p1) {
						continue;
					}
					long nx = cx + x[p2] - x[p1];
					long ny = cy + y[p2] - y[p1];
					int nShifts2 = 0;
					for (int i = 0; i < n; i++) {
						if (x[i] > nx - d && x[i] <= nx + d && y[i] > ny - d && y[i] <= ny + d) {
							if (shifts.contains(new Shift(x[i] - nx, y[i] - ny))) {
								++nShifts2;
							} else {
								continue p2;
							}
						}
					}
					if (nShifts2 == nShifts) {
						continue yi;
					}
				}
				dist += area;
			}
		}
		long gcd = gcd(total, dist);
		total /= gcd;
		dist /= gcd;
		printCase();
		out.println(dist + " " + total);
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