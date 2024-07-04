import java.util.*;
import java.io.*;

public class Solution {
	static int memo[][];
	static int n, k, d, e, t;
	static ArrayList[] edgeList;
	static int[][] matrix;
	static int[][] a;
	final static int Infinity = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		t = sc.nextInt();
		int caseNo = 1;
		boolean possible = false;

		while (t-- > 0) {
			pw.print("Case #" + caseNo++);
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n][n];
			d = k / n;
			int rem = k % n;
			if (rem > 0 || d > n) {
				pw.println(": IMPOSSIBLE");
				continue;
			} else
				pw.println(": POSSIBLE");
			a = matrix();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					pw.print(a[i][j] + " ");
				pw.println();
			}
		}

		pw.flush();
		pw.close();
	}

	public static int[][] matrix() {
		int[][] a = new int[n][n];
		int idx = 1;
		int[] repeat = new int[n];
		repeat[0] = d;
		for (int i = 1; i < n; i++) {
			if(i==d)
				repeat[i] = ++idx ;
			else
				repeat[i] = idx;
			idx++;
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j]= repeat[(i-j+n)%n];
		return a;
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

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}