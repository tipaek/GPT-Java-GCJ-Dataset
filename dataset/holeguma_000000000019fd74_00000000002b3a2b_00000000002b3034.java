import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Solution {
	static PrintWriter out;
	static InputReader ir;

	static void solve() {
		int T = ir.nextInt();
		String begin = "", end = "";
		outer: for (int t = 1; t <= T; t++) {
			out.print("Case #" + t + ": ");
			int n = ir.nextInt();
			String[] s = new String[n];
			int[][] a = new int[n][2];
			for (int i = 0; i < n; i++)
				s[i] = ir.next();
			for (int i = 0; i < n; i++) {
				int idx = 0;
				while (s[i].charAt(idx) != '*')
					idx++;
				a[i][0] = idx;
				for (int j = 0; j < Math.min(begin.length(), idx); j++) {
					if (begin.charAt(j) != s[i].charAt(j)) {
						out.println("*");
						continue outer;
					}
				}
				if (begin.length() < idx)
					begin = s[i].substring(0, idx);
				idx = s[i].length() - 1;
				while (s[i].charAt(idx) != '*')
					idx--;
				idx++;
				a[i][1] = idx;
				for (int j = 0; j < Math.min(end.length(), s[i].length() - idx); j++) {
					if (end.charAt(end.length() - 1 - j) != s[i].charAt(s[i].length() - 1 - j)) {
						out.println("*");
						continue outer;
					}
				}
				if (end.length() < s[i].length() - idx) {
					end = s[i].substring(idx);
				}
			}
			out.print(begin);
			for (int i = 0; i < n; i++) {
				out.print(s[i].substring(a[i][0], a[i][1]).replace("*", ""));
			}
			out.println(end);
		}
	}

	public static void main(String[] args) {
		ir = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	static class InputReader {

		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;

		public InputReader(InputStream in) {
			this.in = in;
			this.curbuf = this.lenbuf = 0;
		}

		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return false;
			}
			return true;
		}

		private int readByte() {
			if (hasNextByte())
				return buffer[curbuf++];
			else
				return -1;
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf]))
				curbuf++;
		}

		public boolean hasNext() {
			skip();
			return hasNextByte();
		}

		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public int nextInt() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++)
				map[i] = next().toCharArray();
			return map;
		}
	}

	static void tr(Object... o) {
		out.println(Arrays.deepToString(o));
		out.flush();
	}
}
