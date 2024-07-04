import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;		
//		long[][] c = new long[30][30];
//		c[0][0] = 1;
//		for(int i = 0; i < 30; i++) {
//			c[i][0] = c[i][i] = 1;
//			for(int j = 1; j < i; j++) {
//				c[i][j] = c[i-1][j] + c[i-1][j-1];
//			}
//		}
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			sb.append("Case #"+test+":\n"); test++;
			long n = sc.nextLong();
			if(n == 501) {
				sb.append("1 1\n2 2\n3 3\n3 2\n3 1\n");
				for(int i = 0; i < 501-6; i++) {
					sb.append(String.format("%d %d\n", i+4, 1));
				}
			}
			else {
				for(int i = 0; i < n; i++) {
					sb.append(String.format("%d %d\n", i+1, 1));
				}
			}

		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
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
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
