import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = true;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		for (int t = 1; t <= cases; t++) {
			int r = sc.in();
			int s = sc.in();

			pw.printf("Case #%d: %d\n", t, (r - 1) * (s - 1));

			int k = 0;
			for (int i = r; i > 1; i--) {
				for (int j = 0; j < s - 1; j++) {
					// debug("!", t, i, j);
					// debug(">", t, i, r * s - k - i - 1);
					pw.printf("%d %d\n", i, r * s - k - i - 1);
					k++;
				}
				k++;
			}
		}

		pw.close();
		sc.close();
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	public static void debug(Object obj, String end) {
		if (DEBUG) {
			if (obj instanceof boolean[]) {
				System.err.print(Arrays.toString((boolean[])obj));
			} else if (obj instanceof byte[]) {
				System.err.print(Arrays.toString((byte[])obj));
			} else if (obj instanceof short[]) {
				System.err.print(Arrays.toString((short[])obj));
			} else if (obj instanceof char[]) {
				System.err.print(Arrays.toString((char[])obj));
			} else if (obj instanceof int[]) {
				System.err.print(Arrays.toString((int[])obj));
			} else if (obj instanceof long[]) {
				System.err.print(Arrays.toString((long[])obj));
			} else if (obj instanceof float[]) {
				System.err.print(Arrays.toString((float[])obj));
			} else if (obj instanceof double[]) {
				System.err.print(Arrays.toString((double[])obj));
			} else if(obj instanceof Object[]) {
				debug((Object[])obj);
			} else {
				System.err.print(obj);
			}
			System.err.print(end);
		}
	}

	public static void debug(Object... args) {
		if (DEBUG) {
			System.err.print("#");
			for (int i = 0; i < args.length; i++) {
				debug(args[i], " ");
			}
			System.err.println();
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