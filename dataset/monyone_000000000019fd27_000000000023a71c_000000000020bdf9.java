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
				
				PriorityQueue<Range> fst_queue = new PriorityQueue<Range>();
				PriorityQueue<Range> snd_queue = new PriorityQueue<Range>();
				
				for(int i = 0; i < N; i++) {
					final int S = sc.nextInt();
					final int E = sc.nextInt();
					
					fst_queue.add(new Range(i, S, E));
				}
				
				boolean ok = true;
				char[] answer = new char[N];
				
				{
					int last_time = 0;
					while(!fst_queue.isEmpty()) {
						final Range range = fst_queue.poll();
						
						if(range.start < last_time) {
							snd_queue.add(range);
							continue;
						}
						
						last_time = range.end;
						answer[range.index] = 'J';
					}
				}
				
				{
					int last_time = 0;
					while(!snd_queue.isEmpty()) {
						final Range range = snd_queue.poll();
						
						if(range.start < last_time) {
							ok = false;
							break;
						}
						
						last_time = range.end;
						answer[range.index] = 'C';
					}
				}
				
				
				System.out.printf("Case #%d: %s\n", tt + 1, ok ? (new StringBuilder().append(answer).toString()) : "IMPOSSIBLE");
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
