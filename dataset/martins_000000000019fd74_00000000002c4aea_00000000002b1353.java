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
			long dif = 0;
			while(adjust(n-dif) > n) {
				dif++;
			}
			LinkedList<Integer> heights = new LinkedList<>();
			for(int i = 0; i < 30; i++) {
				if( ((n-dif) & (1 << i)) > 0 ) heights.add(i);
			}
			int m = heights.get(heights.size()-1);
			int c = 0;
			for(int i = 0; i <= m; i++) {
				if(i == heights.getFirst()) {
					if(c % 2 == 0) {
						for(int j = 0; j <= i; j++) {
							sb.append(String.format("%d %d\n", i+1, j+1));
						}
					}
					else {
						for(int j = i; j >= 0; j--) {
							sb.append(String.format("%d %d\n", i+1, j+1));
						}
					}
					c++; heights.removeFirst();
				}
				else {
					if(c % 2 == 0) {
						sb.append(String.format("%d %d\n", 1, i+1));
					}
					else {
						sb.append(String.format("%d %d\n", i+1, i+1));
					}
				}
			}
			long adj = adjust(n-dif);
			for(int i = 0; i < n-adj; i++) {
				if(c % 2 == 0) {
					sb.append(String.format("%d %d\n", m+i+2, 1));
				}
				else {
					sb.append(String.format("%d %d\n", m+i+2, m+i+2));
				}
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	static long adjust(long x) {
		long res = 0;
		long add = 1;
		while(x > 0) {
			if(x % 2 == 1) res += add;
			else res += 1;
			add *= 2;
			x /= 2;
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
