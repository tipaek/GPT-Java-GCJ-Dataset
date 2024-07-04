import java.io.*;
import java.util.*;

public class Solution implements Runnable {
	boolean judge = true;
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int T = scn.nextInt();
		for (int tt = 1; tt <= T; tt++) {
			out.print("Case #" + tt + ": ");

			String s = scn.next();
			int n = s.length();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = s.charAt(i) - '0';
			}
			
			min = new int[n][n][2];
			for(int i = 0; i < n; i++) {
				min[i][i][0] = arr[i];
				min[i][i][1] = i;
				for(int j = i + 1; j < n; j++) {
					if(min[i][j - 1][0] < arr[j]) {
						min[i][j][0] = min[i][j - 1][0];
						min[i][j][1] = min[i][j - 1][1];
					} else {
						min[i][j][0] = arr[j];
						min[i][j][1] = j;
					}
				}
			}
			
			bit = new int[n + 2];
			
			int[][] ans = new int[n][2];
			rec(arr, ans, 0, n - 1);
			
			for(int i = 0; i < n; i++) {
				while(ans[i][0]-- > 0) {
					out.print('(');
				}
				out.print(arr[i]);
				while(ans[i][1]-- > 0) {
					out.print(')');
				}
			}
			out.println();
		}
	}
	
	void rec(int[] arr, int[][] ans, int l, int r) {
		if(l > r) {
			return;
		}
		int sub = sum(bit, l + 1);
		int mn = min[l][r][0] - sub, mni = min[l][r][1];
		
		ans[l][0] += mn;
		ans[r][1] += mn;
		
		add(bit, l + 1, mn);
		add(bit, r + 2, -mn);
		
		rec(arr, ans, l, mni - 1);
		rec(arr, ans, mni + 1, r);
	}
	
	int[] bit;
	int[][][] min;
	
	void add(int[] bit, int ind, int val) {
		while (ind < bit.length) {
			bit[ind] += val;
			ind += ind & (-ind);
		}
	}

	int sum(int[] bit, int ind) {
		int rv = 0;
		while (ind > 0) {
			rv += bit[ind];
			ind -= ind & (-ind);
		}
		return rv;
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