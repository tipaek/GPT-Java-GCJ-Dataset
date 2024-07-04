import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			sb.append("Case #"+test+": "); test++;
			long x = sc.nextLong();
			long y = sc.nextLong();
			if((Math.abs(x)+Math.abs(y)) % 2 == 0) {
				sb.append("IMPOSSIBLE\n"); continue;
			}
			String code = "EWNS";
			long[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
			long e = log2(Math.abs(x)+Math.abs(y));
			StringBuilder rev = new StringBuilder();
			for(long i = e-1; i >= 0; i--) {
				long x2, y2;
				for(int d = 0; d < 4; d++) {
					x2 = x + (1L << i)*dir[d][0];
					y2 = y + (1L << i)*dir[d][1];
					if(log2(Math.abs(x2)+Math.abs(y2)) <= i) {
						rev.append(code.charAt(d));
						x = x2; y = y2; break; 
					}
				}
			}
			sb.append(rev.reverse()+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	static int log2(long x) {
		int res = 0;
		while(x > 0) {
			res++; x >>= 1;
		}
		return res;
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
