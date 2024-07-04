import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int cases = sc.in();

		main: for (int t = 1; t <= cases; t++) {
			Point start = findInitialPoint(pw, sc);

			if (start.center) {
				continue main;
			}

			while (true) {
				int lo = start.x;
				int hi = 1_000_000_000;

				while (lo < hi) {
					int mx = (lo + hi + 1) / 2;
					debug("hi x", lo, hi, mx);
					Point p = new Point(mx, start.y);
					test(p, pw, sc);

					if (p.center) {
						continue main;
					} else if (p.hit) {
						lo = mx;
					} else {
						hi = mx - 1;
					}
				}

				int left = lo;
				lo = -1_000_000_000;
				hi = start.x;

				while (lo < hi) {
					int mx = (lo + hi - 1) / 2;
					debug("lo x", lo, hi, mx);
					Point p = new Point(mx, start.y);
					test(p, pw, sc);

					if (p.center) {
						continue main;
					} else if (p.hit) {
						hi = mx;
					} else {
						lo = mx + 1;
					}
				}

				int right = lo;

				debug("BS complete:", left, right);
				start = new Point((left + right) / 2, start.y);
				test(start, pw, sc);

				if (start.center) {
					continue main;
				}

				lo = start.y;
				hi = 1_000_000_000;

				while (lo < hi) {
					int my = (lo + hi + 1) / 2;
					debug("hi y", lo, hi, my);
					Point p = new Point(start.x, my);
					test(p, pw, sc);

					if (p.center) {
						continue main;
					} else if (p.hit) {
						lo = my;
					} else {
						hi = my - 1;
					}
				}

				int top = lo;
				lo = -1_000_000_000;
				hi = start.y;

				while (lo < hi) {
					int my = (lo + hi - 1) / 2;
					debug("lo y", lo, hi, my);
					Point p = new Point(start.x, my);
					test(p, pw, sc);

					if (p.center) {
						continue main;
					} else if (p.hit) {
						hi = my;
					} else {
						lo = my + 1;
					}
				}

				int bottom = lo;

				debug("BS complete:", top, bottom);
				start = new Point(start.x, (top + bottom) / 2);
				test(start, pw, sc);

				if (start.center) {
					continue main;
				}
			}
		}

		pw.close();
		sc.close();
	}

	static Point findInitialPoint(PrintWriter pw, FastScan sc) throws Exception {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = -750_000_000 + 500_000_000 * i;
				int y = -750_000_000 + 500_000_000 * j;
				Point p = new Point(x, y);
				test(p, pw, sc);
				if (p.hit) {
					return p;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = -500_000_000 + 500_000_000 * i;
				int y = -500_000_000 + 500_000_000 * j;
				Point p = new Point(x, y);
				test(p, pw, sc);
				if (p.hit) {
					return p;
				}
			}
		}

		throw new Exception();
	}

	static void test(Point p, PrintWriter pw, FastScan sc) throws Exception {
		debug(">", p.x, p.y);
		pw.printf("%d %d\n", p.x, p.y);
		pw.flush();
		String out = sc.line();
		debug("<", out, "\n");

		if (out.equals("HIT")) {
			p.hit = true;
		} else if (out.equals("CENTER")) {
			p.hit = true;
			p.center = true;
		}
	}

	static class Point {
		int x;
		int y;
		boolean hit;
		boolean center;

		public Point (int mx, int my) {
			x = mx;
			y = my;
			hit = false;
			center = false;
		}
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