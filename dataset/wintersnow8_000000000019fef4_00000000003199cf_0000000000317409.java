import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int test = sc.nextInt();
		for (int q = 1; q<=test; q++) {
			int x = sc.nextInt(), y = sc.nextInt();
			String m  =sc.next();
			System.out.print("Case #" + q + ": ");
			int x1 = 0, y1 = 0;
			boolean ok = false;
			int ind = 0;
			for (int i = 0; i<m.length(); i++) {
				if (Math.abs(x-x1)+Math.abs(y-y1)<=i) {
					ok = true;
					ind = i;
					//System.out.println(x + " " + y + " " + x1 + " " + y1);
					break;
				}
				if (m.charAt(i) == 'N') {
					y++;
				}
				else if (m.charAt(i) == 'E') {
					x++;
				}
				else if (m.charAt(i) == 'S') {
					y--;
				}
				else {
					x--;
				}
			//	System.out.println(x + " " + y + " " + x1 + " " + y1);
				
			}
			if (Math.abs(x-x1)+Math.abs(y-y1)<=m.length() && !ok) {
				ok = true;
				ind = m.length();
				//System.out.println(x + " " + y + " " + x1 + " " + y1);
			}
			if (!ok) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(ind);
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