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
			int n = in.nextInt();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = in.nextInt();
				}
			}

			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += a[i][i];
			}

			int r = 0;
			int c = 0;
			for (int i = 0; i < n; i++) {
				Set<Integer> set = new HashSet<Integer>();
				for (int j = 0; j < n; j++) {
					set.add(a[i][j]);
				}
				if (set.size() < n) {
					r++;
				}

				set.clear();
				for (int j = 0; j < n; j++) {
					set.add(a[j][i]);
				}
				if (set.size() < n) {
					c++;
				}

			}

			out.printf("Case #%d: %d %d %d\n", qi, sum, r, c);
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