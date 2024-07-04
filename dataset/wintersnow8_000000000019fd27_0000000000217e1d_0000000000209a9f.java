import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int t = sc.nextInt();
		for (int i = 1; i<=t; i++ ) {
			String s = sc.next();
			String ans = "";
			int val = Integer.parseInt(s.substring(0,1));
			for (int j = 0; j<val; j++) {
				ans+="(";
			}
			ans+=val;
			int counter = val;
			for (int j = 1; j<s.length(); j++) {
				val = Integer.parseInt(s.substring(j,j+1));
				if (counter<val) {
					for (int a = 0; a<val-counter; a++) {
						ans+="(";
					}
				}
				else if (counter>val) {
					for (int a = 0; a<counter-val; a++) {
						ans+=')';
					}
				}
				ans+=val;
				counter = val;
			}
			for (int j = 0; j<counter; j++ ) {
				ans+=")";
			}
			System.out.println("Case #" + i + ": " + ans);
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