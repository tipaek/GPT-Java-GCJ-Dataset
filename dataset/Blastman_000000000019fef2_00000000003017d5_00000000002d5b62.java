
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
		int T = br.ni();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ": ");
			solver.solve(br, pw);
		}
		pw.close();
	}

	static class Solver {
		static long mod = (long) (1e20) + 7;

		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			long x = br.nl();
			long y = br.nl();
			int[] good = null;
			if(Math.abs(x) != Math.abs(y)) {
				for (int i = 0; i < 8; i++) {
					int[] a = dfs(x, y, true, i);
					if(a != null) {
						good = a;
						break;
					}else {
						int[] b = dfs(x, y, false, i);
						if(b!= null) {
							good = b;
							break;
						}					
					}
				}
			}			
			if(good == null) {
				System.out.println("IMPOSSIBLE");
			}else {
				for(int i : good) {
					if(i == 1) {
						System.out.print("S");
					}else if(i == 2) {
						System.out.print("N");
					}else if(i == 3) {
						System.out.print("W");
					}else if(i == 4) {
						System.out.print("E");
					}
				}
				System.out.println();
			}
			//System.out.println(Arrays.toString(good));
		}
/*
1
100 100
 */
		static int[] dfs(long x, long y, boolean vert, int jump) {
			int[] out = new int[jump + 1];
			if (vert) {
				if (y < 0) {
					y = y + pow(2, jump);
					out[jump] = 1;
				} else if (y > 0) {
					y = y - pow(2, jump);
					out[jump] = 2;
				} else {
					return null;
				}
			} else {
				if (x < 0) {
					x = x + pow(2, jump);
					out[jump] = 3;
				} else if (x > 0) {
					x = x - pow(2, jump);
					out[jump] = 4;
				} else {
					return null;
				}
			}
			if (jump == 0) {
				if (x == 0 && y == 0) {
					return out;
				} else {
					return null;
				}
			} else {
				jump--;
				int[] a = dfs(x, y, true, jump);
				if (a != null) {
					for(int i = 0; i <= jump; i++) {
						out[i] = a[i];
					}
				}else {
					int[] b = dfs(x, y, false, jump);
					if(b != null) {
						for(int i = 0; i <= jump; i++) {
							out[i] = b[i];
						}
					}else {
						out = null;
					}
				}
				return out;
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
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}

		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point other = (Point) obj;
				return x == other.x && x == other.x;
			}
			return false;
		}

		public int hashCode() {
			return 65536 * x + y + 4733 * 0;
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