import java.util.*;
import java.io.*;

public class Solution {
	static PrintWriter out;
	static StringBuilder sb;
	static int mod = 998244353;
	static int inf = (int) 1e15;
	static ArrayList<Integer>[] ad;
	static int n, s;
	static int[][][] memo;
	static int[] a;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int v = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			int sum = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					if (i == j)
						sum += a[i][j];
				}
			int r = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				HashSet<Integer> h = new HashSet<>();
				for (int j = 0; j < n; j++)
					if (h.contains(a[i][j])) {
						r++;
						break;
					} else
						h.add(a[i][j]);
			}
			for (int i = 0; i < n; i++) {
				HashSet<Integer> h = new HashSet<>();
				for (int j = 0; j < n; j++)
					if (h.contains(a[j][i])) {
						c++;
						break;
					} else
						h.add(a[j][i]);
			}
			out.println("Case #"+v+": "+sum+" "+r+" "+c);
			v++;
		}
		out.close();
	}

	static class pair {
		int id;
		int v;

		public pair(int i, int vi) {
			id = i;
			v = vi;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextArrInt(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextArrLong(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
