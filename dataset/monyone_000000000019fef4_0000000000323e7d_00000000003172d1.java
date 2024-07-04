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

class Solution {
	
	public static class Range implements Comparable<Range> {
		int index, start, end;
		
		public Range(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Range o) {
			if(Integer.compare(this.start, o.start) != 0) {
				return Integer.compare(this.start, o.start);
			}else {
				return Integer.compare(this.end, o.end);
			}
		}
	}
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				final int N = sc.nextInt();
				final int D = sc.nextInt();
				
				long[] as = new long[N];
				for(int i = 0; i < N; i++) {
					as[i] = sc.nextLong();
				}
				
				
				long answer = D - 1;
				for(int i = 0; i < N; i++) {
					long curr = 0;
					long rest = D;
					
					boolean[] used = new boolean[N];
					for(int j = 0; j < N; j++) {
						if(as[i] > as[j]) { continue; }
						
						final long times = ((as[j] - as[i]) / as[i]) + 1;
						final long cut = ((as[j] - as[i]) + (as[i] - 1)) / as[i];
						
						if((as[j] - as[i]) % as[i] == 0 && times <= rest) {
							rest -= times;
							curr += cut;
							used[j] = true;
						}
					}
					
					for(int j = 0; j < N; j++) {
						if(as[i] > as[j]) { continue; }
						if(used[j]) { continue; }
						
						long result = as[j];
						while(result > as[i] && rest > 0) {
							rest -= 1;
							curr += 1;
							result -= as[i];
						}
					}
					
					if(rest == 0) {
						answer = Math.min(answer, curr);
					}
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
