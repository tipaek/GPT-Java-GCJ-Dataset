
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Solution {

	public static void main(final String[] args) {
		try (PrintWriter pw = new PrintWriter(System.out, false)) {
			final FastScanner sc = new FastScanner();
			final int t = sc.nextInt();
			final Map<String, String> MM = new HashMap<>();
			final List<String> LL = new ArrayList<>();
			final Set<String> SS = new HashSet<>();
			final StringBuilder BB = new StringBuilder();
			for (int ii = 0; ii < t; ii++) {
				final int r = sc.nextInt();
				final int s = sc.nextInt();
				final List<Integer> l = new ArrayList<>();
				final List<Integer> ll = new ArrayList<>();
				for (int i = 0; i < s; i++) {
					for (int j = 0; j < r; j++) {
						l.add(j + 1);
					}
				}
				// System.out.println(l);
				ll.addAll(l);
				Collections.sort(ll);
				final StringBuilder sb = new StringBuilder();
				int c = 0, p, a, b, x = r, y = 1, v = r;
				final int z = r * s;
				while (!ll.equals(l)) {
					for (int i = z - 1; i > -1; i--) {
						p = l.get(i);
						if (p == x - 1) {
							b = p;
							a = i + 1 - b;
							sb.append(a + " " + b + "\n");
							for (int j = b; j > 0; j--) {
								l.remove(i);
								l.add(0, j);
							}
							y++;
							break;
						}
					}
					if (y == s) {
						y = 1;
						v--;
						x = v;
					}
					c++;
				}
				sb.deleteCharAt(sb.length() - 1);
				pw.println("Case #" + (ii + 1) + ": " + c + "\n" + sb);
			}
		}
	}

	private static final class P {
		public final int x;
		public final int y;
		public int z;

		public P(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj instanceof P) {
				final P pt = (P) obj;
				return this.x == pt.x && this.y == pt.y;
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			long bits = java.lang.Double.doubleToLongBits(this.x);
			bits ^= java.lang.Double.doubleToLongBits(this.y) * 31;
			return (int) bits ^ (int) (bits >> 32);
		}
	}

	private static final class FastScanner {
		private final InputStream is = System.in;
		private final byte[] buf = new byte[8192];
		private int curChar;
		private int numChars;

		public FastScanner() {
		}

		public int read() {
			if (this.numChars == -1) {
				throw new InputMismatchException();
			}
			if (this.curChar >= this.numChars) {
				this.curChar = 0;
				try {
					this.numChars = this.is.read(this.buf);
				} catch (final IOException e) {
					throw new InputMismatchException();
				}
				if (this.numChars <= 0) {
					return -1;
				}
			}
			return this.buf[this.curChar++];
		}

		public String nextLine() {
			int c;
			while (isSpaceChar(c = read())) {
			}
			final StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
			} while (!isEndOfLine(c = read()));
			return res.toString();
		}

		public String nextString() {
			int c;
			while (isSpaceChar(c = read())) {
			}
			final StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
			} while (!isSpaceChar(c = read()));
			return res.toString();
		}

		public long nextLong() {
			int c;
			while (isSpaceChar(c = read())) {
			}
			boolean f = true;
			if (c == '-') {
				f = false;
				c = read();
			}
			long res = 0;
			do {
				/*if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}*/
				res = res * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return f ? res : -res;
		}

		public int nextInt() {
			int c;
			while (isSpaceChar(c = read())) {
			}
			boolean f = true;
			if (c == '-') {
				f = false;
				c = read();
			}
			int res = 0;
			do {
				/*if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}*/
				res = res * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			return f ? res : -res;
		}

		public double nextDouble() {
			return Double.parseDouble(nextString());
			// return FloatingDecimal.parseDouble(nextString());
		}

		public BigInteger nextBigInteger() {
			return new BigInteger(nextString(), 10);
		}

		public BigDecimal nextBigDecimal() {
			return new BigDecimal(nextString());
		}

		public int[] nextArray(final int n) {
			final int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(final int n) {
			final long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}

		public char[] nextCharArray(final int n) {
			final char[] bf = new char[n];
			int b, p = 0;
			while (isSpaceChar(b = read())) {
			}
			while (p < n && !isSpaceChar(b)) {
				bf[p++] = (char) b;
				b = read();
			}
			return n == p ? bf : Arrays.copyOf(bf, p);
		}

		public char[][] nextMatrix(final int n, final int m) {
			final char[][] map = new char[n][];
			for (int i = 0; i < n; i++) {
				map[i] = nextCharArray(m);
			}
			return map;
		}

		public int[][] nextIntMatrix(final int n, final int m) {
			final int[][] map = new int[n][];
			for (int i = 0; i < n; i++) {
				map[i] = nextArray(m);
			}
			return map;
		}

		public long[][] nextLongMatrix(final int n, final int m) {
			final long[][] map = new long[n][];
			for (int i = 0; i < n; i++) {
				map[i] = nextLongArray(m);
			}
			return map;
		}

		public boolean isSpaceChar(final int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(final int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}