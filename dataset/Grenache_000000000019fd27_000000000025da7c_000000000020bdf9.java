import java.io.*;
import java.util.*;

public class Solution {
//public class Main_Qualification_Round_2020_C {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int t = sc.nextInt();
		out:
		for (int casei = 1; casei <= t; casei++) {
			int n = sc.nextInt();

			List<Tri> list = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				list.add(new Tri(s, e, i));
			}
			Collections.sort(list);
			
			PriorityQueue<Tri> pq = new PriorityQueue<>((o1, o2) -> {
				int result = Integer.compare(o1.b, o2.b);
				if (result == 0) {
					result = Integer.compare(o1.a, o2.a);
				}
				return result;
			});

			char[] ans = new char[n];
			for (Tri e : list) {
				while (!pq.isEmpty() && pq.peek().b <= e.a) {
					pq.remove();
				}
				
				if (pq.size() > 1) {
					pr.printf("Case #%d: IMPOSSIBLE\n", casei);
					continue out;
				} else if (pq.size() == 1) {
					char c = ans[pq.peek().c];
					if (c == 'C') {
						ans[e.c] = 'J';
					} else {
						ans[e.c] = 'C';
					}
				} else {
					ans[e.c] = 'C';
				}
				
				pq.add(e);
			}

			pr.printf("Case #%d: %s\n", casei, new String(ans));
		}
	}

	static class Tri implements Comparable<Tri> {
		int a;
		int b;
		int c;

		Tri(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Tri o) {
			int result = Integer.compare(a, o.a);
			if (result == 0) {
				result = Integer.compare(b, o.b);
				if (result == 0) {
					result = Integer.compare(c, o.c);
				}
			}
			return result;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Tri))
				return false;

			Tri o = (Tri) obj;
			return a == o.a && b == o.b && c == o.c;
		}

		@Override
		public String toString() {
			//			Tri [xxx, xxxx]
			StringBuilder stmp = new StringBuilder(64);
			stmp.append("Tri [");
			stmp.append(a);
			stmp.append(',');
			stmp.append(' ');
			stmp.append(b);
			stmp.append(',');
			stmp.append(' ');
			stmp.append(c);
			stmp.append(']');

			return stmp.toString();
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
