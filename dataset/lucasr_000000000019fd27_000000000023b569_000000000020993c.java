import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			int N = sc.nextInt();
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int k = 0, r = 0, c = 0;
			for (int i = 0; i < N; i++) {
				k += mat[i][i];
			}
			for (int i = 0; i < N; i++) {
				boolean[] got = new boolean[N];
				for (int j = 0; j < N; j++) {
					got[mat[i][j] - 1] = true;
				}
				for (int j = 0; j < N; j++) {
					if (!got[j]) {
						r++;
						break;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				boolean[] got = new boolean[N];
				for (int i = 0; i < N; i++) {
					got[mat[i][j] - 1] = true;
				}
				for (int i = 0; i < N; i++) {
					if (!got[i]) {
						c++;
						break;
					}
				}
			}
			out.println("Case #" + caze + ": " + k + " " + r + " " + c);
			
			out.flush();
		}
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
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
	}
}
