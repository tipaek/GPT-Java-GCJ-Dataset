import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.print("Case #" + qq + ": ");
			int n = in.nextInt();
			int[][] a = new int[n][3];
			for (int i = 0; i < n; i++) {
				a[i][0] = in.nextInt();
				a[i][1] = in.nextInt();
				a[i][2] = i;
			}
			Arrays.sort(a, new Comparator<int[]>() {

				@Override
				public int compare(int[] a0, int[] a1) {
					if (a0[0] - a1[0] > 0) {
						return 1;
					}
					if (a0[0] - a1[0] < 0) {
						return -1;
					}
					if (a0[1] - a1[1] > 0) {
						return 1;
					}
					if (a0[1] - a1[1] < 0) {
						return -1;
					}
					return 0;
				}
			});

			int c = 0;
			int j = 0;
			char[] ans = new char[n];
			boolean ok = true;
			for (int i = 0; i < n; i++) {
				if (a[i][0] >= c) {
					ans[a[i][2]] = 'C';
					c = a[i][1];
				} else {
					if (a[i][0] >= j) {
						ans[a[i][2]] = 'J';
						j = a[i][1];
					} else {
						ok = false;
						break;
					}
				}
			}
			if (ok) {
				StringBuilder s = new StringBuilder();
				for (int i = 0; i < n; i++) {
					s.append(ans[i]);
				}
				System.out.println(s);
			} else {
				System.out.println("IMPOSSIBLE");
			}

		}

	}

	public void run() throws IOException {
		in = new FastScanner();

		solve();

	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
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
	}

	public static void main(String[] arg) throws IOException {
		new Solution().run();
	}
}