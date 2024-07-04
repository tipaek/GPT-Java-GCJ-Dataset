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
			String s[] = new String[n];
			StringBuilder ans = new StringBuilder();
			boolean flag = true;

			for (int i = 0; i < n; ++i)
				s[i] = t.next();

			for (int i = 0; i < n; ++i) {
				StringBuilder temp = new StringBuilder();

				if (i == 0)
					ans = new StringBuilder(s[0].substring(1));
				else {
					int idx = ans.length() - 1;
					int j;

					for (j = s[i].length() - 1; j > 0 && idx >= 0; --j) {
						char ch1 = s[i].charAt(j);
						char ch2 = ans.charAt(idx--);

						if (ch1 == ch2) {

						} else {
							flag = false;
							break;
						}
					}

					if (!flag)
						break;

					if (idx < 0) {
						for (int k = 1; k <= j; ++k) {
							temp.append(s[i].charAt(k));
						}

						ans = new StringBuilder(temp.append(ans));
					} else {
					}
				}
			}

			if (flag)
				o.println("Case #" + z + ": " + ans);
			else
				o.println("Case #" + z + ": " + "*");

		}

		o.flush();
		o.close();
	}
}
