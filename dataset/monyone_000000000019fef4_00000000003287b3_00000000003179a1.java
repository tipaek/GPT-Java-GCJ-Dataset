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
				final int U = sc.nextInt();
				
				final int LINES = 10000;
				long[] qs = new long[LINES];
				String[] rs = new String[LINES];
				
				for(int i = 0; i < LINES; i++) {
					qs[i] = sc.nextLong();
					rs[i] = sc.next();
				}
				
				String[] answer = new String[10];
				
				for(int i = 1; i <= 9; i++) {
					SEARCH:
					for(int j = 0; j < LINES; j++) {
						if(qs[j] != i) { continue; }
						
						for(int k = 0; k < i; k++) {
							if(answer[k] == null) { continue; }
							if(answer[k].equals(rs[j])) { continue SEARCH; }
						}
						
						answer[i] = rs[j];
						break;
					}
				}
				
				for(int i = 0; i < LINES; i++) {
					for(int k = 0; k <= 9; k++) {
						if(answer[k] == null) { continue; }
						if(rs[i].contains(answer[k])) {
							rs[i] = rs[i].replace(answer[k], "");
						}
					}
					if(rs[i].isEmpty()) { continue; }
					
					answer[0] = rs[i];
					break;
				}
				
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 10; i++) {
					sb.append(answer[i]);
				}
				
				System.out.printf("Case #%d: %s\n", tt + 1, sb.toString());
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
