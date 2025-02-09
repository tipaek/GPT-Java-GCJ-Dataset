import java.util.*;

import java.io.*;
import java.math.BigInteger;

public class Solution {
	FastScanner in;
	PrintWriter out;
	boolean systemIO = true;

	public long pow(long x, long p, long mod) {
		if (p <= 0) {
			return 1;
		}
		long th = pow(x, p / 2, mod);
		th *= th;
		th %= mod;
		if (p % 2 == 1) {
			th *= x;
		}
		return th;
	}

	public class Fraction implements Comparable<Fraction> {
		long x;
		long y;

		public Fraction(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public void norm() {
			long gcd = gcd(x, y);
			x /= gcd;
			y /= gcd;
		}

		@Override
		public int compareTo(Fraction o) {
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

	public Fraction sum(Fraction a, Fraction b) {
		Fraction c = new Fraction(a.x * b.y + a.y * b.x, a.y * b.y);
		c.norm();
		return c;
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

	public class Pair implements Comparable<Pair> {
		long x;
		long y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			// if (x != o.x) {
			// return x - o.x;
			// }
			// return y - o.y;
			return 0;
		}
	}

	// public class Vertex {
	// Vertex father;
	// Vertex l;
	// Vertex r;
	// int sz;
	// long y;
	// long x;
	// int time;
	// int mintime;
	// int value;
	//
	// public Vertex(Vertex father, Vertex l, Vertex r, int sz, long y, long x, int
	// time, int mintime, int value) {
	// this.father = father;
	// this.l = l;
	// this.r = r;
	// this.sz = sz;
	// this.y = y;
	// this.x = x;
	// this.time = time;
	// this.mintime = mintime;
	// this.value = value;
	// }
	//
	// public Vertex(long x, int time, int value) {
	// this.father = null;
	// this.l = null;
	// this.r = null;
	// this.sz = 1;
	// this.y = random.nextLong();
	// this.x = x;
	// this.time = time;
	// this.mintime = time;
	// this.value = value;
	// }
	//
	// public void update() {
	// sz = 1;
	// mintime = time;
	// if (l != null) {
	// sz += l.sz;
	// mintime = Math.min(time, mintime);
	// }
	// if (r != null) {
	// sz += r.sz;
	// mintime = Math.min(time, mintime);
	// }
	// }
	// }
	//
	// public void add0(Vertex v, Vertex v1, Vertex father) {
	// if (v == null) {
	// v1.father = father;
	// father.r = v1;
	// father.update();
	// return;
	// }
	// if (v.y >= v1.y) {
	// add0(v.r, v1, v);
	// father.update();
	// return;
	// }
	// father.r = v1;
	// v1.father = father;
	// v.father = v1;
	// v1.l = v;
	// v1.update();
	// father.update();
	// }
	//
	// public Vertex pop(Vertex v, Vertex father, int h) {
	// if (v.l == null) {
	// if (h == 0) {
	// father.r = v.r;
	// } else {
	// father.l = v.r;
	// }
	// if (v.r != null) {
	// v.r.father = father;
	// v.r.update();
	// }
	// father.update();
	// v.father = null;
	// v.r = null;
	// v.update();
	// return v;
	// }
	// Vertex ans = pop(v.l, v, h + 1);
	// father.update();
	// return ans;
	// }
	//
	// public void cut(Vertex rl, Vertex rr, Vertex v, int mint) {
	//
	// }
	//
	// public int push(Vertex v, Vertex v1, Vertex father, boolean rson, int szl) {
	//
	// }
	//
	// Vertex root0;

	// public class State implements Comparable<State> {
	// int[] a;
	//
	// public State(int[] a) {
	// this.a = a;
	// }
	//
	// @Override
	// public int compareTo(State o) {
	// for (int i = 0; i < a.length; i++) {
	// if (a[i] != o.a[i]) {
	// return a[i] - o.a[i];
	// }
	// }
	// return 0;
	// }
	// }

	public long[][] mult(long[][] a, long[][] b) {
		int n = a.length;
		long[][] c = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
					c[i][j] %= mod;
				}
			}
		}
		return c;
	}

	public long[][] pow(long[][] x, long p) {
		if (p == 0) {
			long[][] e = new long[x.length][x.length];
			for (int i = 0; i < e.length; i++) {
				e[i][i] = 1;
			}
			return e;
		}
		long[][] ans = pow(x, p / 2);
		ans = mult(ans, ans);
		if (p % 2 == 1) {
			ans = mult(ans, x);
		}
		return ans;
	}


	long mod = 998244353;
	Random random = new Random(566);
	ArrayList<Integer>[] to;
	
	
	public void solve() {
		int nTest = in.nextInt();
		for (int test = 1; test <= nTest; test++) {
			int n = in.nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					a[i][j] = in.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0; i < a.length; i++) {
				trace += a[i][i];
			}
			int r = 0;
			for (int i = 0; i < a.length; i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					set.add(a[i][j]);
				}
				if (set.size() < n) {
					r++;
				}
			}
			int c = 0;
			for (int i = 0; i < a.length; i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					set.add(a[j][i]);
				}
				if (set.size() < n) {
					c++;
				}
			}
			out.println("Case #" + test + ": " + trace + " " + r + " " + c);
			
		}
	}

	public class Point implements Comparable<Point> {
		int x;
		int type;
		long cost;

		public Point(int x, int type, long cost) {
			this.x = x;
			this.type = type;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			if (x != o.x) {
				return x - o.x;
			}
			return type - o.type;
		}
	}

	public class Line {
		long k;
		long b;

		public Line(long k, long b) {
			this.k = k;
			this.b = b;
		}

		public Line(long x, long y, long k) {
			this(k, y - x * k);
		}

		public String toString() {
			return k + "x + " + b;
		}

		public long value(long x) {
			return k * x + b;
		}
	}

	public class LiChaoTree {
		boolean branchUp;
		long neutral;
		int pow;
		Line[] ch;

		public LiChaoTree(int n, boolean branchUp) {
			this.branchUp = branchUp;
			if (branchUp) {
				neutral = Long.MIN_VALUE / 2;
			} else {
				neutral = Long.MAX_VALUE / 2;
			}
			pow = 1;
			while (pow < n) {
				pow *= 2;
			}
			ch = new Line[2 * pow];
		}

		public boolean better(double a, double b) {
			return branchUp ^ a < b;
		}

		public long function(long a, long b) {
			return branchUp ^ a < b ? a : b;
		}

		private void add(int v, int l, int r, Line line) {
			if (ch[v] == null) {
				ch[v] = line;
				return;
			}
			if (v >= pow) {
				if (v % 2 == 0) {
					if (better(line.value(l), ch[v].value(l))) {
						ch[v] = line;
					}
				} else {
					if (better(line.value(r), ch[v].value(r))) {
						ch[v] = line;
					}
				}
				return;
			}
			int m = (l + r) / 2;
			if (better(line.value(m), ch[v].value(m))) {
				Line c = line;
				line = ch[v];
				ch[v] = c;
			}
			if (better(line.value(l), ch[v].value(l))) {
				add(2 * v, l, m, line);
			}
			if (better(line.value(r), ch[v].value(r))) {
				add(2 * v + 1, m, r, line);
			}
		}

		public void add(Line line) {
			add(1, 0, pow, line);
		}

		private long get(int v, int l, int r, int x) {
			if (ch[v] == null) {
				return neutral;
			}
			if (v >= pow) {
				return ch[v].value(x);
			}
			long ans = ch[v].value(x);
			int m = (l + r) / 2;
			if (x <= m) {
				ans = function(ans, get(2 * v, l, m, x));
			}
			if (x >= m) {
				ans = function(ans, get(2 * v + 1, m, r, x));
			}
			return ans;
		}

		public long get(int x) {
			return get(1, 0, pow, x);
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