import java.util.*;
import java.io.*;
import java.text.*;

class Solution {

	// solution credits : Ayush Kumar

	class pair implements Comparable<pair>{
		int si,ei,i;
		pair(int i, int si, int ei) {
			this.si=si;
			this.ei=ei;
			this.i=i;
		}
		public int compareTo(pair o) {
			return this.si==o.si?this.ei-o.ei:this.si-o.si;
		}
		public String toString() {
			return this.si + " " + this.ei+ "("+this.i+")";
		}
	}
	void solve(int TC) {
		int n=ni();
		pair[]p=new pair[n];
		for(int i=0;i<n;i++)p[i]=new pair(i,ni(),ni());
		Arrays.sort(p);
//		if(im(p)) {
//			pn("Case #"+TC+": IMPOSSIBLE");
//			return;
//		}
		ArrayList<pair>ca=new ArrayList<>(),ja=new ArrayList<>();
		char[]ans=new char[n];
		char prev='C';
		ans[p[0].i]=prev;
		ca.add(p[0]);
		for(int i=1;i<n;i++) {
			if(p[i-1].ei>p[i].si) {
				prev=prev=='C'?'J':'C';
			}
			ans[p[i].i]=prev;
			
			pair last = prev=='C'?ca.get(ca.size()-1):ja.size()==0?null:ja.get(ja.size()-1);
			if(last!=null&&last.ei>p[i].si) {
				pn("Case #"+TC+": IMPOSSIBLE");
				return;
			}
			if(prev=='C')ca.add(p[i]);else ja.add(p[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : ans)sb.append(ch);
		pn("Case #"+TC+": " + sb);
	}
	
	/*1
5
1 100
2 5
99 150
100 301
150 250
*/
	
	public static boolean im(pair[]p) {
		for(int i=2;i<p.length;i++)
			if(p[i].si<p[i-1].ei&&p[i].si<p[i-2].ei)
				return true;
		return false;
	}
	
	// solution ends
	long mod = (long) 1e9 + 7, IINF = (long) 1e17, SZ = (long) 1e5;
	final int MAX = (int) 1e6 + 1, INF = (int) 2e9, root = 3;
	DecimalFormat df = new DecimalFormat("0.000000000000");
	double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
	static boolean multipleTC = true, memory = false;
	FastReader in;
	PrintWriter out;

	void run() throws Exception {
		in = new FastReader();
		out = new PrintWriter(System.out);
		int T = (multipleTC) ? ni() : 1;
		for (int i = 1; i <= T; i++) {
			solve(i);
			pn("");
		}
		out.flush();
		out.close();
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

	void pmat(int[][] a) {
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