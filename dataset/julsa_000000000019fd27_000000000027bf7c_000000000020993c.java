import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.print("Case #" + qq + ": ");
			int n = in.nextInt();
			int[][] r = new int[n][n];
			int[][] c = new int[n][n];
			int sum = 0;
			int x = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					x = in.nextInt();
					if (i == j) {
						sum += x;
					}
					r[i][x - 1]++;
					c[j][x - 1]++;
				}
			}
			int rr = 0;
			int cc = 0;
			for (int i = 0; i < n; i++) {
				boolean rb = false;
				boolean cb = false;
				for (int j = 0; j < n; j++) {
					if (r[i][j] > 1) {
						rb = true;
					}
					if (c[i][j] > 1) {
						cb = true;
					}
				}
				if (rb) {
					rr++;
				}
				if (cb) {
					cc++;
				}
			}

			System.out.println(sum + " " + rr + " " + cc);

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