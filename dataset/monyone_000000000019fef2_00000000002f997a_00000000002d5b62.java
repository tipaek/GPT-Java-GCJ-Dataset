import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	
	public static int[][] move_dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static String[] move_strs = {"N", "E", "S", "W"};
	
	public static StringBuilder naive_solve(long X, long Y, long limit, long deep, long GX, long GY, long move) {		
		if(GX == X && GY == Y) {
			return new StringBuilder();
		}else if(limit <= deep) {
			return null;
		}
		
		for(int i = 0; i < move_dirs.length; i++) {
			final int[] moves = move_dirs[i];
			
			final long dx = move * moves[0];
			final long dy = move * moves[1];
			
			final StringBuilder result = naive_solve(X + dx, Y + dy, limit, deep + 1, GX, GY, 2 * move);
			if(result != null) {
				return result.append(move_strs[i]);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				final long X = sc.nextLong();
				final long Y = sc.nextLong();
				
				StringBuilder result = null;
				for(long i = 1, deep = 0; i < 1000; i *= 2, deep += 1) {
					result = naive_solve(0, 0, deep, 0, X, Y, 1);
					if(result != null) { break; }
				}
				
				System.out.printf("Case #%d: %s\n", tt + 1, result != null ? result.reverse().toString() : "IMPOSSIBLE");
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
