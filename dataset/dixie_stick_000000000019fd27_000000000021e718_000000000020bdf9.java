import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Solution {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			
			Pair[] pairs = new Pair[N];
			for(int i = 0; i < N; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				Pair p = new Pair(a, b, i);
				
				pairs[i] = p;
			}
			
			Arrays.sort(pairs);
			
			ArrayList<Pair> first = new ArrayList<>();
			ArrayList<Pair> second = new ArrayList<>();
			
			boolean valid = true;
			for(int i = 0; i < N; i++) {
				Pair p = pairs[i];
				if(first.isEmpty()) {
					first.add(p);
					continue;
				}
				
				if(second.isEmpty()) {
					second.add(p);
					continue;
				}
				
				Pair prevA = first.get(first.size() - 1);
				Pair prevB = second.get(second.size() - 1);
				
				if(p.intersects(prevA) && p.intersects(prevB)) {
					valid = false;
					break;
				}
				
				if(p.intersects(prevA)) {
					second.add(p);
					continue;
				}
				else {
					first.add(p);
				}
			}
			
			if(!valid) {
				sb.append("Case #" + (1+t) + ": IMPOSSIBLE\n");
				continue;
			}
			else {
				int[] which = new int[N];
				for(Pair p : first) {
					int index = p.index;
					which[index] = (int) 'C';
				}
				
				for(Pair p : second) {
					int index = p.index;
					which[index] = (int) 'J';
				}
				
				sb.append("Case #" + (1+t) + ": ");
				for(int i : which) {
					char c = (char) i;
					sb.append(c);
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
	
	public static class Pair implements Comparable<Pair> {
		int a, b;
		char parent;
		int index;
		
		public Pair(int a, int b, int index) {
			this.a = a;
			this.b = b;
			this.parent = '?';
			this.index = index;
		}
		
		public int compareTo(Pair p) {
			if(a != p.a) {
				return a - p.a;
			}
			
			return b - p.b;
		}
		
		public boolean intersects(Pair p) {
			if(b <= p.a || p.b <= a) {
				return false;
			}
			return true;
		}
		
		public String toString() {
			return "(" + a + ", " + b + ")";
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