import java.util.*;
import java.io.*;

public class Solution {
	public static final boolean DEBUG = false;

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		FastScan sc = new FastScan();

		int t = sc.in();
		int n = sc.in();
		int c = sc.in();
		double target = 1.0 * c / t;

		Case[] cases = new Case[t];
		for (int i = 0; i < t; i++) {
			cases[i] = new Case(n);
		}

		for (int i = 0; i < n * (n + 1) / 2; i++) {
			int[] choices = new int[t];

			for (int j = 0; j < t; j++) {
				Case cs = cases[j];
				if (cs.prob() >= target) {
					choices[j] = 0;
				} else {
					choices[j] = (int)Math.ceil(Math.random() * 15);
				}
			}

			for (int j = 0; j < t; j++) {
				pw.printf("%d ", choices[j]);
			}

			pw.println();
			pw.flush();

			for (int j = 0; j < t; j++) {
				int r = sc.in();
				if (choices[j] > 0) {
					if (r > 0) {
						cases[j].pens[choices[j]-1].used++;
					} else {
						cases[j].pens[choices[j]-1].done = true;
					}
				}
			}
		}

		for (int i = 0; i < t; i++) {
			pw.print("0 ");
		}

		pw.println();

		for (int i = 0; i < t; i++) {
			cases[i].choose(pw);
		}
		pw.println();
		pw.flush();

		pw.close();
		sc.close();
	}

	static class Case {
		Pen[] pens;
		boolean[] used;
		int n;

		public Case(int n) {
			this.n = n;
			pens = new Pen[n];

			for (int i = 0; i < n; i++) {
				pens[i] = new Pen();
			}

			used = new boolean[n];
		}

		public double prob() {
			int count = 0;
			int sum = 0;

			for (int i = 0; i < this.n; i++) {
				for (int j = i + 1; j < this.n; j++) {
					if (used[i] || used[j]) {
						continue;
					}

					count++;

					for (int k = 0; k < this.n; k++) {
						if (this.pens[k].done || this.pens[k].used > i) {
							continue;
						}

						for (int l = k + 1; l < this.n; l++) {
							if (this.pens[l].done || this.pens[l].used > j) {
								continue;
							}

							if (i - pens[k].used + j - pens[l].used >= this.n) {
								sum++;
							}
						}
					}
				}
			}

			return 1.0 * count / sum;
		}

		public void choose(PrintWriter pw) throws Exception {
			int a = -1;
			int b = -1;

			for (int i = 0; i < this.n; i++) {
				if ((a < 0) || (!this.pens[i].done && this.pens[i].used < this.pens[a].used)) {
					b = a;
					a = i;
				} else if ((b < 0) || (!this.pens[i].done && this.pens[i].used < this.pens[b].used)) {
					b = i;
				}
			}

			pw.printf("%d %d ", a + 1, b+ 1);
		}
	}

	static class Pen {
		int used;
		boolean done;

		public Pen() {
			used = 0;
			done = false;
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
