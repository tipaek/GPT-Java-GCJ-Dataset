import java.util.*;
import java.util.Map.Entry;

import java.math.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// InputReader in = new InputReader(new
		// File("ethan_traverses_a_tree.txt"));
		// PrintWriter out = new PrintWriter(new
		// File("ethan_traverses_a_tree-output.txt"));

		int pi = in.nextInt();
		for (int qi = 1; qi <= pi; qi++) {
			String s = in.next();
			String ans = "";
			int nowInt = 0;
			int nowDeep = 0;
			for (int i = 0; i < s.length(); i++) {
				int k = Integer.valueOf(s.substring(i, i + 1));
				if (k > nowDeep) {
					for (int j = 0; j < k - nowDeep; j++) {
						ans = ans + "(";
					}
				} else if (k < nowDeep) {
					for (int j = 0; j < nowDeep - k; j++) {
						ans = ans + ")";
					}
				}
				ans = ans + k;
				nowDeep = k;
			}
			for (int j = 0; j < nowDeep; j++) {
				ans = ans + ")";
			}
			out.printf("Case #%d: %s\n", qi, ans);
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