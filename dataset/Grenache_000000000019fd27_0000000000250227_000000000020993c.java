import java.io.*;
import java.util.NoSuchElementException;

public class Solution {
//public class Main_Qualification_Round_2020_A {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int t = sc.nextInt();
		for (int casei = 1; casei <= t; casei++) {
			int n = sc.nextInt();

			int[][] m = new int[n][];

			for (int i = 0; i < n; i++) {
				m[i] = sc.nextIntArray(n);
			}

			int kk = 0;
			for (int i = 0; i < n; i++) {
				kk += m[i][i];
			}
			
			int rr = 0;
			for (int i = 0; i < n; i++) {
				boolean[] f = new boolean[n];
				for (int j = 0; j < n; j++) {
					if (f[m[i][j] - 1]) {
						rr++;
						break;
					}
					f[m[i][j] - 1] = true;
				}
			}

			int cc = 0;
			for (int j = 0; j < n; j++) {
				boolean[] f = new boolean[n];
				for (int i = 0; i < n; i++) {
					if (f[m[i][j] - 1]) {
						cc++;
						break;
					}
					f[m[i][j] - 1] = true;
				}
			}

			pr.printf("Case #%d: %d %d %d\n", casei, kk, rr, cc);
		}
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);
			
		solve();
			
		pr.close();
		sc.close();
	}

	static class Scanner {
		BufferedReader br;

		Scanner (InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		private boolean isPrintable(int ch) {
			return ch >= '!' && ch <= '~';
		}

		private boolean isCRLF(int ch) {
			return ch == '\n' || ch == '\r' || ch == -1;
		}

		private int nextPrintable() {
			try {
				int ch;
				while (!isPrintable(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}

				return ch;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		String next() {
			try {
				int ch = nextPrintable();
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (isPrintable(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		int nextInt() {
			try {
				// parseInt from Integer.parseInt()
				boolean negative = false;
				int res = 0;
				int limit = -Integer.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Integer.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				int multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		long nextLong() {
			try {
				// parseLong from Long.parseLong()
				boolean negative = false;
				long res = 0;
				long limit = -Long.MAX_VALUE;
				int radix = 10;

				int fc = nextPrintable();
				if (fc < '0') {
					if (fc == '-') {
						negative = true;
						limit = Long.MIN_VALUE;
					} else if (fc != '+') {
						throw new NumberFormatException();
					}
					fc = br.read();
				}
				long multmin = limit / radix;

				int ch = fc;
				do {
					int digit = ch - '0';
					if (digit < 0 || digit >= radix) {
						throw new NumberFormatException();
					}
					if (res < multmin) {
						throw new NumberFormatException();
					}
					res *= radix;
					if (res < limit + digit) {
						throw new NumberFormatException();
					}
					res -= digit;

				} while (isPrintable(ch = br.read()));

				return negative ? res : -res;
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}

		float nextFloat() {
			return Float.parseFloat(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			try {
				int ch;
				while (isCRLF(ch = br.read())) {
					if (ch == -1) {
						throw new NoSuchElementException();
					}
				}
				StringBuilder sb = new StringBuilder();
				do {
					sb.appendCodePoint(ch);
				} while (!isCRLF(ch = br.read()));

				return sb.toString();
			} catch (IOException e) {
				throw new NoSuchElementException();
			}
		}
		
		int[] nextIntArray(int n) {
			int[] ret = new int[n];
			for (int i = 0; i < n; i++) {
				ret[i] = sc.nextInt();
			}
			
			return ret;
		}

		long[] nextLongArray(int n) {
			long[] ret = new long[n];
			for (int i = 0; i < n; i++) {
				ret[i] = sc.nextLong();
			}
			
			return ret;
		}

		int[][] nextIntArrays(int m, int n) {
			int[][] ret = new int[m][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					ret[j][i] = sc.nextInt();
				}
			}
			
			return ret;
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
//				throw new NoSuchElementException();
			}
		}
	}

	static class Printer extends PrintWriter {
		Printer(OutputStream out) {
			super(out);
		}
		
		void printInts(int... a) {
			StringBuilder sb = new StringBuilder(32);
			for (int i = 0, size = a.length; i < size; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append(a[i]);
			}

			println(sb);
		}
		
		void printLongs(long... a) {
			StringBuilder sb = new StringBuilder(64);
			for (int i = 0, size = a.length; i < size; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append(a[i]);
			}

			println(sb);
		}
		
		void printStrings(String... a) {
			StringBuilder sb = new StringBuilder(32);
			for (int i = 0, size = a.length; i < size; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append(a[i]);
			}

			println(sb);
		}
	}
}
