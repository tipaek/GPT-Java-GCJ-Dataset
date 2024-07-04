import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int k = 0;
			for(int i = 0; i < n; i++) {
				k += arr[i][i];
			}
			int r = 0, c = 0;
			for(int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<>();
				for(int j = 0; j < n; j++) {
					if(set.contains(arr[i][j])) {
						r++; break;
					}
					else set.add(arr[i][j]);
				}
				set = new HashSet<>();
				for(int j = 0; j < n; j++) {
					if(set.contains(arr[j][i])) {
						c++; break;
					}
					else set.add(arr[j][i]);
				}
			}
			sb.append(String.format("Case #%d: %d %d %d\n", test++, k, r, c));
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
