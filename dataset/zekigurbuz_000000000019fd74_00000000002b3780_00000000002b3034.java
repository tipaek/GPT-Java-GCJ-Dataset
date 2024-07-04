import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import java.lang.Math.*;

public class A {

	public static FastIO file = new FastIO();

	public static int ntc, ctc;
	public static final long MOD = 1000000007L; //998244353L;
	public static final int N = 200005, dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };

	public void run() throws Exception {
		ntc = nextInt();
		for (ctc = 1; ctc <= ntc; ++ctc) {
			printf("Case #%d: ", ctc);
			solve();
		}
		file.out.flush();
		file.out.close();
	}
	
	public static class Word implements Comparable<Word> {
		String s;
		public Word(String s) {
			this.s = s;
		}
		public int compareTo(Word o) {
			return Integer.compare(o.s.length(), s.length());
		}
	}

	public static void solve() {
		int n = nextInt();
		ArrayList<Word> a = new ArrayList<>(n);
		for (int i = 0; i < n; i++) a.add(new Word(next().substring(1)));
		Collections.sort(a);
		boolean works = true;
		for (int i = 1; i < n; i++) works &= a.get(0).s.endsWith(a.get(i).s);
		if (works) println(a.get(0).s);
		else println("*");
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
		new A().run();
	}
}
