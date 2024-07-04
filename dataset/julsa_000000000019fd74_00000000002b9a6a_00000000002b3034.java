import java.util.*;
import java.io.*;

public class Solution {
	FastScanner in;

	public void solve() throws IOException {
		int q = in.nextInt();
		for (int qq = 1; qq <= q; qq++) {
			System.out.print("Case #" + qq + ": ");
			int n = in.nextInt();
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = in.next();
			}
			int[] l = new int[n];
			char[] h = new char[10000];
			int hh = 0;
			boolean b = true;
			boolean ok = true;
			while (b & ok) {
				b = false;
				for (int i = 0; i < n; i++) {
					if (s[i].charAt(l[i]) != '*') {
						if (!b) {
							h[hh] = s[i].charAt(l[i]);
						}
						if (s[i].charAt(l[i]) != h[hh]) {
							ok = false;
							break;
						}
						l[i]++;
						b = true;
					}
				}
				if (b) {
					hh++;
				}
			}
			if (!ok) {
				System.out.println("*");
				continue;
			}
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				r[i] = s[i].length() - 1;
			}
			char[] t = new char[10000];
			int tt = 0;
			b = true;
			ok = true;
			while (b & ok) {
				b = false;
				for (int i = 0; i < n; i++) {
					if (s[i].charAt(r[i]) != '*') {
						if (!b) {
							t[tt] = s[i].charAt(r[i]);
						}
						if (s[i].charAt(r[i]) != t[tt]) {
							ok = false;
							break;
						}
						r[i]--;
						b = true;
					}
				}
				if (b) {
					tt++;
				}
			}
			if (!ok) {
				System.out.println("*");
				continue;
			}
			StringBuilder st = new StringBuilder();
			st.append(h,0, hh);
			for (int i = 0; i < n; i++) {
				for (int j = l[i]; j < r[i]; j++) {
					if (s[i].charAt(j)!='*') {
						st.append(s[i].charAt(j));
					}
				}
			}
			for ( int i = tt - 1; i >= 0; i--) {
				st.append(t[i]);
			}
			

			System.out.println(st);

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