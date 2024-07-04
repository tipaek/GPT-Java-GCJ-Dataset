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

	public void solve(FastScanner fs, java.io.PrintWriter out) {
		int T = fs.nextInt(), N = fs.nextInt(), C = fs.nextInt();
		AI[] ai = new AI[T];
		for (int i = 0;i < T;++ i) ai[i] = new AI(N, T, C);
		while(true) {
			int sum = 0;
			for (int i = 0;i < T;++ i) {
				int next = ai[i].next();
				sum += next;
				if (i != 0) out.print(" ");
				out.print(next);
			}
			out.println();
			out.flush();
			if (sum == 0) {
				for (int i = 0;i < T;++ i) {
					if (i != 0) out.print(" ");
					out.print(ai[i].ans1 + " " + ai[i].ans2);
				}
				out.println();
				break;
			}
			for (int i = 0;i < T;++ i) {
				ai[i].result(fs.nextInt());
			}
		}
	}

	class AI {
		int choose = 0, count = 0;
		public int ans1 = 1, ans2 = 2;
		boolean[] live;
		int T, C;
		AI(int N, int T, int C) {
			this.T = T;
			this.C = C;
			live = new boolean[N];
			Arrays.fill(live, true);
		}
		int next() {
			return choose;
		}

		void result(int last) {
			if (choose == 0) return;
			if (last == 0) {
				live[count] = false;
				count = 0;
				++ choose;
				if (choose >= live.length) choose = 0;
				int up = 0, down = 0;
				for (int i = 0;i < live.length;++ i) {
					for (int j = i + 1;j < live.length;++ j) {
						if (!(live[i] && live[j])) continue;
						++ down;
						if (i + j >= live.length) ++ up;
					}
				}
				if (up * T >= down * C) {
					ans1 = choose;
					ans2 = choose + 1;
					choose = 0;
				}
			} else {
				++ count;
			}
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
