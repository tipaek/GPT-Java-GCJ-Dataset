import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				final int N = sc.nextInt();
				
				int[][] board = new int[N][N]; 
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						board[i][j] = sc.nextInt();
					}
				}
				
				int trace = 0;
				for(int i = 0; i < N; i++) {
					trace += board[i][i];
				}
				
				int r = 0;
				for(int i = 0; i < N; i++) {					
					for(int j = 0; j < N; j++) {
						int count = 0;
						
						for(int k = 0; k < N; k++) {
							count += board[i][j] == board[i][k] ? 1 : 0;
						}
						
						r = Math.max(r, count);
					}
				}
				
				int c = 0;
				for(int j = 0; j < N; j++) {
					for(int i = 0; i < N; i++) {
						int count = 0;
						
						for(int k = 0; k < N; k++) {
							count += board[i][j] == board[k][j] ? 1 : 0;
						}
						
						c = Math.max(c, count);
					}
				}
				
				System.out.printf("Case #%d: %d %d %d\n", tt + 1, trace, r == 1 ? 0 : r, c == 1 ? 0 : c);
			}
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
		
		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}
 
		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() {
			getLine();
			return tok.nextToken();
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
 
		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
