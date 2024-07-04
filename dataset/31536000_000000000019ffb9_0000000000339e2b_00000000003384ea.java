public class Solution {

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		FastScanner fs = new FastScanner();
		java.io.PrintWriter out = new java.io.PrintWriter(System.out);
		solve(fs, out);
		out.flush();
	}

	public void solve(FastScanner fs, java.io.PrintWriter out) {
		int T = fs.nextInt();
		for (int i = 1;i <= T;++ i) {
			long L = fs.nextLong(), R = fs.nextLong();
			long pop = 0;
			if (L > R) {
				long diff = L - R;
				pop = (long)Math.sqrt(2 * diff);
				L -= pop * (pop + 1) / 2;
			} else if (L < R){
				long diff = R - L;
				pop = (long)Math.sqrt(2 * diff);
				R -= pop * (pop + 1) / 2;
			}
			if (L >= R) {
				long min = 0, max = 1;
				while(max * (pop - 1) + max * (max + 1) <= L) max *= 2;
				for (long mid = 0;max - min > 1;) {
					mid = min + (max - min >> 1);
					if (mid * (pop - 1) + mid * (mid + 1) <= L) min = mid;
					else max = mid;
				}
				L -= min * (pop - 1) + min * (min + 1);
				R -= (min - 1) * pop + min * (min - 1);
				pop += 2 * min - 1;
				if (R >= pop + 1) R -= ++ pop;
			} else {
				long min = 0, max = 1;
				while(max * (pop - 1) + max * (max + 1) <= R) max *= 2;
				for (long mid = 0;max - min > 1;) {
					mid = min + (max - min >> 1);
					if (mid * (pop - 1) + mid * (mid + 1) <= R) min = mid;
					else max = mid;
				}
				R -= min * (pop - 1) + min * (min + 1);
				L -= (min - 1) * pop + min * (min - 1);
				pop += 2 * min - 1;
				if (L >= pop + 1) L -= ++ pop;
			}
			out.println(String.format("Case #%d: %d %d %d", i, pop, L, R));
		}
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
			return hasNextByte() ? buffer[ptr++ ] : -1;
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
			if (!hasNext()) throw new java.util.NoSuchElementException();
			long n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					while(isNumber(b = readByte())) n = n * 10 + '0' - b;
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
				return n;
			} catch (java.util.NoSuchElementException e) {
				return n;
			}
		}

		public final int nextInt() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			int n = 0;
			try {
				byte b = readByte();
				if (b == '-') {
					while(isNumber(b = readByte())) n = n * 10 + '0' - b;
					return n;
				} else if (!isNumber(b)) throw new NumberFormatException();
				do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
				return n;
			} catch (java.util.NoSuchElementException e) {
				return n;
			}
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
