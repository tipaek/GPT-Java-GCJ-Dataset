import java.io.*;
import java.util.*;

public class Solution implements Runnable {
	boolean judge = true;
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int[][] pascal = pre(35);

		int[] dx = { -1, -1, 0, 0, 1, 1 };
		int[] dy = { -1, 0, -1, 1, 0, 1 };

		int T = scn.nextInt();
		for (int tt = 1; tt <= T; tt++) {
			out.print("Case #" + tt + ": ");

			int n = scn.nextInt(), pos = 0;
			int[][] ans = new int[1005][2];

			int r = 1, c = 1;
			ans[pos++] = new int[] { r, c };
			n--;

			A = null;
			func(pascal, dx, dy, n, r, c, ans, pos);
			if (A != null) {
				out.println();
				for (int i = 0; i < A.length; i++) {
					out.println(A[i][0] + " " + A[i][1]);
				}
			}
		}
	}

	int[][] A;

	void func(int[][] pascal, int[] dx, int[] dy, int n, int r, int c, int[][] ans, int pos) {
		if (pos >= 500) {
			return;
		}
		if (n == 0) {
			A = new int[pos][2];
			for (int i = 0; i < pos; i++) {
				for (int j = 0; j < 2; j++) {
					A[i][j] = ans[i][j];
				}
			}
			return;
		}

		for (int i = 0; i < 6; i++) {
			int row = r + dx[i], col = c + dy[i];
			if (row > 0 && row < 35 && col > 0 && col <= row) {
				int x = pascal[row][col];
				ans[pos][0] = row;
				ans[pos][1] = col;
				func(pascal, dx, dy, n - x, row, col, ans, pos + 1);
				if (A != null) {
					return;
				}
				ans[pos][0] = 0;
				ans[pos][1] = 0;
			}
		}
	}

	int[][] pre(int size) {
		int[][] arr = new int[size][];
		arr[1] = new int[2];
		arr[1][1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = new int[i + 1];
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i - 1][j - 1];
				if (j != i) {
					arr[i][j] += arr[i - 1][j];
				}
			}
		}
		return arr;
	}

	public void run() {
		long time = System.currentTimeMillis();
		boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
		out = new PrintWriter(System.out);
		scn = new FastReader(oj);
		solve();
		out.flush();
		if (!oj) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) {
		new Thread(null, new Solution(), "Main", 1 << 28).start();
	}

	class FastReader {
		InputStream is;

		public FastReader(boolean onlineJudge) {
			is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		}

		public FastReader() {
			is = System.in;
		}

		byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;

		int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				ptrbuf = 0;
				try {
					lenbuf = is.read(inbuf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}

		boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		char nextChar() {
			return (char) skip();
		}

		String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		String nextLine() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while ((!isSpaceChar(b) || b == ' ')) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		char[] next(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		char[][] nextMatrix(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = next(m);
			return map;
		}

		int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		int[][] next2DInt(int n, int m) {
			int[][] arr = new int[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextIntArray(m);
			}
			return arr;
		}

		long[][] next2DLong(int n, int m) {
			long[][] arr = new long[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLongArray(m);
			}
			return arr;
		}

		int[] shuffle(int[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				int c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		long[] shuffle(long[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				long c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		int[] uniq(int[] arr) {
			Arrays.sort(arr);
			int[] rv = new int[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		long[] uniq(long[] arr) {
			Arrays.sort(arr);
			long[] rv = new long[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		int[] reverse(int[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		long[] reverse(long[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}
	}
}