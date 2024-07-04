import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int t = sc.nextInt();
		for (int q = 1; q<=t; q++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] mat = new int[n][n];
			String ver = "";
			if (k%n != 0) {
				ver = "IMPOSSIBLE";
				System.out.println("Case #" + q + ": " + ver);
			}
			else {
				ver = "POSSIBLE";
				for (int i = 0; i<n; i++) {
					int counter = k/n;
					for (int j = i; j<n; j++) {
						mat[j][i] = counter;
						counter++;
						if (counter == n+1) {
							counter = 1;
						}
					}
					for (int j = 0; j<i;j++) {
						mat[j][i] = counter;
						counter++;
						if (counter == n+1) {
							counter = 1;
						}
					}
				}
				System.out.println("Case #" + q + ": " + ver);
				for (int i = 0; i<n; i++ ) {
					for (int j = 0; j<n; j++) {
						System.out.print(mat[i][j] + " ");
					}
					System.out.println();
				}
			}
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
		new Solution().run();
	}
}