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
			String s = t.next();
			StringBuilder a = new StringBuilder();
			int cur = 0;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				int n = ch - 48;
				int now = n - cur;

				if (now < 0) {
					while (now++ < 0) {
						a.append(')');
						cur--;
					}
				} else {
					while (now-- > 0) {
						a.append('(');
						cur++;
					}
				}

				a.append(ch);

			}

			while (cur-- > 0)
				a.append(')');

			o.println("Case #" + z + ": " + a);
		}

		o.flush();
		o.close();
	}
}