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
				final char[] chs = sc.next().toCharArray();
				
				StringBuilder answer = new StringBuilder();
				int current_depth = 0;
				for(final char ch : chs) {
					int depth = ch - '0';
					
					while(current_depth != depth) {
						if(depth > current_depth) {
							answer.append("(");
							current_depth++;
						}else {
							answer.append(")");
							current_depth--;
						}
					}
					answer.append(ch);
				}
				
				while(current_depth > 0) {
					answer.append(")");
					current_depth--;
				}
				
				System.out.printf("Case #%d: %s\n", tt + 1, answer);
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
