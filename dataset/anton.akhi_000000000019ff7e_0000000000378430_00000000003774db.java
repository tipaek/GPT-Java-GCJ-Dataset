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
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			solve();
		}
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

	class Distance implements Comparable<Distance> {
		int d1;
		int d2;
		Distance prev;
		String print;

		public Distance(int i, int j, Distance d, String string) {
			d1 = i;
			d2 = j;
			prev = d;
			print = string;
		}

		@Override
		public int compareTo(Distance o) {
			if (d1 + d2 == o.d1 + o.d2) {
				return Math.abs(d1 - d2) - Math.abs(o.d1 - o.d2);
			}
			return d1 + d2 - o.d1 - o.d2;
		}

		@Override
		public String toString() {
			return d1 + " " + d2;
		}

		@Override
		public int hashCode() {
			return d1 * 997 + d2;
		}

		@Override
		public boolean equals(Object o) {
			return (o instanceof Distance) && this.compareTo((Distance) o) == 0;
		}
	}

	HashSet<Distance>[][] a;
	int[][] best;

	private void solve() {
		char[] s = nextToken().toCharArray();
		char[] t = nextToken().toCharArray();
		a = new HashSet[s.length + 1][t.length + 1];
		best = new int[s.length + 1][t.length + 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new HashSet<>();
				best[i][j] = s.length + t.length + 1;
			}
		}
		a[0][0].add(new Distance(0, 0, null, null));
		best[0][0] = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (Distance d : a[i][j]) {
					if (i < s.length && j < t.length && s[i] == t[j]) {
						relax(i + 1, j + 1, d.d1, d.d2, d, s[i] + "");

					}
					if (i < s.length && j < t.length) {
						relax(i + 1, j + 1, d.d1 + 1, d.d2 + 1, d, "");
						relax(i + 1, j + 1, d.d1, d.d2 + 1, d, s[i] + "");
						relax(i + 1, j + 1, d.d1 + 1, d.d2, d, t[j] + "");
					}
					if (i < s.length) {
						relax(i + 1, j, d.d1 + 1, d.d2, d, "");
						relax(i + 1, j, d.d1, d.d2 + 1, d, s[i] + "");
					}
					if (j < t.length) {
						relax(i, j + 1, d.d1 + 1, d.d2, d, t[j] + "");
						relax(i, j + 1, d.d1, d.d2 + 1, d, "");
					}
				}
			}
		}
		int diff = s.length + t.length + 1;
		Distance dist = null;
		for (Distance d : a[s.length][t.length]) {
			if (Math.abs(d.d1 - d.d2) < diff) {
				diff = Math.abs(d.d1 - d.d2);
				dist = d;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (dist.print != null) {
			sb.append(dist.print);
			dist = dist.prev;
		}
		out.println(sb.reverse().toString());
	}

	private void relax(int i, int j, int d1, int d2, Distance d, String string) {
		if (best[i][j] > d1 + d2) {
			best[i][j] = d1 + d2;
			a[i][j].clear();
		}
		if (best[i][j] == d1 + d2) {
			a[i][j].add(new Distance(d1, d2, d, string));
		}
	}
}
