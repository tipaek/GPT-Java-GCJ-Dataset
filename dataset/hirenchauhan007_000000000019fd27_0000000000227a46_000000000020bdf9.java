import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

class Solution {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int T = ni();
		outer:
		for(int t = 1; t <= T; t++) {
			int n = ni();
			int[][] a = new int[n][];
			for(int i = 0; i < n; i++) {
				a[i] = new int[] {ni(), ni(), i};
			}
			if(!ok(a)) {
				String s = "IMPOSSIBLE";
				out.println("Case #"+t+": "+s);
				continue outer;
			}
			Arrays.sort(a, new Comparator<int[]>() {

				@Override
				public int compare(int[] x, int[] y) {
					// TODO Auto-generated method stub
					if(x[0] != y[0]) return x[0] - y[0];
					return (x[1] - x[0]) - (y[1] - y[0]);
				}
				
			});
			int ctime = -1, jtime = -1;
			char[] s = new char[n];
			for(int i = 0; i < n; i++) {
				if(ctime < a[i][0]) {
					s[a[i][2]] = 'C';
					ctime = a[i][1] - 1;
				}
				else {
					s[a[i][2]] = 'J';
					jtime = a[i][1] - 1;
				}
			}
			out.println("Case #"+t+": "+new String(s));
		}
	}
	
	public boolean ok(int[][] a) {
		int[] f = new int[24 * 60 + 5];
		for(int[] time : a) {
			f[time[1] - 1]++;
			if(time[0] > 0) f[time[0] - 1]--;
		}
		for(int i = f.length - 2; i >= 0; i--) {
			f[i] += f[i+1];
		}
		for(int i = 0; i < f.length; i++) {
			if(f[i] > 2) return false;
		}
		return true;
	}

	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
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

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private int ni() {
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

	private long nl() {
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

	private static void tr(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}