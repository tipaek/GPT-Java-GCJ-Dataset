import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		for (int t = 1; t <= cases; t++) {
			int n = sc.in();
			// debug(n);
			Point[] pts = new Point[n];

			for (int i = 0; i < n; i++) {
				// debug("reading pt", i);
				pts[i] = new Point(sc.lg(), sc.lg());
			}

			int best = Math.min(n, 4);

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					long dx = pts[j].x - pts[i].x;
					long dy = pts[j].y - pts[i].y;
					Point dir = new Point(-dy, dx);

					HashMap<Long, Integer> map = new HashMap<Long, Integer>();

					for (int k = 0; k < n; k++) {
						long value = pts[k].dot(dir);
						int cnt = map.containsKey(value) ? map.get(value) : 0;
						cnt++;
						map.put(value, cnt);
					}

					// debug(i, j, map);

					int[] cnts = new int[map.size() + 2];
					int k = 0;

					for (long key : map.keySet()) {
						cnts[k] = map.get(key);
						k++;
					}

					Arrays.sort(cnts);
					k = cnts.length - 1;

					int ans = 0;

					for (; k >= 0; k--) {
						if (cnts[k] < 2) {
							break;
						} else {
							ans += cnts[k];
						}
					}

					if (ans % 2 == 1) {
						ans--;
						cnts[1]++;
					}

					ans += cnts[k];
					ans += cnts[k-1];

					best = Math.max(best, ans);
				}
			}

			pw.printf("Case #%d: %d\n", t, best);
			if (DEBUG) {
				pw.flush();
			}
		}

		pw.close();
		sc.close();
	}

	static class Point {
		long x;
		long y;

		public Point(long mx, long my) {
			x = mx;
			y = my;
		}

		public long dot(Point o) {
			return x * o.x + y * o.y;
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