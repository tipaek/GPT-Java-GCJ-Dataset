public class Solution {

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int x = 1;T --> 0;++ x) {
			String S = fs.next();
			int depth = 0;
			System.out.print("Case #" + x + ": ");
			for (char i : S.toCharArray()) {
				int d = Character.digit(i, 10);
				while(depth < d) {
					++ depth;
					System.out.print('(');
				}
				while(depth > d) {
					-- depth;
					System.out.print(')');
				}
				System.out.print(i);
			}
			while(depth > 0) {
				-- depth;
				System.out.print(')');
			}
			System.out.println();
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
