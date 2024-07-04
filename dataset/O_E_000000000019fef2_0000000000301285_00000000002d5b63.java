import java.util.*;
import java.io.*;

public class Solution {
	static PrintWriter out;
	static StringBuilder sb;
	static int mod = 998244353;
	static int inf = (int) 1e15;
	static ArrayList<Integer>[] ad;
	static int n;
	static int[][][] memo;
	static int[] a;
	static String s;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int r = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			all: for (int x = -6; x < 7; x++) {
				for (int y = -6; y < 7; y++) {
					System.out.println(x + " " + y);
					String xp = sc.nextLine();
					if (xp.equals("CENTER"))
						break all;
				}
			}
		}
		out.close();
	}

	static class pair implements Comparable<pair> {
		int st;
		int ed;
		int c;

		public pair(int s, int d, int cc) {
			st = s;
			ed = d;
			c = cc;
		}

		public String toString() {
			return st + " " + ed + " " + c;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if (st == o.st)
				return o.ed - ed;
			return st - o.st;
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
