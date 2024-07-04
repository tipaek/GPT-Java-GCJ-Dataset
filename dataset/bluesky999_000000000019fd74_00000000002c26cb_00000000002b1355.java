import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Solution {

	private static final int MAXN = 5000;
	private static final String NO = "NO";
	private static final String YES = "YES";
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	private static final long MOD = 1000000007L;
	private static final int MAX = 200000;

	void solve() {
		int Q = ni();
		for (int q = 1; q <= Q; q++) {
			out.print("Case #" + q + ": ");

			int N = ni();
			int M = ni();
			TreeMap<Integer, Integer> rows[] = new TreeMap[N];
			TreeMap<Integer, Integer> cols[] = new TreeMap[M];
			for (int r = 0; r < N; r++)
				rows[r] = new TreeMap<Integer, Integer>();
			for (int c = 0; c < M; c++)
				cols[c] = new TreeMap<Integer, Integer>();

			for (int r = 0; r < N; r++)
				for (int c = 0; c < M; c++) {
					int n = ni();
					rows[r].put(c, n);
					cols[c].put(r, n);
				}

			long ans = 0;
			int cnt = 1;
			boolean erased[][] = new boolean[N][M];
			while (cnt > 0) {
				for (int r = 0; r < N; r++)
					for (Entry<Integer, Integer> col : rows[r].entrySet()) {
						ans += col.getValue();
						cnt = 0;
						int sum = 0;
						Entry<Integer, Integer> en = rows[r].floorEntry(col.getKey() - 1);
						if (en != null) {
							sum += en.getValue();
							cnt++;
						}
						en = rows[r].ceilingEntry(col.getKey() + 1);
						if (en != null) {
							sum += en.getValue();
							cnt++;
						}
						en = cols[col.getKey()].ceilingEntry(r + 1);
						if (en != null) {
							sum += en.getValue();
							cnt++;
						}
						en = cols[col.getKey()].floorEntry(r - 1);
						if (en != null) {
							sum += en.getValue();
							cnt++;
						}
						if (col.getValue() * cnt < sum)
							erased[r][col.getKey()] = true;
					}
				cnt = 0;

				for (int r = 0; r < N; r++) {
					Iterator<Entry<Integer, Integer>> it = rows[r].entrySet().iterator();
					while (it.hasNext()) {
						Entry<Integer, Integer> col = it.next();
						if (erased[r][col.getKey()]) {
							cnt++;
							it.remove();
							cols[col.getKey()].remove(r);
						}
					}
				}
			}
			out.println(ans);
		}

	}

	private String getSuffix(String str) {
		int i = str.lastIndexOf('*');
		return str.substring(i + 1);
	}

	private String getPref(String str) {
		int i = str.indexOf('*');
		return str.substring(0, i);
	}

	private boolean matchAll(String str, String[] a) {
		for (String p : a)
			if (!Pattern.matches(p.replaceAll("\\*", ".*"), str))
				return false;
		return true;
	}

	long power(long a, long b) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 != 0) {
				x = (x * y) % MOD;
			}
			y = (y * y) % MOD;
			b /= 2;
		}
		return x % MOD;
	}

	private long gcd(long a, long b) {
		while (a != 0) {
			long tmp = b % a;
			b = a;
			a = tmp;
		}
		return b;
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
	private boolean vis[];

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
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
									// ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n) {
			if (!(isSpaceChar(b)))
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

	private List<Integer> na2(int n) {
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			a.add(ni());
		return a;
	}

	private int[][] na(int n, int m) {
		int[][] a = new int[n][];
		for (int i = 0; i < n; i++)
			a[i] = na(m);
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

	private long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
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