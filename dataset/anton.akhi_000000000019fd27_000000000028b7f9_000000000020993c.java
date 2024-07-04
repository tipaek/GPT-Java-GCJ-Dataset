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
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					a[i][j] = nextInt();
				}
			}
			long spur = 0;
			int badRows = 0;
			int badColumns = 0;
			for (int i = 0; i < a.length; i++) {
				spur += a[i][i];
			}
			for (int i = 0; i < a.length; i++) {
				HashSet<Integer> hs = new HashSet<>();
				for (int j = 0; j < a[i].length; j++) {
					if (hs.contains(a[i][j])) {
						badRows++;
						break;
					}
					hs.add(a[i][j]);
				}
			}
			for (int j = 0; j < a[0].length; j++) {
				HashSet<Integer> hs = new HashSet<>();
				for (int i = 0; i < a.length; i++) {
					if (hs.contains(a[i][j])) {
						badColumns++;
						break;
					}
					hs.add(a[i][j]);
				}
			}
			out.println(spur + " " + badRows + " " + badColumns);
		}
	}
}
