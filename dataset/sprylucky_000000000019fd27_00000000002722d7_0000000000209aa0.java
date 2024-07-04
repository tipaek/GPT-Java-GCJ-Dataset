import java.util.*;
import java.io.*;

public class Solution {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
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

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		int test = t.nextInt();

		for (z = 1; z <= test; ++z) {
			n = t.nextInt();
			k = t.nextInt();
			a = new int[60][60];
			rs = new boolean[60][60];
			cs = new boolean[60][60];

			fun(1, 1, 0);

			if (!done) {
				System.out.println("Case #" + z + ": " + "IMPOSSIBLE");
			}

			done = false;
		}
	}

	private static boolean done;
	private static int[][] a;
	private static int n, k, z;
	private static boolean rs[][], cs[][];

	private static void fun(int r, int c, int id) {
		if (id == k && !done && r == n && c == n + 1) {
			done = true;

			System.out.println("Case #" + z + ": " + "POSSIBLE");

			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					System.out.print(a[i][j] + " ");
				}

				System.out.println();
			}

			return;
		} else if (r > n)
			return;
		else if (c > n)
			fun(r + 1, 1, id);

		for (int i = 1; i <= n && !done; ++i) {
			if (!rs[r][i] && !cs[c][i]) {
				rs[r][i] = cs[c][i] = true;

				if (r == c) {
					id += i;
				}

				a[r][c] = i;

				fun(r, c + 1, id);

				rs[r][i] = cs[c][i] = false;

				if (r == c) {
					id -= i;
				}

				a[r][c] = 0;
			}
		}

	}
}