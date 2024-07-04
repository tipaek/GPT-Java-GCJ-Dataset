
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Solution {

	public static void main(final String[] args) {
		try (PrintWriter pw = new PrintWriter(System.out, false)) {
			final FastScanner sc = new FastScanner();
			final int t = sc.nextInt();
			int n, k, r, c;
			int[][] a;
			final Set<Integer> s = new HashSet<>();
			for (int ii = 0; ii < t; ii++) {
				n = sc.nextInt();
				k = r = c = 0;
				a = sc.nextIntMatrix(n, n);
				for (int i = 0; i < n; i++) {
					k += a[i][i];
					s.clear();
					for (int j = 0; j < n; j++) {
						if (!s.add(a[i][j])) {
							r++;
							break;
						}
					}
					s.clear();
					for (int j = 0; j < n; j++) {
						if (!s.add(a[j][i])) {
							c++;
							break;
						}
					}
				}

				pw.println("Case #" + (ii + 1) + ": " + k + " " + r + " " + c);
			}
		}
	}

	private static final class L {
		public final int id;
		public final int n;
		public final int t;
		public final int m;
		public final int[] a;
		public long s = 0;

		public L(final int id, final int x, final int y, final int z) {
			this.id = id;
			this.n = x;
			this.t = y;
			this.m = y;
			this.a = new int[this.n];
		}

		@Override
		public String toString() {
			return "L [id=" + this.id + ", n=" + this.n + ", t=" + this.t + ", m=" + this.m + ", a=" + Arrays.toString(this.a) + ", s=" + this.s + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.id;
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final L other = (L) obj;
			if (this.id != other.id) {
				return false;
			}
			return true;
		}

	}

	private static final class Point {
		public final int x;
		public final int y;

		public Point(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj instanceof Point) {
				final Point pt = (Point) obj;
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

	private static final class Graph<T> {
		private final Map<T, Set<T>> g = new HashMap<>();

		public void addNode(final T node) {
			this.g.put(node, new HashSet<>());
		}

		public void addEdge(final T source, final T destination) {
			this.g.get(source).add(destination);
			this.g.get(destination).add(source);
		}

		public Set<T> getChildren(final T node) {
			return this.g.get(node);
		}

		public List<List<T>> getAllPaths(final T source, final T destination) {
			final List<List<T>> paths = new ArrayList<>();
			try {
				recursive(source, destination, paths, new LinkedHashSet<T>());
			} catch (final Exception e) {
			}
			return paths;
		}

		private void recursive(final T current, final T destination, final List<List<T>> paths, final LinkedHashSet<T> path) {
			path.add(current);

			if (current.equals(destination)) {
				paths.add(new ArrayList<>(path));
				path.remove(current);
				return;
				// throw new RuntimeException();
			}

			for (final T t : this.g.get(current)) {
				if (!path.contains(t)) {
					recursive(t, destination, paths, path);
				}
			}

			path.remove(current);
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