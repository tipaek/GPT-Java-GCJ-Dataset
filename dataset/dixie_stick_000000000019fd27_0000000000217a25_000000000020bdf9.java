import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Solution {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			
			Query[] queries = new Query[N];
			for(int i = 0; i < N; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				queries[i] = new Query(a, b, i);
			}
			
			
			Arrays.sort(queries);
			
			//System.out.println("queries = " + Arrays.toString(queries));
			
			int count = 0;
			int lateTime = -1;
			for(int i = 0; i < N; i++) {
				Query q = queries[i];
				if(lateTime <= q.a) {
					lateTime = q.b;
					q.parent = 'C';
					count++;
				}
			}
			
			lateTime = -1;
			for(int i = 0; i < N; i++) {
				Query q = queries[i];
				if(q.parent == '?') {
					if(lateTime <= q.a) {
						lateTime = q.b;
						q.parent = 'J';
						count++;
					}
				}
			}
			
			sb.append("Case #" + (t+1) + ": ");
			if(count == N) {
				
				char[] which = new char[N];
				for(int i = 0; i < N; i++) {
					int index = queries[i].index;
					which[index] = queries[i].parent;
				}
				for(char c: which) {
					sb.append(c);
				}
			}
			else {
				sb.append("IMPOSSIBLE");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static class Query implements Comparable<Query> {
		int a, b;
		int index;
		char parent;
		
		public Query(int a, int b, int index) { 
			this.a = a;
			this.b = b;
			this.index = index;
			parent = '?';
		}
		
		public int compareTo(Query q) {
			if(b != q.b) {
				return b - q.b;
			}
			return a - q.a;
		}
		
		public String toString() {
			return "Q[" + a + ", " + b + ", " + index + "]";
		}
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}
/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

  
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC

1
6
5 10
3 5
12 14
10 12
1 3
2 20
*/