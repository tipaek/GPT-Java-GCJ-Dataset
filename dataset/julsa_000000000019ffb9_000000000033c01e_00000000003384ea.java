import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.print("Case #" + qq + ": ");
			long l = in.nextInt();
			long r = in.nextInt();
			long k = (long) Math.abs(l - r);
			long d = (long) ((-1 + Math.sqrt(8 * k + 1)) / 2);
			if (r > l) {
				r -= (d * (d + 1)) / 2;
			} else {
				l -= (d * (d + 1)) / 2;
			}
			if (l == r) {
				if (l > d + 1) {
					d++;
					l -= d;
				}
			}
			d++;
			if (r > l) {
				long n1 = (long) ((-d + 1 + Math.sqrt((d - 1) * (d - 1) + 4 * r)) / 2);
				long n2 = (long) ((-d + Math.sqrt(d * d + 4 * l)) / 2);
				n1 = Math.min(n1, n2 + 1);
				n2 = Math.min(n1 + 1, n2);
				System.out.println((d - 1 + n1 + n2) + " " + (l - n2 * n2 - d * n2) + " " + (r - (d + n1 - 1) * n1));
			} else {
				long n1 = (long) ((-d + 1 + Math.sqrt((d - 1) * (d - 1) + 4 * l)) / 2);
				long n2 = (long) ((-d + Math.sqrt(d * d + 4 * r)) / 2);
				n1 = Math.min(n1, n2 + 1);
				n2 = Math.min(n1 + 1, n2);
				System.out.println((d - 1 + n1 + n2) + " " + (l - (d + n1 - 1) * n1) + " " + (r - n2 * n2 - d * n2));
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