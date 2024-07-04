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
			int r = sc.nextInt();
			int s = sc.nextInt();
			StringBuilder res = new StringBuilder();
			int size = 0;
			for(int i = 0; i < r-1; i++) {
				int a = (s-i)*(r-i-1), b = r-i;
				for(int j = 0; j < s-1; j++) {
					res.append(a+" "+b+"\n");
					a--;
					size++;
				}
			}
			sb.append(size+"\n");
			sb.append(res);
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
