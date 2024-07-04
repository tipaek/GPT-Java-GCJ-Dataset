import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

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

	public class Pair {
		int x;
		long v;
		long d;

		public Pair(int x, long v, long d) {
			this.x = x;
			this.v = v;
			this.d = d;
		}
		
		public Pair clone() {
			return new Pair(x, v, d);
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

	public void dfsRev(int v) {
		pb[v] = true;
		for (int v1 : from[v]) {
			if (!pb[v1]) {
				dfsRev(v1);
			}
		}
	}

//	public void dfs1(int v) {
//		pb1[v] = true;
//		for (int v1 : from[v]) {
//			if (!pb1[v1]) {
//				dfs1(v1);
//			}
//		}
//	}
//
//	public void dfsTopSort(int v) {
//		used[v] = true;
//		for (int i = 0; i < to[v].size(); ++i) {
//			int to1 = to[v].get(i);
//			if (!used[to1])
//				dfsTopSort(to1);
//		}
//		ans.add(v);
//	}
//
//	public void topological_sort() {
//		for (int i = 0; i < n; ++i)
//			used[i] = false;
//		ans.clear();
//		for (int i = 0; i < n; i++)
//			if (!used[i])
//				dfsTopSort(i);
//	}

	int n;
	boolean[] pb;
	BigInteger[] m;
//	ArrayList<Integer> ans;
	ArrayList<Integer>[] to;
	ArrayList<Integer>[] from;
	
	
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

	public long rand() {
		long len = 0;
		for (Segment s : set) {
			len += s.y - s.x + 1;
		}
		if (len == 0) {
			return 0;
		}
		long x = Math.abs(random.nextLong()) % len;
		for (Segment s : set) {
			if (x <= s.y - s.x) {
				return s.x + x;
			}
			x -= s.y - s.x + 1;
		}
		return set.first().x;
	}
	
	public boolean update(long p) {
		Segment s = set.lower(new Segment(p + 1, p + 1));
		if (s == null || s.y < p) {
			return false;
		}
		set.remove(s);
		if (p + sz <= s.y) {
			set.add(new Segment(p + sz, s.y));
		}
		if (p - sz >= s.x) {
			set.add(new Segment(s.x, p - sz));
		}
		return true;
	}
	
	public int sum() {
		int ans = 0;
		for (Segment s : set) {
			ans += 1 + (s.y - s.x) * 2 / 3 / sz;
		}
		return ans;
	}
	
	Random random = new Random(566);
	TreeSet<Segment> set = new TreeSet<>();
	long sz = 10000000000L;
	long len = 1000000000000L;

	public void solve() {
		int nTest = in.nextInt();
		for (int test = 1; test <= nTest; test++) {
			String s = in.next();
			ArrayList<Character> list = new ArrayList<>();
			int bal = 0;
			for (int i = 0; i < s.length(); i++) {
				while (bal < s.charAt(i) - '0') {
					bal++;
					list.add('(');
				}
				while (bal > s.charAt(i) - '0') {
					bal--;
					list.add(')');
				}
				list.add(s.charAt(i));
			}
			while (bal > 0) {
				list.add(')');
				bal--;
			}
			out.print("Case #" + test + ": ");
			for (char c : list) {
				out.print(c);
			}
			out.println();
		}
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