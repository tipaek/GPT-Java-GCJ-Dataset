import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {
	static class Solver {

		int N;
		String[][] patterns;
		
		void solve(int testNumber, FastScanner s, PrintWriter out) {
			N = s.nextInt(); patterns = new String[N][];
			String resLeft = "", resRight = "";
			for(int i = 0; i < N; i++) {
				String inp = " " + s.next() + " ";
				patterns[i] = inp.split("\\*");
				int p = patterns[i].length;
				for(int j = 0; j < p; j++) patterns[i][j] = patterns[i][j].trim();
				if(patterns[i][0].length() > resLeft.length())
					resLeft = patterns[i][0];
				if(patterns[i][p - 1].length() > resRight.length())
					resRight = patterns[i][p - 1];
			}
			out.printf("Case #%d: ", testNumber);
			for(String[] pair : patterns) {
				if(!resLeft.startsWith(pair[0])) {
					out.println("*"); return;
				}
				if(!resRight.endsWith(pair[pair.length - 1])) {
					out.println("*"); return;
				}
			}
			String end = resLeft;
			for(String[] pair : patterns) {
				for(int i = 1; i < pair.length - 1; i++)
					end += pair[i];
			}
			end += resRight;
			out.println(end);
		}

	}

	final static boolean cases = true;

	public static void main(String[] args) {

		FastScanner s = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Solver solver = new Solver();
		for (int t = 1, T = cases ? s.nextInt() : 1; t <= T; t++)
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
