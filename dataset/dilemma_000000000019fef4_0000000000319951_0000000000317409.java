import java.util.*;
import java.util.Map.Entry;

import java.math.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// InputReader in = new InputReader(System.in);
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		// InputReader in = new InputReader(new
		// File("ethan_traverses_a_tree.txt"));
		// PrintWriter out = new PrintWriter(new
		// File("ethan_traverses_a_tree-output.txt"));

		int pi = in.nextInt();
		for (int qi = 1; qi <= pi; qi++) {
			int x = in.nextInt();
			int y = in.nextInt();

			String s = in.next();
			char[] a = s.toCharArray();

			if (x + y == 0) {
				out.printf("Case #%d: 0\n", qi);
			} else {
				int ans = -1;
				for (int i = 0; i < a.length; i++) {
					char ch = a[i];

					if (ch == 'N') {
						y++;
					} else if (ch == 'S') {
						y--;
					} else if (ch == 'W') {
						x--;
					} else {
						x++;
					}

					if (Math.abs(x) + Math.abs(y) <= i + 1) {
						ans = i + 1;
						break;
					}
				}

				if (ans == -1) {
					out.printf("Case #%d: IMPOSSIBLE\n", qi);
				} else {
					out.printf("Case #%d: %d\n", qi, ans);
				}
			}
		}

		out.close();
	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}