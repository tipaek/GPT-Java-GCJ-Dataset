import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Solution {
	
	static int L = 60;
	static long[][] combo;

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		combo = new long[L][L];
		for(int i = 0; i < L; i++) {
			combo[i][0] = 1;
		}
		
		for(int i = 1; i < L; i++) {
			for(int j = 1; j <= i; j++) {
				combo[i][j] = combo[i-1][j-1] + combo[i-1][j];
			}
		}
		/*
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(combo[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			
			int M = N;
			int index = -1;
			for(int i = 0; i < 32; i++) {
				if(((M >> i) & 1) == 1) {
					index = i;
				}
			}
			
			M = N - index;
			//System.out.println("M = " + M);
			
			boolean[][] marked = new boolean[L][L];
			marked[0][0] = true;
			for(int i = 0; i < 32; i++) {
				if(((M >> i) & 1) == 1) {
					for(int j = 0; j < i; j++) {
						marked[i][j] = true;
					}
				}
			}
			
			boolean[][] visited = new boolean[L][L];
			
			ArrayList<Pair> list = new ArrayList<>();
			Pair curr = new Pair(0, 0);
			
			
			boolean onLeft = true;
			while(curr.a < L) {
				list.add(new Pair(curr));
				//System.out.println("curr = " + curr);
				if(onLeft) {
					//System.out.println("Curra, currb = " + curr.a + " " + curr.b);
					if(curr.a < L-1 && marked[curr.a+1][curr.b]) {
						//System.out.println("whoo");
						onLeft = false;
						for(int j = 0; j <= curr.a; j++) {
							list.add(new Pair(curr.a+1, j));
						}
						curr = new Pair(curr.a+1, curr.a+1);
					}
					else {
						curr.a++;
						
					}
				}
				else {
					if(curr.a < L-1 && marked[curr.a+1][curr.b]) {
						onLeft = true;
						for(int j = curr.a+1; j >= 1; j--) {
							list.add(new Pair(curr.a+1, j));
						}
						curr = new Pair(curr.a + 1, 0);
					}
					else {
						curr.a++;
						curr.b++;
					}
				}
			}
			
			list.add(curr);
			
			long sum = 0;
			
			sb.append("Case #" + (1+t) + ":\n");
			for(Pair p : list) {
				int a = p.a;
				int b = p.b;
				
				if(sum < N) {
					sb.append((a+1) + " " + (b+1) + "\n");
					sum += combo[a][b];
				}
			}
			
		}

		System.out.println(sb);
		
	}
	
	
	static class Pair implements Comparable<Pair> {
		int a;
		int b;

		public Pair(int x, int y) {
			a = x;
			b = y;
		}
		
		public Pair(Pair p) {
			a = p.a;
			b = p.b;
		}

		public int compareTo(Pair p2) {
			if (a < p2.a)
				return -1;
			if (a == p2.a) {
				if (b < p2.b)
					return -1;
				if (b == p2.b)
					return 0;
				return 1;
			}
			return 1;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Pair))
				return false;
			Pair p2 = (Pair) o;
			return (a == p2.a && b == p2.b);
		}

		public int hashCode() {
			return (a + " " + b).hashCode();
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
3
1
4
19

  
Case #1:
1 1
Case #2:
1 1
2 1
2 2
3 3
Case #3:
1 1
2 2
3 2
4 3
5 3
5 2
4 1
3 1
*/