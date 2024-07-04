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
		int x;
		int y;
		int n;

		public Pair(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}

		@Override
		public int compareTo(Pair o) {
			if (x != o.x) {
				return x - o.x;
			}
			return y - o.y;
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

	public class Digit implements Comparable<Digit> {
		char c;
		int n;

		public Digit(char c, int n) {
			this.c = c;
			this.n = n;
		}

		@Override
		public int compareTo(Digit o) {
			return n - o.n;
		}

	}

	@SuppressWarnings("unchecked")
	public void solve() {
		int nTest = in.nextInt();
		f: for (int test = 1; test <= nTest; test++) {
			out.print("Case #" + test + ": ");
			int u = in.nextInt();
			HashMap<Character, Integer> map = new HashMap<>();
			HashSet<Character> all = new HashSet<>();
			for (int i = 0; i < 10000; i++) {
				in.next();
				String s = in.next();
				if (map.containsKey(s.charAt(0))) {
					map.put(s.charAt(0), map.get(s.charAt(0)) + 1);
				} else {
					map.put(s.charAt(0), 1);
				}
				for (int j = 0; j < s.length(); j++) {
					all.add(s.charAt(j));
				}
			}
			Digit[] d = new Digit[9];
			int c = 0;
			for (char ch : map.keySet()) {
				d[c++] = new Digit(ch, map.get(ch));
				all.remove(ch);
			}
			Arrays.sort(d);
			for (char ch : all) {
				out.print(ch);
			}
			for (int i = d.length - 1; i >= 0; i--) {
				out.print(d[i].c);
			}
			out.println();
		}
	}
	
	public int[][] find(int n, int k) {
		if (k == n + 1 || k == n * n - 1) {
			return null;
		}
		int[][] ans = new int[n][n];
		k -= n;
		if (k % n == 0) {
			ans = fill1(n, k / n);
		} else if (k == 2 || k == n * n - n - 2) {
			if (k == 2) {
				ans = fill2(n, 0, 1);
			} else {
				ans = fill2(n, n - 1, n - 2);
			}
		} else {
			f: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					for (int l = 0; l < n; l++) {
						if (i == l || j == l) {
							continue;
						}
						if (i * (n - 2) + j + l == k) {
							ans = fill3(n, i, j, l);
							break f;
						}
					}
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j]++;
			}
		}
		return ans;
	}

	public int[][] fill1(int n, int x) {
		int[][] ans = new int[n][n];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j] = (i - j + n) % n;
			}
		}
		int[] permutation = new int[n];
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] = i;
		}
		permutation[x] = 0;
		permutation[0] = x;
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < permutation.length; j++) {
				ans[i][j] = permutation[ans[i][j]];
			}
		}
		return ans;
	}

	public int[][] fill2(int n, int x, int y) {
		int[][] ans = new int[n][n];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j] = (j - i + n) % n;
			}
		}
		if (n % 2 == 0) {
			int[][] ans1 = fill1(n / 2, 0);
			for (int i = 0; i < ans1.length; i++) {
				for (int j = 0; j < ans1.length; j++) {
					ans[2 * i][2 * j] = 2 * ans1[i][j];
					ans[2 * i + 1][2 * j + 1] = 2 * ans1[i][j];
					ans[2 * i + 1][2 * j] = 2 * ans1[i][j] + 1;
					ans[2 * i][2 * j + 1] = 2 * ans1[i][j] + 1;
				}
			}
			ans[n - 2][n - 2] = 1;
			ans[n - 1][n - 1] = 1;
			ans[n - 2][n - 1] = 0;
			ans[n - 1][n - 2] = 0;
		} else {
			ans[n - 3][0] = 1;
			ans[n - 2][0] = 2;
			ans[n - 1][0] = 3;
			int begin = 2;
			int z = 2;
			for (int i = 1; i < n - 4; i++) {
				for (int dz = 0; dz < 3; dz++) {
					ans[n - 3 + (z + dz) % 3][i] = begin + dz;
				}
				begin++;
				z += 2;
				z %= 3;
			}
			ans[n - 3][n - 3] = 0;
			ans[n - 3][n - 2] = n - 1;
			ans[n - 3][n - 1] = 2;
			ans[n - 2][n - 2] = 1;
			ans[n - 2][n - 1] = 0;
			ans[n - 1][n - 2] = 0;
			ans[n - 1][n - 1] = 1;

			ans[n - 3][n - 4] = 0;
			int sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum += ans[n - 3][i];
			}
			ans[n - 3][n - 4] = n * (n - 1) / 2 - sum;

			f: for (int a = n - 3; a < ans.length; a++) {
				if (a == ans[n - 3][n - 4]) {
					continue;
				}
				int b = 3 * n - 6 - a - ans[n - 3][n - 4];
				f1: for (int c = n - 2; c < ans.length; c++) {
					if (c == a) {
						continue;
					}
					int d = 2 * n - 3 - c;
					if (b == d) {
						continue;
					}
					for (int i = n - 6; i < n - 4; i++) {
						if (ans[n - 2][i] == a || ans[n - 2][i] == c) {
							continue f1;
						}
						if (ans[n - 1][i] == b || ans[n - 1][i] == d) {
							continue f1;
						}
					}
					ans[n - 2][n - 4] = a;
					ans[n - 1][n - 4] = b;
					ans[n - 2][n - 3] = c;
					ans[n - 1][n - 3] = d;
					break f;
				}
			}
		}
		int[] permutation = new int[n];
		permutation[0] = x;
		permutation[1] = y;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < permutation.length; i++) {
			set.add(i);
		}
		set.remove(x);
		set.remove(y);
		for (int i = 2; i < permutation.length; i++) {
			permutation[i] = set.pollFirst();
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < permutation.length; j++) {
				ans[i][j] = permutation[ans[i][j]];
			}
		}
		return ans;
	}

	public int[][] fill3(int n, int x, int y, int z) {
		int[][] ans = new int[n][n];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j] = (j - i + n) % n;
			}
		}
		for (int i = 0; i < ans.length; i++) {
			int c = ans[n - 2][i];
			ans[n - 2][i] = ans[n - 1][i];
			ans[n - 1][i] = c;
		}
		int[] permutation = new int[n];
		permutation[0] = x;
		permutation[1] = y;
		permutation[n - 1] = z;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < permutation.length; i++) {
			set.add(i);
		}
		set.remove(x);
		set.remove(y);
		set.remove(z);
		for (int i = 2; i < permutation.length - 1; i++) {
			permutation[i] = set.pollFirst();
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < permutation.length; j++) {
				ans[i][j] = permutation[ans[i][j]];
			}
		}
		return ans;
	}

	public boolean check(int[][] a, int n, int trace) {
		if (trace == n + 1 || trace == n * n - 1) {
			return a == null;
		}
		if (a.length != n) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != n) {
				return false;
			}
		}
		for (int i = 0; i < a.length; i++) {
			trace -= a[i][i];
		}
		if (trace != 0) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < a.length; j++) {
				set.add(a[i][j]);
			}
			for (int j = 1; j <= a.length; j++) {
				if (!set.contains(j)) {
					return false;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < a.length; j++) {
				set.add(a[j][i]);
			}
			for (int j = 1; j <= a.length; j++) {
				if (!set.contains(j)) {
					return false;
				}
			}
		}
		return true;
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