import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Solution {
	private static BigInteger sumn(final BigInteger n) {
		return n.multiply(n.add(BigInteger.ONE)).shiftRight(1);
	}

	public void solve(final DataReader dr, final PrintWriter pw) {
		BigInteger l = dr.nextBig();
		BigInteger r = dr.nextBig();
		boolean lbig = l.compareTo(r) >= 0;

		final BinarySearchDiscrete<BigInteger> bs = new BinarySearchDiscrete<>(new BigIntAlgebra());
		final BigInteger dif = l.subtract(r).abs();
		final Predicate<BigInteger> p = x -> sumn(x).compareTo(dif) <= 0;
		BigInteger max = bs.findUpperBound(BigInteger.ZERO, p);
		final BigInteger a = bs.findLast(BigInteger.ZERO, max, p);

		if (lbig) {
			l = l.subtract(sumn(a));
		}
		else {
			r = r.subtract(sumn(a));
		}
		lbig = l.compareTo(r) >= 0;
		if (!lbig) {
			BigInteger t = l;
			l = r;
			r = t;
		}
		final BigInteger l1 = l;
		final BigInteger r1 = r;
		final Predicate<BigInteger> p2 = x -> {
			final BigInteger t = x.multiply(x.add(a).add(BigInteger.ONE));
			return t.subtract(x).compareTo(l1) <= 0 && t.compareTo(r1) <= 0;
		};
		max = bs.findUpperBound(BigInteger.ZERO, p2);
		final BigInteger k = bs.findLast(BigInteger.ZERO, max, p2);
		final BigInteger t1 = k.multiply(k.add(a).add(BigInteger.ONE));
		l = l.subtract(t1.subtract(k));
		r = r.subtract(t1);
		BigInteger n = a.add(k.shiftLeft(1));
		if (n.compareTo(l) < 0) {
			n = n.add(BigInteger.ONE);
			l = l.subtract(n);
		}
		if (!lbig) {
			BigInteger t = l;
			l = r;
			r = t;
		}
		pw.println(n + " " + l + " " + r);
	}

	public static void main(final String... args) {
		final DataReader dr = new DataReader();
		try (final PrintWriter pw = new PrintWriter(System.out)) {
			final int t = dr.nextInt();
			dr.nextLine();

			for (int i = 1; i <= t; ++i) {
				pw.print("Case #" + i + ": ");
				new Solution().solve(dr, pw);
				System.gc();
			}
		}
	}

	// library code

	static class DataReader {
		private final Supplier<String> sup;
		private String line;
		private int n;
		private int k;
		private boolean started;

		public DataReader(final Supplier<String> sup) {
			this.sup = sup;
		}

		public DataReader(final BufferedReader br) {
			this(new Supplier<String>() {
				@Override
				public String get() {
					try {
						return br.readLine();
					}
					catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			});
		}

		public DataReader(final InputStream is) {
			this(new BufferedReader(new InputStreamReader(is)));
		}

		private static InputStream fileStream(final File f) {
			try {
				return new FileInputStream(f);
			}
			catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		public DataReader(final File f) {
			this(fileStream(f));
		}

		public DataReader() {
			this(System.in);
		}

		public static DataReader file(final String fname) {
			try {
				return new DataReader(new FileInputStream(fname));
			}
			catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		private void read() {
			line = sup.get();
			n = line == null ? -1 : line.length();
			k = 0;
		}

		public String next() {
			while (true) {
				if (line == null) {
					if (started) {
						throw new NoSuchElementException();
					}
					started = true;
					read();
					continue;
				}
				while (k < n && line.charAt(k) == ' ') {
					k++;
				}
				if (k < n) {
					break;
				}
				read();
			}
			final int old = k;
			while (k < n && line.charAt(k) != ' ') {
				k++;
			}
			return line.substring(old, k);
		}

		public String nextLine() {
			if (line == null) {
				if (started) {
					throw new NoSuchElementException();
				}
				started = true;
				read();
				if (line == null) {
					throw new NoSuchElementException();
				}
			}
			final String s = k == 0 ? line : line.substring(k);
			read();
			return s;
		}

		public boolean hasNextLine() {
			if (line != null) {
				return true;
			}
			if (started) {
				return false;
			}
			started = true;
			read();
			return line != null;
		}

		public List<String> allLines() {
			final List<String> l = new ArrayList<>();
			while (hasNextLine()) {
				l.add(nextLine());
			}
			return l;
		}

		public String[] lineArray(final int n) {
			final String[] a = new String[n];
			for (int i = 0; i < n; ++i) {
				a[i] = nextLine();
			}
			return a;
		}

		public List<String> lineList(final int n) {
			final List<String> l = new ArrayList<>(n);
			for (int i = 0; i < n; ++i) {
				l.add(nextLine());
			}
			return l;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public BigInteger nextBig() {
			return new BigInteger(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public static int[] parseIntArray(final String s, final String sep) {
			final String[] a = s.split(sep);
			final int n = a.length;
			final int[] b = new int[n];
			for (int i = 0; i < n; ++i) {
				b[i] = Integer.parseInt(a[i]);
			}
			return b;
		}

		public static int[] parseIntArray(final String s) {
			return parseIntArray(s, " ");
		}

		public int[] intArray(final String sep) {
			return parseIntArray(nextLine(), sep);
		}

		public int[] intArray() {
			return intArray(" ");
		}

		public static long[] parseLongArray(final String s, final String sep) {
			final String[] a = s.split(sep);
			final int n = a.length;
			final long[] b = new long[n];
			for (int i = 0; i < n; ++i) {
				b[i] = Long.parseLong(a[i]);
			}
			return b;
		}

		public static long[] parseLongArray(final String s) {
			return parseLongArray(s, " ");
		}

		public long[] longArray(final String sep) {
			return parseLongArray(nextLine(), sep);
		}

		public long[] longArray() {
			return longArray(" ");
		}

		public void read(final int[] a) {
			for (int i = 0; i < a.length; ++i) {
				a[i] = nextInt();
			}
		}

		public int[][] intArray2(final int rows, final String sep) {
			final int[][] a = new int[rows][];
			for (int i = 0; i < rows; ++i) {
				a[i] = intArray(sep);
			}
			return a;
		}

		public int[][] intArray2(final int rows) {
			return intArray2(rows, " ");
		}

		public static <T> List<T> parseList(final String s, final String sep, final Function<String, T> f) {
			final String[] a = s.split(sep);
			final int n = a.length;
			final List<T> l = new ArrayList<>(n);
			for (int i = 0; i < n; ++i) {
				l.add(f.apply(a[i]));
			}
			return l;
		}

		public static List<Integer> parseIntList(final String s, final String sep) {
			return parseList(s, sep, Integer::parseInt);
		}

		public static List<Integer> parseIntList(final String s) {
			return parseIntList(s, " ");
		}

		public <T> List<T> list(final String sep, final Function<String, T> f) {
			return parseList(nextLine(), sep, f);
		}

		public List<Integer> intList(final String sep) {
			return list(sep, Integer::parseInt);
		}

		public List<Integer> intList() {
			return intList(" ");
		}
	}

	static class BinarySearchDiscrete<T> {
		private final DiscreteSearchableAlgebra<T> alg;

		public BinarySearchDiscrete(final DiscreteSearchableAlgebra<T> alg) {
			this.alg = alg;
		}

		public T findFirst(final T min, final T max, final Predicate<T> p) {
			if (p.test(min)) {
				return min;
			}
			if (!p.test(max)) {
				return null;
			}
			T x = min;
			T y = max;
			while (true) {
				T h = alg.mid(x, y);
				if (p.test(h)) {
					if (y.equals(h)) {
						break;
					}
					y = h;
				}
				else {
					if (x.equals(h)) {
						break;
					}
					x = h;
				}
			}
			return y;
		}

		public T findLast(final T min, final T max, final Predicate<T> p) {
			if (p.test(max)) {
				return max;
			}
			if (!p.test(min)) {
				return null;
			}
			T x = min;
			T y = max;
			while (true) {
				T h = alg.mid(x, y);
				if (p.test(h)) {
					if (x.equals(h)) {
						break;
					}
					x = h;
				}
				else {
					if (y.equals(h)) {
						break;
					}
					y = h;
				}
			}
			return x;
		}

		public T find(final T min, final T max, final Predicate<T> p) {
			final boolean t = p.test(min);
			if (t == p.test(max)) {
				return null;
			}
			return t ? findLast(min, max, p) : findFirst(min, max, p);
		}

		public T find0(final T min, final T max, final Function<T, T> f) {
			final T zero = alg.getZero();
			final int x = alg.compare(f.apply(min), zero);
			if (x * alg.compare(f.apply(max), zero) > 0) {
				return null;
			}
			final Predicate<T> p = x < 0 ? y -> alg.compare(f.apply(y), zero) >= 0
					: y -> alg.compare(f.apply(y), zero) <= 0;
			return findFirst(min, max, p);
		}

		public T findUpperBound(final T min, final Predicate<T> p) {
			final boolean b = p.test(min);
			T d = alg.getOne();
			while (true) {
				T max = alg.add(min, d);
				if (p.test(max) != b) {
					return max;
				}
				d = alg.dbl(d);
			}
		}
	}

	static interface DiscreteSearchableAlgebra<T> extends DiscreteAlgebra<T>, SearchableAlgebra<T> {

	}

	static interface SearchableAlgebra<T> extends Algebra<T> {
		T mid(T x, T y);
		T getOne();
		T dbl(T x);
	}

	static interface Algebra<T> {
		T getZero();
		boolean isZero(T x);
		int compare(T x, T y);
		T add(T x, T y);

		public default T min(final T x, final T y) {
			return compare(x, y) < 0 ? x : y;
		}

		public default T max(final T x, final T y) {
			return compare(x, y) > 0 ? x : y;
		}

		default boolean isDiscrete() {
			return false;
		}
	}

	static interface DiscreteAlgebra<T> extends Algebra<T> {
		@Override
		default boolean isDiscrete() {
			return true;
		}

		T next(T x);
		T prev(T x);
	}

	static class BigIntAlgebra implements CompAlgebra<BigInteger>, DiscreteSearchableAlgebra<BigInteger>,
			ModuloAlgebra<BigInteger>, DiscreteArithAlgebra<BigInteger> {
		@Override
		public BigInteger getZero() {
			return BigInteger.ZERO;
		}

		@Override
		public boolean isZero(final BigInteger x) {
			return x.signum() == 0;
		}

		@Override
		public BigInteger getOne() {
			return BigInteger.ONE;
		}

		@Override
		public BigInteger add(final BigInteger x, final BigInteger y) {
			return x.add(y);
		}

		@Override
		public BigInteger subtract(final BigInteger x, final BigInteger y) {
			return x.subtract(y);
		}

		@Override
		public BigInteger mid(final BigInteger x, final BigInteger y) {
			return x.add(y).shiftRight(1);
		}

		@Override
		public BigInteger dbl(final BigInteger x) {
			return x.shiftLeft(1);
		}

		@Override
		public BigInteger multiply(final BigInteger x, final BigInteger y) {
			return x.multiply(y);
		}

		// rounding down, symmetric
		@Override
		public BigInteger divide(final BigInteger x, final BigInteger y) {
			return x.divide(y);
		}

		@Override
		public BigInteger floorDiv(final BigInteger x, final BigInteger y) {
			if (x.signum() * y.signum() >= 0) {
				return x.divide(y);
			}
		    final BigInteger[] qr = x.divideAndRemainder(y);
		    return qr[1].signum() == 0 ? qr[0] : qr[0].subtract(BigInteger.ONE);
		}

		@Override
		public BigInteger roundDiv(final BigInteger x, final BigInteger y, final Rounding r, final boolean symmetric) {
			if (y.signum() < 0) {
				return roundDiv(x.negate(), y.negate(), r, symmetric);
			}
			if (x.signum() < 0 && symmetric) {
				return roundDiv(x.negate(), y, r, symmetric).negate();
			}
			final BigInteger[] a = x.divideAndRemainder(y);
			if (a[1].signum() == 0) {
				return a[0];
			}
			if (a[1].signum() < 0) {
				switch (r) {
				case DOWN:
					return a[0].subtract(BigInteger.ONE);
				case UP:
					return a[0];
				case HALF_UP:
					return a[1].negate().shiftLeft(1).compareTo(y) >= 0 ? a[0] : a[0].subtract(BigInteger.ONE);
				default:
					throw new RuntimeException(r + " not handled");
				}
			}
			switch (r) {
			case DOWN:
				return a[0];
			case UP:
				return a[0].add(BigInteger.ONE);
			case HALF_UP:
				return a[1].shiftLeft(1).compareTo(y) >= 0 ? a[0].add(BigInteger.ONE) : a[0];
			default:
				throw new RuntimeException(r + " not handled");
			}
		}

		@Override
		public BigInteger mod(final BigInteger x, final BigInteger y) {
			return x.remainder(y);
		}

		@Override
		public BigInteger floorMod(final BigInteger x, final BigInteger y) {
			if (x.signum() * y.signum() >= 0) {
				return x.remainder(y);
			}
		    final BigInteger[] qr = x.divideAndRemainder(y);
		    return qr[1].signum() == 0 ? qr[1] : qr[1].add(y);
		}

		@Override
		public BigInteger[] divMod(final BigInteger x, final BigInteger y) {
			return x.divideAndRemainder(y);
		}

		@Override
		public BigInteger[] floorDivMod(final BigInteger x, final BigInteger y) {
			final BigInteger[] qr = x.divideAndRemainder(y);
			if (x.signum() * y.signum() >= 0 || qr[1].signum() == 0) {
				return qr;
			}
		    qr[0] = qr[0].subtract(BigInteger.ONE);
		    qr[1] = qr[1].add(y);
		    return qr;
		}

		@Override
		public BigInteger negate(final BigInteger x) {
			return x.negate();
		}

		@Override
		public BigInteger[] makeArray(final int n) {
			return new BigInteger[n];
		}

		@Override
		public BigInteger abs(final BigInteger x) {
			return x.abs();
		}

		@Override
		public int signum(final BigInteger x) {
			return x.signum();
		}

		@Override
		public BigInteger inc(final BigInteger x) {
			return x.add(BigInteger.ONE);
		}

		@Override
		public BigInteger dec(final BigInteger x) {
			return x.subtract(BigInteger.ONE);
		}

		@Override
		public BigInteger valueOf(final int x) {
			return BigInteger.valueOf(x);
		}

		@Override
		public boolean hasInverses() {
			return false;
		}
	}

	static interface ModuloAlgebra<T> extends NegativeAlgebra<T> {
		T mod(T x, T y);
		T[] divMod(T x, T y);
		T floorMod(T x, T y);
		T[] floorDivMod(T x, T y);
	}

	static interface NegativeAlgebra<T> extends ArithAlgebra<T> {
		T abs(T x);
		int signum(T x);
	}

	static interface ArithAlgebra<T> extends Algebra<T> {
		T getOne();
		T subtract(T x, T y);
		T multiply(T x, T y);
		T divide(T x, T y);
		T floorDiv(T x, T y);
		T roundDiv(T x, T y, Rounding r, boolean symmetric);
		T negate(T x);
		T[] makeArray(int n);
		T inc(T x);
		T dec(T x);
		T valueOf(int x);
		boolean hasInverses();
	}

	static enum Rounding {
		DOWN, UP, HALF_UP;
	}

	static interface CompAlgebra<T extends Comparable<T>> extends Algebra<T> {
		@Override
		default int compare(final T x, final T y) {
			return x.compareTo(y);
		}
	}

	static interface DiscreteArithAlgebra<T> extends ArithAlgebra<T>, DiscreteAlgebra<T> {
		@Override
		default T next(final T x) {
			return inc(x);
		}

		@Override
		default T prev(final T x) {
			return dec(x);
		}
	}

}
