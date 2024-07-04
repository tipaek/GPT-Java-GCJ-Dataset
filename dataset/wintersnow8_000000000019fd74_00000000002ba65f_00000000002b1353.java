import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int test = sc.nextInt();
		for (int q = 1; q<=test; q++ ) {
			int n = sc.nextInt();
			System.out.println("Case #" + q + ": ");
			if (n == 1) {
				System.out.println(1 + " " + 1);
			}
			else if (n == 2) {
				System.out.println(1 + " " + 1);
				System.out.println(2 + " " + 1);
			}
			else if (n<=501) {
				System.out.println(1 + " " + 1);
				System.out.println(2 + " " + 2);
				System.out.println(2 + " " + 1);
				for (int i =3; i<n; i++ ) {
					System.out.println(i + " " + 1);
				}
			}
			else {
				int sum = 3;
				int stop = 2;
				System.out.println(1 + " " + 1);
				System.out.println(2 + " " + 2);
				System.out.println(2 + " " + 1);
				for (int i = 3; i<n; i++ ) {
					sum+=i-1;
					if (sum>n) {
						sum-=i-1;
						stop = i;
						break;
					}
					System.out.println(i + " " +2);
					if (sum == n) break;
				}
				if (sum<n) {
					for (int i = 0; i<n-sum; i++ ) {
						System.out.println(stop + " " + 1);
						stop++;
					}
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