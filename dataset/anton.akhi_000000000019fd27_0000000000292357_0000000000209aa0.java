import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	private void solve() {
		int testn = nextInt();
		tests: for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			int k = nextInt();
			if (k == n + 1) {
				out.println("IMPOSSIBLE");
				continue tests;
			}
			a = new int[n][n];
			HashSet<Integer>[] rows = new HashSet[a.length];
			HashSet<Integer>[] columns = new HashSet[a.length];
			for (int i = 0; i < columns.length; i++) {
				rows[i] = new HashSet<>();
				columns[i] = new HashSet<>();
			}
			for (int i = 0; i < a.length; i++) {
				int x = Math.min(n, k - (n - i - 1));
				if (i == 0 && k > n) {
					x = 2;
				}
				k -= x;
				a[i][i] = x;
				rows[i].add(x);
				columns[i].add(x);
			}
			int[][] ans = dfs(rows, columns, 0, 0);
			if (ans == null) {
				out.println("IMPOSSIBLE");
				continue tests;
			}
			out.println("POSSIBLE");
			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					out.print(a[i][j] + " ");
				}
				out.println();
			}
		}
	}

	int[][] a;

	private int[][] dfs(HashSet<Integer>[] rows, HashSet<Integer>[] columns, int i, int j) {
		if (i >= a.length) {
			return a;
		}
		if (j >= a[i].length) {
			return dfs(rows, columns, i + 1, 0);
		}
		if (a[i][j] > 0) {
			return dfs(rows, columns, i, j + 1);
		}
		for (int x = 1; x <= a.length; x++) {
			if (rows[i].contains(x) || columns[j].contains(x)) {
				continue;
			}
			a[i][j] = x;
			rows[i].add(x);
			columns[j].add(x);
			int[][] ans = dfs(rows, columns, i, j + 1);
			if (ans != null) {
				return ans;
			}
			rows[i].remove(x);
			columns[j].remove(x);
			a[i][j] = 0;
		}
		return null;
	}
}
