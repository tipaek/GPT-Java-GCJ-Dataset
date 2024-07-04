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
			final long A = sc.nextLong();
			final long B = sc.nextLong();
			final long SIZE = 2 * 1000000000;
			
			LOOP:
			for(int tt = 0; tt < T; tt++){

				for(int dx = -10; dx <= 10; dx++) {
					for(int dy = -10; dy <= 10; dy++) {
						final long x = dx;
						final long y = dy;
						
						System.out.println(x + " " + y);
						System.out.flush();
						final String result = sc.next();
						
						if(result.equals("CENTER")) {
							continue LOOP;
						}else if(result.equals("WRONG")) {
							return;
						}
					}
				}
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
