import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Vestigium {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int t = sc.nextInt();
		for (int q = 1; q<=t; q++ ) {
			int n = sc.nextInt();
			int[][] mat = new int[n][n];
			int k = 0;
			for (int i= 0; i<n; i++ ) {
				for (int j = 0; j<n; j++) {
					mat[i][j] = sc.nextInt();
					if (i == j) {
						k+=mat[i][j];
					}
				}
			}
			int r = 0;
			int c = 0;
			for (int i = 0; i<n;i++) {
				Set<Integer> set = new HashSet<Integer>();
				for (int j = 0; j<n; j++ ) {
					set.add(mat[i][j]);
				}
				if (set.size()!=n) r++;
			}
			for (int i = 0; i<n;i++) {
				Set<Integer> set = new HashSet<Integer>();
				for (int j = 0; j<n; j++ ) {
					set.add(mat[j][i]);
				}
				if (set.size()!=n) c++;
			}
			System.out.println("Case #" + q + ": " + k + " " + r + " " + c);
		}
	}
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
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

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
	public static void main (String[] args) throws Exception {
		new Vestigium().run();
	}
}