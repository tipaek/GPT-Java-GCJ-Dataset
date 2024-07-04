import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		for (int t = 1; t <= cases; t++) {
			long l = sc.lg();
			long r = sc.lg();
			// debug(l, r);
			boolean flipped = false;

			if (l < r) {
				flipped = !flipped;
				long tt = l;
				l = r;
				r = tt;
			}

			long lo = 0;
			long hi = 2_000_000_000;

			while (lo < hi) {
				long mid = (lo + hi + 1) / 2;

				if (slice(0, mid) > l - r) {
					hi = mid - 1;
				} else {
					lo = mid;
				}
			}

			l -= slice(0, lo);

			long next = lo;
			// debug("!", next, l, r);

			if (l == r) {
				flipped = false;
			}

			if (next % 2 == 1) {
				if (next > l) {
					pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
					continue;
				}

				l -= next;
				next++;
				flipped = !flipped;
				long tt = l;
				l = r;
				r = tt;
			}

			if (l == r) {
				flipped = false;
			}

			// l is evens, r is odds
			// next is always even

			lo = next / 2;
			hi = 1_000_000_000;
			// debug("start of loop", next, l, r);

			while (lo < hi) {
				long mid = (lo + hi + 1) / 2;
				long value = mid * 2;

				// debug(mid, next, value, eslice(next, value), oslice(next + 1, value + 1), l, r);

				if (eslice(Math.max(next - 2, 0), value) > l || oslice(Math.max(next - 1, 0), value + 1) > r) {
					hi = mid - 1;
				} else {
					lo = mid;
				}
			}

			// debug(">", lo);

			long value = lo * 2;

			l -= eslice(next, value);
			r -= oslice(next + 1, value + 1);

			next = value;

			// debug(">>", next, l, r);

			while (true) {
				if (next % 2 == 0) {
					if (next > l) {
						pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
						break;
					} else {
						l -= next;
					}
				} else {
					if (next > r) {
						pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
						break;
					} else {
						r -= next;
					}
				}

				next++;
			}
		}

		pw.close();
		sc.close();
	}

	static long slice(long a, long b) {
		b--;
		a--;
		a = Math.max(a, 0);
		return (b * (b + 1) - a * (a + 1)) / 2;
	}

	static long eslice(long a, long b) {
		a /= 2;
		b /= 2;
		return slice(a, b) * 2;
	}

	static long oslice(long a, long b) {
		a /= 2;
		b /= 2;
		return slice(a, b) * 2 + (b - a);
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	public static void debug(Object obj, String end) {
		if (DEBUG) {
			if (obj instanceof boolean[]) {
				System.out.print(Arrays.toString((boolean[])obj));
			} else if (obj instanceof byte[]) {
				System.out.print(Arrays.toString((byte[])obj));
			} else if (obj instanceof short[]) {
				System.out.print(Arrays.toString((short[])obj));
			} else if (obj instanceof char[]) {
				System.out.print(Arrays.toString((char[])obj));
			} else if (obj instanceof int[]) {
				System.out.print(Arrays.toString((int[])obj));
			} else if (obj instanceof long[]) {
				System.out.print(Arrays.toString((long[])obj));
			} else if (obj instanceof float[]) {
				System.out.print(Arrays.toString((float[])obj));
			} else if (obj instanceof double[]) {
				System.out.print(Arrays.toString((double[])obj));
			} else if(obj instanceof Object[]) {
				debug((Object[])obj);
			} else {
				System.out.print(obj);
			}
			System.out.print(end);
		}
	}

	public static void debug(Object... args) {
		if (DEBUG) {
			System.out.print("#");
			for (int i = 0; i < args.length; i++) {
				debug(args[i], " ");
			}
			System.out.println();
		}
	}

	public static void debug(Suspended sus) {
		if (DEBUG) {
			debug(sus.eval());
		}
	}

	public static void debugGrid(int[][] grid) {
		if (DEBUG) {
			for (int i = 0; i < grid.length; i++) {
				System.out.print("#");
				for (int j = 0; j < grid[0].length; j++) {
					System.out.print(String.format("%3d ", grid[i][j]));
				}
				System.out.println();
			}
		}
	}

	static class FastScan {
		BufferedReader br;
		StringTokenizer st;

		public FastScan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String line() throws Exception {
			return br.readLine();
		}

		public String tok() throws Exception {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(line(), " ");
			}
			return st.nextToken();
		}

		public int in() throws Exception {
			return Integer.parseInt(tok());
		}

		public long lg() throws Exception {
			return Long.parseLong(tok());
		}

		public double db() throws Exception {
			return Double.parseDouble(tok());
		}

		public void close() throws Exception {
			br.close();
		}
	}
}

interface Suspended {
	public Object eval();
}