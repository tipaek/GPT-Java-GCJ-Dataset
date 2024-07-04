public class Solution {

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int i = 1;T --> 0;++ i) {
			int N = fs.nextInt();
			int[][] M = new int[N][N];
			for (int y = 0;y < N;++ y) for (int x = 0;x < N;++ x) M[y][x] = fs.nextInt();
			int k = 0, r = 0, c = 0;
			for (int j = 0;j < N;++ j) k += M[j][j];
			for (int y = 0;y < N;++ y) {
				java.util.Set<Integer> set = new java.util.HashSet<Integer>();
				for (int x = 0;x < N;++ x) set.add(M[y][x]);
				r += set.size() == N ? 0 : 1;
			}
			for (int x = 0;x < N;++ x) {
				java.util.Set<Integer> set = new java.util.HashSet<Integer>();
				for (int y = 0;y < N;++ y) set.add(M[y][x]);
				c += set.size() == N ? 0 : 1;
			}
			System.out.println(String.format("Case #%d: %d %d %d", i, k, r, c));
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

		private int readByte() {
			return hasNextByte() ? buffer[ptr++] : -1;
		}

		private static boolean isPrintableChar(int c) {
			return 33 <= c && c <= 126;
		}

		public boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[ptr]))
				ptr++ ;
			return hasNextByte();
		}

		public String next() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (isPrintableChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public long nextLong() {
			if (!hasNext()) throw new java.util.NoSuchElementException();
			long n = 0;
			boolean minus = false;
			int b = readByte();
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			if (b < '0' || '9' < b) throw new NumberFormatException();
			while (true) {
				if ('0' <= b && b <= '9') {
					n *= 10;
					n += b - '0';
				} else if (b == -1 || !isPrintableChar(b)) {
					return minus ? -n : n;
				} else {
					throw new NumberFormatException();
				}
				b = readByte();
			}
		}

		public int nextInt() {
			long nl = nextLong();
			if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
			return (int)nl;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
