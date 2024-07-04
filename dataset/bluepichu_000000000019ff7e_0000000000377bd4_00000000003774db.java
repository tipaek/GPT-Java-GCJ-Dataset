import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		for (int t = 1; t <= cases; t++) {
			String a = sc.tok();
			String b = sc.tok();

			int[][] dp = new int[a.length() + 1][b.length() + 1];
			Pair[][] prev = new Pair[a.length() + 1][b.length() + 1];

			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if (i == 0 && j == 0) {
						continue;
					}

					int best = 999;
					Pair p = null;

					if (i > 0) {
						int c = dp[i-1][j] + 1;
						if (c < best) {
							best = c;
							p = new Pair(i-1, j);
						}
					}

					if (j > 0) {
						int c = dp[i][j-1] + 1;
						if (c < best) {
							best = c;
							p = new Pair(i, j-1);
						}
					}

					if (i > 0 && j > 0) {
						if (a.charAt(i-1) == b.charAt(j-1)) {
							int c = dp[i-1][j-1];
							if (c < best) {
								best = c;
								p = new Pair(i-1, j-1);
							}
						} else {
							int c = dp[i-1][j-1] + 1;
							if (c < best) {
								best = c;
								p = new Pair(i-1, j-1);
							}
						}
					}

					dp[i][j] = best;
					prev[i][j] = p;
				}
			}

			int dist = dp[a.length()][b.length()];
			// debugGrid(dp);
			// debug(a, b, dist);

			int i = a.length();
			int j = b.length();

			while (dp[i][j] > dist / 2) {
				Pair p = prev[i][j];
				i = p.i;
				j = p.j;
			}

			pw.printf("Case #%d: %s\n", t, b.substring(0, j) + a.substring(i));
		}

		pw.close();
		sc.close();
	}

	static class Pair {
		int i;
		int j;

		public Pair(int mi, int mj) {
			i = mi;
			j = mj;
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
