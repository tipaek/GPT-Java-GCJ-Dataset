import java.util.*;
import java.io.*;

public class Solution {
	static int memo[][];
	static int n, v, m, e, t;
	static ArrayList[] edgeList;
	static int[][] matrix;
	static int[] a;
	final static int Infinity = Integer.MAX_VALUE;
	static int[] ro = { -1, -1, 0, 0, 1, 1 };
	static int[] co = { -1, 0, -1, 1, 0, 1 };

	static int value(int i, int j) {
		if (j == 1 || j == i)
			return 1;
		return value(i - 1, j - 1) + value(i - 1, j);
	}

	static String pascal(int i, int j, int sum, String s, boolean[] visited) {
		if (visited[i + j])
			return "";
		
		if (i <= 0 || j <= 0 || j > i || sum > n)
			return "";
		
		visited[i + j] = true;
		
		boolean[] a = new boolean[visited.length];

		for (int idx = 0; idx < visited.length; idx++)
			a[idx] = visited[idx];

		if (sum == n)
			return s;


		if (i != 1 || j != 1)
			s += "\n";
		s += i + " " + j;

		sum+=value(i,j);

		String[] x = new String[6];
		for (int k = 1; k < 5; k++) {
			x[k] = pascal(i + ro[k], j + co[k], sum, s, visited);
			if (x[k].length() > 0) {
				return x[k];
			}
		}
		x[5] = pascal(i + ro[5], j + co[5], sum, s, visited);
		x[0] = pascal(i + ro[0], j + co[0], sum, s, visited);
		if (x[5].length() > 0)
			return x[5];
		if (x[0].length() > 0)
			return x[0];

		return "";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			n = sc.nextInt();
			String ans = pascal(1, 1, 0, "", new boolean[1000]);
			pw.printf("Case #%d:\n%s\n", caseNo++, ans);
		}
		pw.flush();
		pw.close();
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