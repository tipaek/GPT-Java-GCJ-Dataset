import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;

class Solution {
	public void solve(final DataReader dr, final PrintWriter pw) {
		final int n = dr.nextInt();
		dr.nextLine();
		String pfx = "";
		String sfx = "";
		final StringBuilder mid = new StringBuilder();

		boolean ok = true;

		for (int i = 0; i < n; ++i) {
			final String s = dr.nextLine();
			if (!ok) {
				continue;
			}
			final int m = s.length();
			final int x = s.indexOf('*');
			final int y = s.lastIndexOf('*');
			if (x > 0) {
				final String t = s.substring(0, x);
				if (!pfx.startsWith(t)) {
					if (t.startsWith(pfx)) {
						pfx = t;
					}
					else {
						ok = false;
						continue;
					}
				}
			}
			if (y < m - 1) {
				final String t = s.substring(y + 1);
				if (!sfx.endsWith(t)) {
					if (t.endsWith(sfx)) {
						sfx = t;
					}
					else {
						ok = false;
						continue;
					}
				}
			}
			mid.append(s.substring(x, y).replace("*", ""));
		}
		pw.println(ok ? pfx + mid + sfx : "*");
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

}
