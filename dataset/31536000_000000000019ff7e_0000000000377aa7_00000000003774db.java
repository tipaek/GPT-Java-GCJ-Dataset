import java.util.Arrays;
import java.util.TreeMap;

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

	private static int dist(String t1, String t2) {
		int[][] dp = new int[t1.length() + 1][t2.length() + 1];
		for (int i = 0;i < dp.length;++ i) {
			Arrays.fill(dp[i], 0);
			dp[i][0] = i;
		}
		for (int i = 0;i <= t2.length();++ i) dp[0][i] = i;
		for (int i = 1;i < dp.length;++ i) {
			for (int j = 1;j < dp[i].length;++ j) {
				dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + (t1.charAt(i - 1) == t2.charAt(j - 1) ? 0 : 1));
			}
		}
		return dp[t1.length()][t2.length()];
	}

	public void solve(FastScanner fs, java.io.PrintWriter out) {
		int T = fs.nextInt();
		for (int c = 1;c <= T;++ c) {
			final String C = fs.next(), J = fs.next();
			TreeMap<Integer, String> ans = new TreeMap<>();
			for (int k = 1;k <= 6;++ k) {
				for (int i = 0;i < pow(3, k);++ i) {
					String tmp = "";
					for (int j = 0, t = i;j < k;++ j, t /= 3) {
						tmp += (char)('X' + t % 3);
					}
					ans.put(Math.max(dist(tmp, C), dist(tmp, J)), tmp);
				}
			}
			out.println(String.format("Case #%d: %s", c, ans.firstEntry().getValue()));
			//System.err.println(ans.firstEntry().getKey());
		}
	}

	int pow(int a, int b) {
		return b == 0 ? 1 : a * pow(a, b - 1);
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
