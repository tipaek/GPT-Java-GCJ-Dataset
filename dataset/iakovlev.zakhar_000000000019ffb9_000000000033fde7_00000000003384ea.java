import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	FastScanner in;
	PrintWriter out;
	boolean systemIO = true;

	public static void quickSort(int[] a, int from, int to) {
		if (to - from <= 1) {
			return;
		}
		int i = from;
		int j = to - 1;
		int x = a[from + (new Random()).nextInt(to - from)];
		while (i <= j) {
			while (a[i] < x) {
				i++;
			}
			while (a[j] > x) {
				j--;
			}
			if (i <= j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			}
		}
		quickSort(a, from, j + 1);
		quickSort(a, j + 1, to);
	}

	public long gcd(long x, long y) {
		if (y == 0) {
			return x;
		}
		if (x == 0) {
			return y;
		}
		return gcd(y, x % y);
	}

	public boolean prime(long x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public long pow(long x, long p) {
		if (p == 0) {
			return 1;
		}
		long t = pow(x, p / 2);
		t *= t;
		t %= mod;
		if (p % 2 == 1) {
			t *= x;
			t %= mod;
		}
		return t;
	}

	public class Pair implements Comparable<Pair> {
		long x;
		long y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (x > o.x) {
				return 1;
			}
			if (x < o.x) {
				return -1;
			}
			if (y > o.y) {
				return 1;
			}
			if (y < o.y) {
				return -1;
			}
			return 0;
		}

	}

	public boolean check(int x, int y, int r, int c, boolean[][] used) {
		return 0 <= x && x < r && 0 <= y && y < c && !used[x][y];
	}

	public class Line implements Comparable<Line> {
		int x;
		int y;
		int number;
		int fill;

		public Line(int x, int y, int number, int fill) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.fill = fill;
		}

		@Override
		public int compareTo(Line o) {
			if (y != o.y) {
				return y - o.y;
			}
			return number - o.number;
		}

	}

	public class Point implements Comparable<Point> {
		int x;
		int type;
		int number;

		public Point(int x, int type, int number) {
			this.x = x;
			this.type = type;
			this.number = number;
		}

		@Override
		public int compareTo(Point o) {
			if (x != o.x) {
				return x - o.x;
			}
			if (type != o.type) {
				return type - o.type;
			}
			return number - o.number;
		}

	}

	public class SegmentTree {
		int pow;
		long[] sum;

		public SegmentTree(long[] a) {
			pow = 1;
			while (pow < a.length) {
				pow *= 2;
			}
			sum = new long[2 * pow];
			for (int i = 0; i < a.length; i++) {
				sum[pow + i] = a[i];
			}
			for (int i = pow - 1; i > 0; i--) {
				sum[i] = f(sum[2 * i], sum[2 * i + 1]);
			}
		}

		public long get(int v, int tl, int tr, int l, int r) {
			if (l > r) {
				return 0;
			}
			if (l == tl && r == tr) {
				return sum[v];
			}
			int tm = (tl + tr) / 2;
			return f(get(2 * v, tl, tm, l, Math.min(r, tm)), get(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r));
		}

		public long f(long a, long b) {
			return Math.max(a, b);
		}
	}

	long mod = 1000000007;

	public class Fenvik {
		int[] sum;

		public Fenvik(int n) {
			sum = new int[n];
		}

		public void add(int x, int d) {
			for (int i = x; i < sum.length; i = (i | (i + 1))) {
				sum[i] += d;
			}
		}

		public int sum(int r) {
			int ans = 0;
			for (int i = r; i >= 0; i = (i & (i + 1)) - 1) {
				ans += sum[i];
			}
			return ans;
		}

		public int sum(int l, int r) {
			if (l > r) {
				return 0;
			}
			return sum(r) - sum(l - 1);
		}
	}

	public class Segment implements Comparable<Segment> {
		long x;
		long y;

		public Segment(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Segment o) {
			if (x > o.x) {
				return 1;
			}
			if (x < o.x) {
				return -1;
			}
			return 0;
		}
	}

	Random random = new Random(566);

	public void write(int[] a, int value, int x, boolean not, boolean rev) {
		if (not) {
			value ^= 1;
		}
		if (rev) {
			x = a.length - x - 1;
		}
		a[x] = value;
	}

	public boolean previousPermutation(int[] permutation) {
		int n = permutation.length;
		for (int i = n - 2; i >= 0; i--) {
			if (permutation[i] > permutation[i + 1]) {
				int w = i + 1;
				while (w < n - 1 && permutation[i] > permutation[w]) {
					w++;
				}
				if (w > i + 1) {
					w--;
				}
				int c = permutation[i];
				permutation[i] = permutation[w];
				permutation[w] = c;
				for (int j = i + 1; j < n; j++) {
					int k = n - 1 - (j - i - 1);
					if (k <= j) {
						break;
					}
					c = permutation[j];
					permutation[j] = permutation[k];
					permutation[k] = c;
				}
				i++;
				while (i < n - 1 && permutation[i] < permutation[i + 1]) {
					c = permutation[i];
					permutation[i] = permutation[i + 1];
					permutation[i + 1] = c;
				}
				return true;
			}
		}
		return false;
	}

	public void rec(int i, int j) {
		if (j == m) {
			int th = 0;
			for (int k = 0; k < m; k++) {
				th += a[k][k];
			}
			if (trace[m].containsKey(th)) {
				number[m].put(th, number[m].get(th) + 1);
				return;
			}
			int[][] ans = new int[m][m];
			for (int k = 0; k < ans.length; k++) {
				ans[k] = a[k].clone();
			}
			trace[m].put(th, ans);
			number[m].put(th, 1);
			return;
		}
		f: for (int k = 0; k < m; k++) {
			for (int i0 = 0; i0 < i; i0++) {
				if (a[i0][j] == k) {
					continue f;
				}
			}
			for (int j0 = 0; j0 < j; j0++) {
				if (a[i][j0] == k) {
					continue f;
				}
			}
			a[i][j] = k;
			rec((i + 1) % m, j + (i + 1) / m);
		}
	}

	TreeMap<Integer, int[][]>[] trace;
	TreeMap<Integer, Integer>[] number;

	int m;
	int[][] a;

	public class Fraction implements Comparable<Fraction> {
		long x;
		long y;

		public Fraction(long x, long y, boolean needNorm) {
			if (needNorm) {
				if (x < 0) {
					x = -x;
					y = -y;
				} else if (x == 0) {
					y = 1;
				}
				if (x * y != 0) {
					long gcd = gcd(x, Math.abs(y));
					x /= gcd;
					y /= gcd;
				}
			}
			this.x = x;
			this.y = y;
		}

		public Fraction clone() {
			return new Fraction(x, y, false);
		}

		public String toString() {
			return x + "/" + y;
		}

		@Override
		public int compareTo(Fraction o) {
			long res = x * o.y - y * o.x;
			if (res > 0) {
				return 1;
			}
			if (res < 0) {
				return -1;
			}
			return 0;
		}
	}

	long max = Integer.MAX_VALUE - 1;

	@SuppressWarnings("unchecked")
	public void solve() {
//		for (int l = 1; l < 100; l++) {
//			for (int r = 1; r < 100; r++) {
//				long[] ansSlow = solveSlow(l, r);
//				long[] ansStupid = solveFast(l, r);
//				for (int i = 0; i < ansStupid.length; i++) {
//					if (ansSlow[i] != ansStupid[i]) {
//						System.err.println(l + " " + r);
//						System.err.println(ansSlow[0] + " " + ansSlow[1] + " " + ansSlow[2]);
//						System.err.println(ansStupid[0] + " " + ansStupid[1] + " " + ansStupid[2]);
//					}
//				}
//			}
//		}
//		System.exit(0);
		int nTest = in.nextInt();
		f: for (int test = 1; test <= nTest; test++) {
			out.print("Case #" + test + ": ");
			long l = in.nextLong();
			long r = in.nextLong();
//			long[] ansSlow = solveSlow(l, r);
//			long[] ansStupid = solveStupid(l, r);
//			for (int i = 0; i < ansStupid.length; i++) {
//				if (ansSlow[i] != ansStupid[i]) {
//					System.err.println(l + " " + r);
//				}
//			}
			long[] ans = solveFast(l, r);
			out.println(ans[0] + " " + ans[1] + " " + ans[2]);
		}
	}

	public long[] solveSlow(long l, long r) {
		long move = 1;
		while (true) {
			if (l >= r) {
				if (l < move) {
					break;
				}
				l -= move;
				move++;
			} else {
				if (r < move) {
					break;
				}
				r -= move;
				move++;
			}
		}
		long[] ans = { move - 1, l, r };
		return ans;
	}

	public long[] solveStupid(long l, long r) {
		long move = 1;
		while (l >= r) {
			if (l < move) {
				break;
			}
			l -= move;
			move++;
		}
		while (l < r) {
			if (r < move) {
				break;
			}
			r -= move;
			move++;
		}
		while (true) {
			if (l < move) {
				break;
			}
			l -= move;
			move++;
			if (r < move) {
				break;
			}
			r -= move;
			move++;
		}
		long[] ans = { move - 1, l, r };
		return ans;
	}

	public long[] solveFast(long l, long r) {
		long move = 1;
		if (l >= r) {
			long left = 0;
			long right = max;
			while (left + 1 < right) {
				long m = left + (right - left) / 2;
				long d = sum(m);
				if (l - d < r) {
					right = m;
				} else {
					left = m;
				}
			}
			move += left;
			l -= sum(left);
			if (l >= move) {
				l -= move;
				move++;
			}
		}
		if (l < r) {
			long left = 0;
			long right = max;
			while (left + 1 < right) {
				long m = left + (right - left) / 2;
				long d = delete(move, m);
				if (r - d <= l) {
					right = m;
				} else {
					left = m;
				}
			}
			r -= delete(move, left);
			move += left;
			if (r >= move) {
				r -= move;
				move++;
			}
		}
		if (l >= move) {
			l -= move;
			move++;
		}
		if (r >= move) {
			r -= move;
			move++;
		}
		long answer = move;
		long left = 0;
		long right = max;
		while (left + 1 < right) {
			long m = left + (right - left) / 2;
			long d = delete2(move, m);
			if (l - d >= 0) {
				left = m;
			} else {
				right = m;
			}
		}
		answer += left;
		l -= delete2(move, left);
		left = 0;
		right = max;
		while (left + 1 < right) {
			long m = left + (right - left) / 2;
			long d = delete2(move + 1, m);
			if (r - d >= 0) {
				left = m;
			} else {
				right = m;
			}
		}
		answer += left;
		r -= delete2(move + 1, left);
		// while (true) {
		// if (l < move) {
		// break;
		// }
		// l -= move;
		// move++;
		// if (r < move) {
		// break;
		// }
		// r -= move;
		// move++;
		// }
		long[] ans = { answer - 1, l, r };
		return ans;
	}

	public long delete2(long move, long n) {
		return n * (move + n - 1);
	}

	public long delete(long first, long n) {
		return sum(first + n - 1) - sum(first - 1);
	}

	public long sum(long x) {
		return x * (x + 1) / 2;
	}

	public void run() {
		try {
			if (systemIO) {
				in = new FastScanner(System.in);
				out = new PrintWriter(System.out);
			} else {
				in = new FastScanner(new File("input.txt"));
				out = new PrintWriter(new File("output.txt"));
			}
			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				return null;
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

	}

	// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	public static void main(String[] arg) {
		new Solution().run();
	}
}