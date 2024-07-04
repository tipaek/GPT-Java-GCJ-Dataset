import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class D {

	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			final int B = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				int[] arr = new int[B];
				for(int i = 0; i < 150; i++) {
					System.out.println((i % B) + 1);
					arr[i % B] = sc.nextInt();
				}
				
				for(int i = 0; i < B; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
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
