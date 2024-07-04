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
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		for (int z = 1; z <= test; ++z) {
			int n = t.nextInt();
			Pair a[] = new Pair[n];
			int[][] mark = new int[2][n];
			boolean vis[] = new boolean[n];
			boolean flag = true;
			StringBuilder res = new StringBuilder();
			int C = 0, J = 0;

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				int y = t.nextInt();
				a[i] = new Pair(x, y, i);
//				mark[0][i] = x;
//				mark[1][i] = y;
			}

			Compare obj = new Compare();

			obj.compare(a, n);

			for (int i = 0; i < n; ++i) {
				if (a[i].x >= C) {
					C = a[i].y;
					a[i].ch = 'C';
				} else if (a[i].x >= J) {
					J = a[i].y;
					a[i].ch = 'J';
				} else {
					flag = false;
					res = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}

			if (flag) {
//				for (int i = 0; i < n; ++i) {
//					int x = mark[0][i];
//					int y = mark[1][i];
//
//					for (int j = 0; j < n; j++) {
//						if (a[j].x == x && a[j].y == y && !vis[j]) {
//							res.append(a[j].ch);
//							vis[j] = true;
//						}
//					}
//				}

				Compare1 ob = new Compare1();

				ob.compare(a, n);

				for (int i = 0; i < n; ++i) {
					res.append(a[i].ch);
				}

			}

			o.println("Case #" + z + ": " + res);
		}

		o.flush();
		o.close();
	}

}

class Pair {
	int x;
	int y;
	char ch;
	int idx;

	public Pair(int x, int y, int idx) {
		this.x = x;
		this.y = y;
		this.idx = idx;
	}
}

class Compare1 {

	static void compare(Pair arr[], int n) {
		// Comparator to sort the pair according to second element
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.idx - p2.idx;
			}
		});
	}
}

class Compare {

	static void compare(Pair arr[], int n) {
		// Comparator to sort the pair according to second element
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.x - p2.x;
			}
		});
	}
}