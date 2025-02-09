
import java.util.*;
import java.io.*;

public class Solution {

	static final boolean stdin = true;
	static final String filename = "";
	static FastScanner br;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {

		if (stdin) {
			br = new FastScanner();
			pw = new PrintWriter(new OutputStreamWriter(System.out));
		} else {
			br = new FastScanner(filename + ".in");
			pw = new PrintWriter(new FileWriter(filename + ".out"));
		}

		Solver solver = new Solver();
		solver.solve(br, pw);
		pw.close();
	}

	static class Solver {
		static long mod = (long) (1e9);

		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			int q = br.ni();
			int qq = q;
			while (q-- > 0) {
				int n = br.ni();
				Point[] in = new Point[n];
				char[] outout = new char[n];
				for (int i = 0; i < n; i++) {
					in[i] = new Point(br.ni(), br.ni(), i);
				}
				Arrays.parallelSort(in);
				String out = "";
				int lastC = 0, lastJ = 0;
				for (int i = 0; i < n; i++) {
					if (in[i].a < lastC) {
						if (in[i].a < lastJ) {
							out = "IMPOSSIBLE";
							break;
						} else {
							outout[in[i].c] = 'J';
							lastJ = in[i].b;
						}
					} else {
						outout[in[i].c] = 'C';
						lastC = in[i].b;
					}
				}
				if(out.equals("IMPOSSIBLE")) {
					System.out.println("Case #" + (qq-q) + ": " + out);
				}else {
					out = String.valueOf(outout, 0, n);
					System.out.println("Case #" + (qq-q) + ": " + out);
				}
			}
		}

		static long gcd(long a, long b) {
			if (a > b)
				return gcd(b, a);
			if (a == 0)
				return b;
			return gcd(b % a, a);
		}

		static long lcm(long a, long b) {
			return a * (b / gcd(a, b));
		}

		static long pow(long a, long b) {
			if (b == 0)
				return 1L;
			long val = pow(a, b / 2);
			if (b % 2 == 0)
				return val * val % mod;
			else
				return val * val % mod * a % mod;
		}

	}

	static class Point implements Comparable<Point> {
		int a;
		int b;
		int c;

		Point(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			if (this.a == o.a)
				return this.b - o.b;
			return this.a - o.a;
		}

	}

	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		ArrayList<Integer>[] ng(int n, int e) {
			ArrayList<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < e; i++) {
				int a = ni() - 1;
				int b = ni() - 1;
				adj[a].add(b);
				adj[b].add(a);
			}
			return adj;
		}

		Integer[] nIa(int n) {
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		int[] nia(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = ni();
			}
			return arr;
		}

		Long[] nLa(int n) {
			Long[] arr = new Long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
		}

		long[] nla(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nl();
			}
			return arr;
		}

		String[] nsa(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nt();
			}
			return arr;
		}

		String nt() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int ni() {
			return Integer.parseInt(nt());
		}

		long nl() {
			return Long.parseLong(nt());
		}

		double nd() {
			return Double.parseDouble(nt());
		}

	}
}