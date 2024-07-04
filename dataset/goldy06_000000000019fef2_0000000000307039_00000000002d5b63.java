import java.util.*;
import java.io.*;
import java.text.*;

class Solution {

	// solution credits : Ayush Kumar

	void solve(int TC, int A, int B) {
		int m = (int)(1e9);
		for(int x=-10;x<=10;x++) {
			for(int y=-10;y<=10;y++) {
				System.out.println((x)+" "+(y));
				String inp = nln();
				if(inp.equals("CENTER")||inp.equals("HIT")||inp.equals("MISS")||inp.equals("WRONG"))return;
			}
		}
	}
	
	// solution ends
	void hold(boolean b) throws Exception {
		if (!b)
			throw new Exception("Hold right there, Sparky!");
	}

	void exit(boolean b) {
		if (!b)
			System.exit(0);
	}

	long mod = (long) 1e9 + 7, IINF = (long) 1e17, SZ = (long) 1e5;
	final int MAX = (int) 1e6 + 1, INF = (int) 2e9, root = 3;
	DecimalFormat df = new DecimalFormat("0.000000000000");
	double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
	static boolean multipleTC = true, memory = false;
	FastReader in;
	PrintWriter out;

	void run() throws Exception {
		long ct = System.currentTimeMillis();
		in = new FastReader();
		out = new PrintWriter(System.out);
		int T = (multipleTC) ? ni() : 1;
		int A=ni(),B=ni();
		for (int i = 1; i <= T; i++) {
			long ctl = System.currentTimeMillis();
			solve(i, A, B);
//			System.err.println("Time/TC : " + (System.currentTimeMillis() - ctl));
// 			p("");
		}
		out.flush();
		out.close();
//		System.err.println(System.currentTimeMillis() - ct);
	}

	public static void main(String[] args) throws Exception {
		if (memory)
			new Thread(null, new Runnable() {
				public void run() {
					try {
						new Solution().run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "1", 1 << 28).start();
		else
			new Solution().run();
	}

	long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	int lcm(int[] a) {
		int rv = a[0];
		for (int i = 1; i < a.length; i++) {
			rv = (rv * a[i]) / gcd(rv, a[i]);
		}
		return rv;
	}

	int bit(long n) {
		return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
	}

	void p(Object o) {
		out.print(o);
	}

	void pn(Object o) {
		out.println(o);
	}

	void pni(Object o) {
		out.println(o);
		out.flush();
	}

	String n() {
		return in.next();
	}

	String nln() {
		return in.nextLine();
	}

	int ni() {
		return Integer.parseInt(in.next());
	}

	long nl() {
		return Long.parseLong(in.next());
	}

	double nd() {
		return Double.parseDouble(in.next());
	}

	public long powMOD(long x, long n) {
		if (n == 0 || n == 1)
			return n == 0 ? 1 : x;
		long res = powMOD(x, n / 2);
		return n % 2 == 0 ? mul2(res, res) : mul3(x, res, res);
	}

	public long pow(int x, int n) {
		if (n == 0 || n == 1)
			return n == 0 ? 1 : x;
		long res = powMOD(x, n / 2);
		return n % 2 == 0 ? res * res : x * res * res;
	}

	public long add(long a, long b) {
		return ((a % mod) + (b % mod)) % mod;
	}

	public long mul2(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
	}

	public long mul3(long a, long b, long c) {
		long i = 1;
		i = mul2(a, i);
		i = mul2(b, i);
		i = mul2(c, i);
		return i;
	}

	<T> void par(T[] a) {
		for (T val : a)
			p(val + " ");
	}

	<T> void pmat(T[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				p(a[i][j] + " ");
			}
			pn("");
		}
	}

	void narr(int[] a) {
		for (int i = 0; i < a.length; i++)
			a[i] = ni();
	}

	long arrSum(int[] a) {
		long rv = 0;
		for (int val : a)
			rv += val;
		return rv;
	}

	int[] ps(int[] a) {
		int[] ps = new int[a.length];
		ps[0] = a[0];
		for (int i = 1; i < a.length; i++)
			ps[i] = ps[i - 1] + a[i];
		return ps;
	}

	int[] toArr(ArrayList<Integer> al) {
		int[] rv = new int[al.size()];
		for (int i = 0; i < rv.length; i++)
			rv[i] = al.get(i);
		return rv;
	}

	ArrayList<Integer> toAl(int[] a) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int val : a)
			al.add(val);
		return al;
	}

	void swap(int i, int j, int[] a) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}

	long findSqrt(long x) {
		long l = 0, h = x / 2, ans = -1;
		while (l <= h) {
			long m = l + ((h - l) / 2);
			if (m * m <= x) {
				ans = m;
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return ans;
	}

	class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}