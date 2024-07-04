import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.println("Case #" + qq + ": ");
			int n = in.nextInt();
			int k = 1;
			int p = 0;
			while (2 * k + p <= n) {
				k *= 2;
				p++;
			}
			boolean[] b = new boolean[p + 1];
			while (p >= 0) {
				if (k + p <= n) {
					b[p] = true;
					n -= k;
				} else {
					n--;
				}
				k /= 2;
				p--;
			}
			boolean s = true;
			for (int i = 0; i < b.length; i++) {
				if (b[i]) {
					if (s) {
						for (int j = 0; j <= i; j++) {
							System.out.println((i + 1) + " " + (j + 1));
						}
					} else {
						for (int j = i; j >= 0; j--) {
							System.out.println((i + 1) + " " + (j + 1));
						}
					}
					s = !s;
				} else {
					if (s) {
						System.out.println((i + 1) + " " + 1);
					} else {
						System.out.println((i + 1) + " " + (i + 1));
					}
				}
			}
			p = b.length + 1;
			while (n != 0) {
				if (s) {
					System.out.println(p + " " + 1);
				} else {
					System.out.println(p + " " + p);
				}
				p++;
				n--;
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