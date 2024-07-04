import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		long[][] c = new long[30][30];
		c[0][0] = 1;
		for(int i = 0; i < 30; i++) {
			c[i][0] = c[i][i] = 1;
			for(int j = 1; j < i; j++) {
				c[i][j] = c[i-1][j] + c[i-1][j-1];
			}
		}
		while(T-- > 0) {
			sb.append("Case #"+(test++)+":\n");
			long n = sc.nextInt();
			if(n < 31) {
				for(int i = 0; i < n; i++) {
					sb.append(String.format("%d %d\n", 1, i+1));
				}
				continue;
			}
			long val = n-30;
			int x = 0, y = 0;
			long tot = c[x][y];
			x++;
			sb.append("1 1\n");
			val /= 2;
			for(int i = 1; i < 30; i++) {
				if(val % 2 == 1) {
					if(y == 0) {
						for(; y <= i; y++) {
							sb.append(String.format("%d %d\n", x+1, y+1));
							tot += c[x][y];
						}
						y--;
					}
					else {
						for(; y >= 0; y--) {
							sb.append(String.format("%d %d\n", x+1, y+1));
							tot += c[x][y];
						}
						y++;
					}
				}
				else {
					sb.append(String.format("%d %d\n", x+1, y+1));
					tot += c[x][y];
				}
				x++;
				if(y == i) y++;
				val /= 2;
			}
			while(tot < n) {
				sb.append(String.format("%d %d\n", x+1, y+1));
				tot += 1;
				x++;
				if(y > 0) y++;
			}

//			System.out.println("hey "+tot);
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
