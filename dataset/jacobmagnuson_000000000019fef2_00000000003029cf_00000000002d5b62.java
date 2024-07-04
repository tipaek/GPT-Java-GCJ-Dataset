import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
	static class Solver {

		long X, Y;
		boolean flipX, flipY;
		
		HashSet<Long> hs = new HashSet<>();
		boolean seen(long x, long y) {
			long z = (long) 1e9 * x + y;
			boolean res = hs.contains(z);
			hs.add(z); return res;
		}
		
		void solve(int testNumber, FastScanner s, PrintWriter out) {
			X = s.nextLong(); Y = s.nextLong();
			flipX = X < 0; flipY = Y < 0; X = abs(X); Y = abs(Y);
			out.printf("Case #%d: ", testNumber);
			
			ArrayList<State> q = new ArrayList<>(), next = new ArrayList<>();
			q.add(new State(0, 0, (char) 0, null));
			int step = 0;
			while(!q.isEmpty()) {
				long jump = 1L << step, after = jump << 1; hs.clear();
				for(State S : q) {
					long dx = X - S.x, dy = Y - S.y, xx, yy;
					if(dx == 0 && dy == 0) { print(S, out); return; } // DONE!
					
					xx = S.x; yy = S.y + jump; // NORTH
					if((X - xx) % after == 0 && (Y - yy) % after == 0 && !seen(xx, yy))
						next.add(new State(xx, yy, 'N', S));
					xx = S.x; yy = S.y - jump; // SOUTH
					if((X - xx) % after == 0 && (Y - yy) % after == 0 && !seen(xx, yy))
						next.add(new State(xx, yy, 'S', S));
					xx = S.x + jump; yy = S.y; // EAST
					if((X - xx) % after == 0 && (Y - yy) % after == 0 && !seen(xx, yy))
						next.add(new State(xx, yy, 'E', S));
					xx = S.x - jump; yy = S.y; // WEST
					if((X - xx) % after == 0 && (Y - yy) % after == 0 && !seen(xx, yy))
						next.add(new State(xx, yy, 'W', S));
				}
				q = new ArrayList<>(next); next.clear(); step++;
			}
			out.println("IMPOSSIBLE");
		}
		
		int Xflipper = 'E' ^ 'W', Yflipper = 'N' ^ 'S';
		// print the state S, flipping directions if necessary
		void print(State S, PrintWriter out) {
			String res = "";
			while(S.prev!= null) {
				if(S.dir == 'E' || S.dir == 'W')
					res = (char) (S.dir ^ (flipX ? Xflipper : 0)) + res;
				else
					res = (char) (S.dir ^ (flipY ? Yflipper : 0)) + res;
				S = S.prev;
			}
			out.println(res);
		}
		
		class State {
			long x, y; char dir; State prev;
			State(long xx, long yy, char dd, State pp) {
				x = xx; y = yy; dir = dd; prev = pp;
			}
		}
		
		Solver() { /* crunch the numbers */ }

	}

	final static boolean cases = true;

	public static void main(String[] args) {

		FastScanner s = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Solver solver = new Solver();
		for (int t = 1, T = cases ? s.nextInt() : 1; t <= T; t++, out.flush())
			solver.solve(t, s, out);

		out.close();

	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static long min(long a, long b) {
		return a < b ? a : b;
	}

	static long max(long a, long b) {
		return a > b ? a : b;
	}
	
	static long abs(long a) {
		return a >= 0 ? a : -a;
	}

	static int swap(int a, int b) {
		return a;
	}

	static Object swap(Object a, Object b) {
		return a;
	}

	static String ts(Object... o) {
		return Arrays.deepToString(o);
	}

	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		public FastScanner(File f) throws FileNotFoundException {
			this(new FileInputStream(f));
		}

		public FastScanner(String s) {
			this.stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}

		// Jacob Garbage

		public int[] nextIntArray(int N) {
			int[] ret = new int[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextInt();
			return ret;
		}

		public int[][] next2DIntArray(int N, int M) {
			int[][] ret = new int[N][];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextIntArray(M);
			return ret;
		}

		public long[] nextLongArray(int N) {
			long[] ret = new long[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextLong();
			return ret;
		}

		public long[][] next2DLongArray(int N, int M) {
			long[][] ret = new long[N][];
			for (int i = 0; i < N; i++)
				ret[i] = nextLongArray(M);
			return ret;
		}

		public double[] nextDoubleArray(int N) {
			double[] ret = new double[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextDouble();
			return ret;
		}

		public double[][] next2DDoubleArray(int N, int M) {
			double[][] ret = new double[N][];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextDoubleArray(M);
			return ret;
		}

	}
}
