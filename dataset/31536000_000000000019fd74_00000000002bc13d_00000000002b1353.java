import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Solution {

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		FastScanner fs = new FastScanner();
		java.io.PrintWriter out = new java.io.PrintWriter(System.out);
		int T = fs.nextInt();
		cont: for (int t = 1;t <= T;++ t) {
			long N = fs.nextInt();
			int max = 0;
			boolean[] use = new boolean[120];
			while(N >= max + (1L << max)) ++ max;
			use[-- max] = true;
			N -= max + (1L << max);
			for (int i = max - 1;i >= 0;-- i) {
				if (N >= (1L << i) - 1) {
					N -= (1L << i) - 1;
					use[i] = true;
				}
			}
			out.println(String.format("Case #%d:", t));
			boolean left = true;
			for (int i = 0;i < use.length;++ i) {
				if (i > max && N-- == 0) break;
				out.println(String.format("%d %d", i + 1, left ? 1 : i + 1));
				if (use[i]) {
					for (int j = 1;j <= i;++ j) {
						out.println(String.format("%d %d", i + 1, left ? 1 + j: i + 1 - j));
					}
					left = !left;
				}
			}
		}
		out.flush();
	}

	static class FastScanner {

		private final java.io.InputStream in = System.in;
		private final byte[] buffer = new byte[1024];
		private int ptr = 0;
		private int buflen = 0;

		private boolean hasNextByte() {
			if (ptr < buflen) return true;
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
			return buflen > 0;
		}

		private byte readByte() {
			return hasNextByte() ? buffer[ptr++] : -1;
		}

		private static boolean isPrintableChar(byte c) {
			return 32 < c || c < 0;
		}

		private static boolean isNumber(int c) {
			return '0' <= c && c <= '9';
		}

		public boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[ptr]))
				ptr++ ;
			return hasNextByte();
		}

		public String next() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			byte b = readByte();
			while (isPrintableChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public final long nextLong() {
			if (!hasNext()) throw new NoSuchElementException();
			long n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					do n = n * 10 + '0' - b; while(isNumber(b = readByte()));
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while(isNumber(b = readByte()));
				return n;
			} catch (NoSuchElementException e) {
				return n;
			}
		}

		public final int nextInt() {
			if (!hasNext()) throw new NoSuchElementException();
			int n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					do n = n * 10 + '0' - b; while(isNumber(b = readByte()));
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while(isNumber(b = readByte()));
				return n;
			} catch (NoSuchElementException e) {
				return n;
			}
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
