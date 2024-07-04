import java.util.*;
import java.io.*;
import java.text.*;

class Solution {

	// solution credits : Ayush Kumar

	void solve(int TC) {
		printed=false;
		pn("Case #"+TC+":");
		dfs(0, 0, ni()-1, new HashSet<String>(), new ArrayList<String>());
	}
	static boolean printed;
	void dfs(int r, int c, int n, HashSet<String>v,ArrayList<String>path) {
		if(v.contains(r+" "+c))return;
		v.add(r+" " +c);
		if(n<0||path.size()>=500)return;
		if(n==0&&!printed) {
			printed=true;
			pn("1 1");
			for(String s:path)pn(s);
			return;
		}
		int[][]dir= {{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1}};
		for(int[]d:dir) {
			int rd=r+d[0],cd=c+d[1];
			if(rd>=0&&rd<a.length&&a[rd]!=null&&cd>=0&&cd<a[rd].length&&!v.contains(rd +" " + cd)) {
				path.add((rd+1) + " " + (cd+1));
				dfs(rd, cd, n-(int)a[rd][cd], v, path);
				path.remove(path.size()-1);
			}
		}
	}
	static long[][]a;
	void build() {
		a=new long[35][];
		long max=-1;
		for(int i=0;i<a.length;i++) {
			a[i]=new long[i+1];
			a[i][0]=a[i][a[i].length-1]=1L;
			for(int j=1;j<a[i].length-1;j++) {
				a[i][j]=a[i-1][j-1]+a[i-1][j];
				max=Math.max(max, a[i][j]);
			}
			if(max>(1e9+1))break;
		}
	}

	// solution ends
	void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
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
		build();
		for (int i = 1; i <= T; i++) {
			long ctl = System.currentTimeMillis();
			solve(i);
//			System.err.println("Time/TC : " + (System.currentTimeMillis() - ctl));
			p("");
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