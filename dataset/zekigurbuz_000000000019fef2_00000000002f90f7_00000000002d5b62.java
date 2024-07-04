import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import java.lang.Math.*;

public class Solution {

	public static FastIO file = new FastIO();

	public static int ntc, ctc;
	public static final long MOD = 1000000007L; //998244353L;
	public static final int N = 200005, dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };
	public static final String dir[] = {"N", "E", "S", "W"};

	public void run() throws Exception {
		ntc = nextInt();
		for (ctc = 1; ctc <= ntc; ++ctc) {
			printf("Case #%d: ", ctc);
			solve();
		}
		file.out.flush();
		file.out.close();
	}
	
	public static long x, y;
	
	public static boolean isTwoPower(long x) {
		x = Math.abs(x);
		return (x & (x - 1)) == 0;
	}
	
	public static long dist(long x1, long y1, long x2, long y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static class State implements Comparable<State> {
		long xC, yC, tp;
		String movs;
		public State(long xC, long yC, String movs, long tp) {
			this.xC = xC;
			this.yC = yC;
			this.movs = movs;
			this.tp = tp;
		}
		public int compareTo(State o) {
			return Long.compare(dist(x,y,xC,yC), dist(x,y,o.xC,o.yC));
		}
	}

	public static void solve() {
		x = nextLong();
		y = nextLong();
		if (isTwoPower(x+y) && x+y != 1 && x+y != -1) {
			println("IMPOSSIBLE");
			return;
		}
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(0, 0, "", 1L));
		while (!pq.isEmpty()) {
			State cur = pq.poll();
			//println(dist(x,y,cur.xC,cur.yC));
			if (x == cur.xC && y == cur.yC) {
				println(cur.movs);
				return;
			}
			if (cur.tp > 1e9) continue;
			for (int i = 0; i < 4; i++) {
				pq.add(new State(cur.xC + dx[i] * cur.tp, cur.yC + dy[i] * cur.tp, cur.movs + dir[i], cur.tp * 2L));
			}
		}
		println("IMPOSSIBLE");
	}

	public static long mod(long n, long mod) {
		return (n % mod + mod) % mod;
	}

	public static long pow(long n, long p, long mod) {
		long ret = 1L;
		while (p > 0) {
			if (p % 2 != 0L)
				ret = mod(ret * n, mod);
			n = mod(n * n, mod);
			p >>= 1L;
		}
		return ret;
	}

	public static long pow(long n, long p) {
		long ret = 1L;
		while (p > 0) {
			if (p % 2 != 0L)
				ret *= n;
			n *= n;
			p >>= 1L;
		}
		return ret;
	}

	public static long gcd(long x, long y) {
		while (x != 0) {
			long tmp = x;
			x = y % x;
			y = tmp;
		}
		return y;
	}

	public static long lcm(long x, long y) {
		return x / gcd(x, y) * y;
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}

	public static class Pair<A, B> implements Comparable {
		public A fi;
		public B se;

		public Pair(A fi, B se) {
			this.fi = fi;
			this.se = se;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Pair<?, ?> p = (Pair<?, ?>) o;
			if (!fi.equals(p.fi))
				return false;
			return se.equals(p.se);
		}

		@Override
		public int hashCode() {
			return 31 * fi.hashCode() + se.hashCode();
		}

		@Override
		public String toString() {
			return fi.toString() + " " + se.toString();
		}

		public static <A, B> Pair<A, B> of(A a, B b) {
			return new Pair<A, B>(a, b);
		}

		public int compareTo(Object o) {
			Pair<?, ?> p = (Pair<?, ?>) o;
			if (fi.equals(p.fi))
				return ((Comparable) se).compareTo(p.se);
			return ((Comparable) fi).compareTo(p.fi);
		}
	}

	public static String next() {
		return file.next();
	}

	public static int nextInt() {
		return file.nextInt();
	}

	public static long nextLong() {
		return file.nextLong();
	}

	public static double nextDouble() {
		return file.nextDouble();
	}

	public static String nextLine() {
		return file.nextLine();
	}

	public static void print(Object o) {
		file.out.print(o);
	}

	public static void println(Object o) {
		file.out.println(o);
	}

	public static void printf(String s, Object... o) {
		file.out.printf(s, o);
	}

	public static class FastIO {
		BufferedReader br;
		StringTokenizer st;
		PrintWriter out;

		public FastIO() {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		void print(Object o) {
			out.print(o);
		}

		void println(Object o) {
			out.println(o);
		}

		void printf(String s, Object... o) {
			out.printf(s, o);
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
}
