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
				final int X = sc.nextInt();
				final int Y = sc.nextInt();
				final char[] chs = sc.next().toCharArray();
				
				int px = X, py = Y;
				
				int answer = -1;
				for(int i = 0; i < chs.length; i++) {
					switch(chs[i]) {
					case 'N': py++; break;
					case 'S': py--; break;
					case 'E': px++; break;
					case 'W': px--; break;
					}
					
					final int dist = Math.abs(px) + Math.abs(py);
					if(dist <= (i + 1)) {
						answer = (i + 1); break;
					}
				}
				
				System.out.printf("Case #%d: %s\n", tt + 1, answer >= 0 ? answer : "IMPOSSIBLE");
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
