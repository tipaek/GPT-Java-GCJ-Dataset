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
			int N = fs.nextInt();
			java.awt.Point[] p = new java.awt.Point[N];
			for (int j = 0;j < N;++ j) {
				p[j] = new java.awt.Point(fs.nextInt(), fs.nextInt());
			}
			java.util.Map<Long, java.util.Map<Long, Integer>> hash = new java.util.HashMap<>();
			for (int j = 0;j < N;++ j) {
				for (int k = 0;k < j;++ k) {
					int x = p[j].x - p[k].x, y = p[j].y - p[k].y;
					if (y < 0) {
						x = -x;
						y = -y;
					} else if (y == 0 && x < 0) x = -x;
					int gcd = gcd(x, y);
					x /= gcd;
					y /= gcd;
					long key = y * 1000000001L + x;
					final long angle = (long)(p[k].x - p[j].x) * (p[j].y) - (long)p[j].x * (p[k].y - p[j].y);
					hash.compute(key, (u, v) -> {
						if (v == null) {
							v = new java.util.HashMap<Long, Integer>();
						}
						v.compute(angle, (k2, v2) -> v2 == null ? 1 : v2 + 1);
						return v;
					});
				}
			}
			int ans = 1;
			for (java.util.Map.Entry<Long, java.util.Map<Long, Integer>> j : hash.entrySet()) {
				//out.println(j);
				int tmp = 0;
				java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(java.util.Comparator.reverseOrder());
				for (int k : j.getValue().values()) {
					k = (int)Math.sqrt(2 * k) + 1;
					if ((k & 1) == 0) tmp += k;
					else pq.add(k);
				}
				if (!pq.isEmpty()) tmp += pq.poll() - 1;
				if (!pq.isEmpty()) tmp += pq.poll() - 1;
				tmp += 2;
				ans = Math.max(ans, tmp);
			}
			ans = Math.min(ans, N);
			out.println(String.format("Case #%d: %d", i, ans));
		}
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
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
