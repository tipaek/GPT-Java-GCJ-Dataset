import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.print("Case #" + qq + ": ");

			String s = in.next();
			int n = s.length();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.charAt(i) - '0';
			}
			StringBuilder ans = new StringBuilder();
			int x = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] < x) {
					for (int j = 0; j < x - a[i]; j++) {
						ans.append(')');
					}
				} else {
					for (int j = 0; j < a[i] - x; j++) {
						ans.append('(');
					}
				}
				x = a[i];
				ans.append(a[i]);
			}
			for (int j = 0; j < x; j++) {
				ans.append(')');
			}
			System.out.println(ans);

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