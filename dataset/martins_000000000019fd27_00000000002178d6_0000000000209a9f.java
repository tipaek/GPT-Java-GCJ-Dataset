import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			char[] s = sc.next().toCharArray();
			sb.append(String.format("Case #%d: ", test++));
			int level = 0;
			for(char c: s) {
				if(c-'0' > level) {
					for(int i = 0; i < c-'0'-level; i++) {
						sb.append('(');
					}
				}
				else if(c - '0' < level) {
					for(int i = 0; i < level - (c-'0'); i++) {
						sb.append(')');
					}
				}
				sb.append(c);
				level = c-'0';
			}
			for(int i = 0; i < level; i++) {
				sb.append(')');
			}
			sb.append("\n");
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
