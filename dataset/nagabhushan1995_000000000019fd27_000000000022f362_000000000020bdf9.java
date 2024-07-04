

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

public class C {
	private static int n;
	private static int[][] a;
	private static HashMap<Integer, ArrayList<Integer>> g;

	public static void main(String[] args) {
		int t = in.nextInt();
		for(int z=1; z<=t; z++) {
			n = ini();
			a = new int[n][2];
			for(int i=0; i<n; i++) {
				a[i][0] = ini();
				a[i][1] = ini();
			}
			g = new HashMap<>();
			for(int i=0; i<n; i++) {
				g.put(i, new ArrayList<>());
			}
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if (a[i][1]<=a[j][0] || a[j][1]<=a[i][0]) {
						
					} else {
						g.get(i).add(j);
						g.get(j).add(i);
					}
				}
			}
			Stack<Integer> stack = new Stack<>();
			boolean[] mark = new boolean[n];
			boolean[] color = new boolean[n];
			
			boolean good = true;
			
			out:
			for(int i=0; i<n; i++) {
				if (mark[i]) continue;
				mark[i] = true;
				color[i] = true;
				
				stack.push(i);
				while(!stack.isEmpty()) {
					int u = stack.pop();
					
					for(int v: g.get(u)) {
						if (!mark[v]) {
							mark[v] = true;
							stack.push(v);
							color[v] = !color[u];
						} else if (color[u]==color[v]) {
							good = false;
							break out;
						}
					}
				}
			}
			if (!good) {
				println("Case #"+z+": "+"IMPOSSIBLE");
			} else {
				print("Case #"+z+":");
				for(boolean b: color) {
					if (b) System.out.print("C");
					else System.out.print("J");
				}
				println();
			}
		}

		out.flush();
		out.close();

	}

	//NONPROBLEM CODE

	private static InputReader in = new InputReader(System.in);
	private static PrintWriter out = new PrintWriter(System.out);

	private static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

	//INPUT SHORTCUTS

	private static int[] ina(int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = in.nextInt();
		}
		return temp;
	}

	private static int ini() {
		return in.nextInt();
	}

	//OTHER SHORTCUTS
	public static void sort(int[] a) {
		Arrays.sort(a);
	}

	//PRINT SHORTCUTS

	private static void println(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.write("\n");
		out.flush();
	}

	private static void print(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.flush();
	}

	private static void debug(Object... o) {
		for (Object x : o) {
			out.write(x + " ");
		}
		out.write("\n");
		out.flush();
	}

	private static HashMap<Integer, ArrayList<Integer>> intree(int n) {

		HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
		for (int i = 0; i < n; i++) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			int u = ini() - 1;
			int v = ini() - 1;
			g.get(u).add(v);
			g.get(v).add(u);
		}

		return g;
	}
}
