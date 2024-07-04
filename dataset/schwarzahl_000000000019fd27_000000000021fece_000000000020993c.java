import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution main = new Solution();
		main.solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int num = 1; num <= T; num++) {
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					M[r][c] = sc.nextInt();
				}
			}
			int k = 0;
			for (int i = 0; i < N; i++) {
				k += M[i][i];
			}
			int r = 0;
			for (int r_i = 0; r_i < N; r_i++) {
				Set<Integer> set = new HashSet<>();
				for (int c_i = 0; c_i < N; c_i++) {
					set.add(M[r_i][c_i]);
				}
				if (set.size() != N) {
					r++;
				}
			}
			int c = 0;
			for (int c_i = 0; c_i < N; c_i++) {
				Set<Integer> set = new HashSet<>();
				for (int r_i = 0; r_i < N; r_i++) {
					set.add(M[r_i][c_i]);
				}
				if (set.size() != N) {
					c++;
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", num, k, r, c);
		}
	}

	class Scanner {
		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int index;
		private int length;

		public Scanner(InputStream in) {
			this.in = in;
		}

		private boolean isPrintableChar(int c) {
			return '!' <= c && c <= '~';
		}

		private boolean isDigit(int c) {
			return '0' <= c && c <= '9';
		}

		private boolean hasNextByte() {
			if (index < length) {
				return true;
			} else {
				try {
					length = in.read(buffer);
					index = 0;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return length > 0;
			}
		}

		private boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[index])) {
				index++;
			}
			return hasNextByte();
		}

		private int readByte() {
			return hasNextByte() ? buffer[index++] : -1;
		}

		public String next() {
			if (!hasNext()) {
				throw new RuntimeException("no input");
			}
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (isPrintableChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public long nextLong() {
			if (!hasNext()) {
				throw new RuntimeException("no input");
			}
			long value = 0L;
			boolean minus = false;
			int b = readByte();
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (isPrintableChar(b)) {
				if (isDigit(b)) {
					value = value * 10 + (b - '0');
				}
				b = readByte();
			}
			return minus ? -value : value;
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}