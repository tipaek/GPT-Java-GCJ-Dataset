import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Solution {
	static PrintWriter out;
	static InputReader ir;
	static final int[] dd = { 0, 1, 0, -1 };

	static void solve() {
		int T = ir.nextInt();
		outer: for (int t = 1; t <= T; t++) {
			out.print("Case #" + t + ": ");
			int r = ir.nextInt();
			int c = ir.nextInt();
			int[][] a = new int[r][];
			for (int i = 0; i < r; i++)
				a[i] = ir.nextIntArray(c);
			long res = 0;
			boolean[][] used = new boolean[r][c];
			while (true) {
				boolean[][] tmp = new boolean[r][c];
				boolean update = false;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (!used[i][j])
							res += a[i][j];
					}
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (used[i][j])
							continue;
						long p = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dd[k], ny = j + dd[k ^ 1];
							if (!in(nx, ny, r, c))
								continue;
							while (in(nx, ny, r, c) && used[nx][ny]) {
								nx += dd[k];
								ny += dd[k ^ 1];
							}
							if (in(nx, ny, r, c)) {
								p += a[i][j] - a[nx][ny];
							}
						}
						if (p < 0) {
							update = true;
							tmp[i][j] = true;
						}
					}
				}

				if (!update)
					break;
				for (int i = 0; i < r; i++)
					for (int j = 0; j < c; j++)
						used[i][j] |= tmp[i][j];
			}
			out.println(res);
		}
	}

	static boolean in(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
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
