import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		for (int t = 1; t <= cases; t++) {
			int k = sc.in();
			int n = sc.in();

			int[] x = new int[n];
			int[] tmp = new int[n];

			for (int i = 0; i < n; i++) {
				x[i] = sc.in();
			}

			for (int i = 1; i < n; i++) {
				x[i] -= x[0];
			}

			x[0] = 0;

			for (int i = 0; i < n; i++) {
				tmp[i] = sc.in();
			}

			Range[] r = new Range[n];

			for (int i = 0; i < n - 1; i++) {
				r[i] = new Range(x[i], x[i + 1]);
			}

			r[n-1] = new Range(x[n-1], k);

			int[] reach = new int[n];
			boolean single = false;

			for (int i = 0; i < n; i++) {
				Range ok = r[i];
				reach[i] = 0;

				for (int j = i + 1; j <= i + n; j++) {
					int jj = j;
					Range ck;

					if (j >= n) {
						ck = r[j-n].slide(k);
					} else {
						ck = r[j];
					}

					ok = ok.flip(ck.start).intersect(ck);

					if (ok.isEmpty()) {
						break;
					} else if (j == i + n) {
						// extra check: if we've come all the way around the circle, we need to check for self-consistency
						Range rewind = ok;

						for (int l = i + n - 1; l >= i; l--) {
							Range rn = l >= n ? r[l-n].slide(k) : r[l];
							rewind = rewind.flip(rn.end);
						}

						if (!ok.slide(-k).intersect(rewind).isEmpty()) {
							// debug(i);
							// debug("Passed final check", ok.slide(-k), rewind);
							single = true;
							break;
						} else {
							// debug(i);
							// debug("Failed final check", ok.slide(-k), rewind);
							reach[i] = j - i;
						}
					} else {
						reach[i] = j - i;
					}
				}

				if (single) {
					break;
				}
			}

			// debug(reach, single);

			if (single) {
				pw.printf("Case #%d: %d\n", t, n);
			} else {
				int best = 2 * n;
				int[] dp = new int[2 * n];

				for (int i = 0; i < n; i++) {
					Arrays.fill(dp, 2 * n);
					dp[i] = 0;

					for (int j = i; j < i + n; j++) {
						for (int l = 1; l <= reach[j%n] && j + l <= i + n; l++) {
							dp[j + l] = Math.min(dp[j + l], dp[j] + 1);
						}
					}

					best = Math.min(best, dp[i + n]);
				}

				pw.printf("Case #%d: %d\n", t, n + best);
			}
		}

		pw.close();
		sc.close();
	}

	static class Range {
		int start;
		int end;

		public Range(int start, int end) {
			this.start = start;
			this.end = Math.max(end, start);
		}

		public Range flip(int x) {
			return new Range(2 * x - end, 2 * x - start);
		}

		public Range slide(int x) {
			return new Range(start + x, end + x);
		}

		public Range intersect(Range o) {
			return new Range(Math.max(start, o.start), Math.min(end, o.end));
		}

		public boolean isEmpty() {
			return start == end;
		}

		public String toString() {
			return "(" + start + ", " + end + ")";
		}
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
