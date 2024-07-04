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
		int[] pascal = {1, 1, 2, 3, 6, 10, 20, 35, 70, 126, 252,
				462, 924, 1716, 3432, 6435, 12870, 24310, 48620, 92738, 184756,
				352716, 705432, 1352078, 2704156, 5200300, 10400600, 20058300, 40116600, 77558760, 155117520,
				300540195, 601080390};
		cont: for (int t = 1;t <= T;++ t) {
			int N = fs.nextInt();
			int max = 0;
			ArrayList<Integer> ans = new ArrayList<>();
			while (pascal[max] <= N) {
				ans.add(max + 1);
				N -= pascal[max];
				++ max;
			}
			while(N > 0) {
				if (max % 2 == 0) -- max;
				if (pascal[max] <= N) {
					ans.add(max + 1);
					N -= pascal[max];
				} else -- max;
			}
			ans.sort(Comparator.naturalOrder());
			out.println(String.format("Case #%d:", t));
			int last = 0, add = 0;
			for (int i : ans) {
				if (last == i) add = 2 - add;
				last = i;
				out.println(String.format("%d %d", i, i + 1 + add >> 1));
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
